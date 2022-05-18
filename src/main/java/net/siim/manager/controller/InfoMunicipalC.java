package net.siim.manager.controller;

import net.siim.manager.model.*;
import net.siim.manager.pagination.DataTableResults;
import net.siim.manager.service.InfoMunicipalS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/infomunicipal/*")
public class InfoMunicipalC {
	
	@Autowired
	private InfoMunicipalS infoS;

	@RequestMapping("gestion")
	public String gestion(){
		return "infomunicipal/gestion";
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
}