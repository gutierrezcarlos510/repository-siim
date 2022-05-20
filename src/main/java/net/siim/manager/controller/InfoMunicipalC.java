package net.siim.manager.controller;

import net.siim.manager.model.*;
import net.siim.manager.pagination.DataTableResults;
import net.siim.manager.service.InfoMunicipalS;
import net.siim.manager.util.DataResponse;
import net.siim.manager.util.GeneradorReportes;
import net.siim.manager.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/infomunicipal/*")
public class InfoMunicipalC {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private InfoMunicipalS infoS;

	@RequestMapping("infoGeneral")
	public String infoGeneral(){
		return "infomunicipal/info-general";
	}
	@RequestMapping("gestion")
	public String gestion(){
		return "infomunicipal/gestion";
	}
	@RequestMapping("gestionDeudor")
	public String gestionDeudores(){
		return "infomunicipal/gestion-deudor";
	}
	@RequestMapping("gestionReporte")
	public String gestionReporte(Model model){
		model.addAttribute("barrios", infoS.listarBarrios());
		return "infomunicipal/gestion-reporte";
	}
	@RequestMapping("listarPersona")
	public @ResponseBody
	DataTableResults<ViewPersona> listarPersona(HttpServletRequest request) {
		try {
			return infoS.listarPersona(request);
		} catch (Exception ex) {
			System.out.println("error listarPersona: "+ex.toString());
			return null;
		}
	}
	@RequestMapping("listarLiquidacion")
	public @ResponseBody
	DataTableResults<ViewLiquidacion> listarLiquidacion(HttpServletRequest request, String id) {
		try {
			return infoS.listarLiquidacion(request, id);
		} catch (Exception ex) {
			System.out.println("error listarLiquidacion: "+ex.toString());
			return null;
		}
	}
	@RequestMapping("listarInmueble")
	public @ResponseBody
	DataTableResults<ViewInmueble> listarInmueble(HttpServletRequest request, String id) {
		try {
			return infoS.listarInmueble(request, id);
		} catch (Exception ex) {
			System.out.println("error listarInmueble: "+ex.toString());
			return null;
		}
	}
	@RequestMapping("listarTramiteOrden")
	public @ResponseBody
	DataTableResults<ViewTramiteOrden> listarTramiteOrden(HttpServletRequest request, String id) {
		try {
			return infoS.listarTramiteOrden(request, id);
		} catch (Exception ex) {
			System.out.println("error listarTramiteOrden: "+ex.toString());
			return null;
		}
	}
	@RequestMapping("listarRecaudacionInmueble")
	public @ResponseBody
	DataTableResults<ViewRecaudacionInmueble> listarRecaudacionInmueble(HttpServletRequest request, String id) {
		try {
			if(id == null)
				id="";
			return infoS.listarRecaudacionInmueble(request, id);
		} catch (Exception ex) {
			System.out.println("error listarRecaudacionInmueble: "+ex.toString());
			return null;
		}
	}
	@RequestMapping("listarConstruccion")
	public @ResponseBody
	DataTableResults<ViewConstruccion> listarConstruccion(HttpServletRequest request, String id, String idInmueble) {
		try {
			return infoS.listarConstruccion(request, id, idInmueble);
		} catch (Exception ex) {
			System.out.println("error listarConstruccion: "+ex.toString());
			return null;
		}
	}
	@RequestMapping("listarDeudores")
	public @ResponseBody
	DataTableResults<ViewDeudorGestion> listarDeudores(HttpServletRequest request, String id) {
		try {
			return infoS.listarDeudorGestion(request);
		} catch (Exception ex) {
			System.out.println("error listarConstruccion: "+ex.toString());
			return null;
		}
	}
	@RequestMapping("reporte1")
	public void plantilla1(HttpServletRequest request, HttpServletResponse response, String barrio,String typeReport) {
		try {
			String nameReport="InformeDeudaPorBarrio",nameFile, reportUrl;
			Map<String, Object> parametros;
			reportUrl="/Reportes/"+nameReport+".jasper";
			parametros = new HashMap<String, Object>();
			parametros.put("barrio", barrio);
			GeneradorReportes g = new GeneradorReportes();
			g.generarReporte(response, getClass().getResource(reportUrl),typeReport, parametros, dataSource.getConnection(), nameReport, "inline");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("consulta")
	public @ResponseBody
	DataResponse consulta(String documento,String pmc){
		try {
			Thread.sleep(3000);
			return infoS.consultarDeuda(documento, pmc);
		} catch (Exception e) {
			return new DataResponse(false, e.getMessage());
		}
	}
}