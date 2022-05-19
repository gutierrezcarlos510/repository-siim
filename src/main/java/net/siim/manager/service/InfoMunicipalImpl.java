package net.siim.manager.service;

import net.siim.manager.model.*;
import net.siim.manager.pagination.DataTableResults;
import net.siim.manager.pagination.SqlBuilder;
import net.siim.manager.util.DataResponse;
import net.siim.manager.util.DbConeccion;
import net.siim.manager.util.UtilDataTableS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.List;

@Service
public class InfoMunicipalImpl extends DbConeccion implements InfoMunicipalS {
	private JdbcTemplate db;
	@Autowired
	public InfoMunicipalImpl(DataSource dataSource) {
		this.db = new JdbcTemplate(dataSource);		
	}
	@Autowired
	private UtilDataTableS utilDataTableS;
	@Override
	public DataTableResults<ViewPersona> listarPersona(HttpServletRequest request) {
		try {
			SqlBuilder sqlBuilder = new SqlBuilder("view_persona");
			sqlBuilder.setSelect("*");
			return utilDataTableS.list(request, ViewPersona.class, sqlBuilder);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}
	@Override
	public DataTableResults<ViewLiquidacion> listarLiquidacion(HttpServletRequest request, String id) {
		try {
			SqlBuilder sqlBuilder = new SqlBuilder("view_liquidacion");
			sqlBuilder.setSelect("*");
			sqlBuilder.setWhere("id=:xid");
			sqlBuilder.addParameter("xid", id);
			return utilDataTableS.list(request, ViewLiquidacion.class, sqlBuilder);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}
	@Override
	public DataTableResults<ViewTramiteOrden> listarTramiteOrden(HttpServletRequest request, String id) {
		try {
			SqlBuilder sqlBuilder = new SqlBuilder("view_tramite_orden");
			sqlBuilder.setSelect("*");
			sqlBuilder.setWhere("id=:xid");
			sqlBuilder.addParameter("xid", id);
			return utilDataTableS.list(request, ViewTramiteOrden.class, sqlBuilder);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}
	@Override
	public DataTableResults<ViewInmueble> listarInmueble(HttpServletRequest request, String id) {
		try {
			SqlBuilder sqlBuilder = new SqlBuilder("view_inmueble");
			sqlBuilder.setSelect("*");
			sqlBuilder.setWhere("id=:xid");
			sqlBuilder.addParameter("xid", id);
			return utilDataTableS.list(request, ViewInmueble.class, sqlBuilder);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}
	@Override
	public DataTableResults<ViewRecaudacionInmueble> listarRecaudacionInmueble(HttpServletRequest request, String id) {
		try {
			SqlBuilder sqlBuilder = new SqlBuilder("view_recaudacion_inmueble");
			sqlBuilder.setSelect("*");
			sqlBuilder.setWhere("id=:xid");
			sqlBuilder.addParameter("xid", id);
			return utilDataTableS.list(request, ViewRecaudacionInmueble.class, sqlBuilder);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}
	@Override
	public DataTableResults<ViewConstruccion> listarConstruccion(HttpServletRequest request, String id, String idInmueble) {
		try {
			SqlBuilder sqlBuilder = new SqlBuilder("view_recaudacion_inmueble");
			sqlBuilder.setSelect("*");
			sqlBuilder.setWhere("id=:xid");
			sqlBuilder.addParameter("xid", id);
			sqlBuilder.setWhere("id_inmu=:xinmu");
			sqlBuilder.addParameter("xinmu", idInmueble);
			return utilDataTableS.list(request, ViewConstruccion.class, sqlBuilder);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}
	public DataTableResults<ViewDeudorGestion> listarDeudorGestion(HttpServletRequest request) {
		try {
			SqlBuilder sqlBuilder = new SqlBuilder("view_deudor_gestion dg");
			sqlBuilder.setSelect("dg.*");
			sqlBuilder.addJoin("satinmus inmu on inmu.id = dg.id and inmu.id_inmu = dg.id_inmu and inmu.estado = 1");
			return utilDataTableS.list(request, ViewDeudorGestion.class, sqlBuilder);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}
	public List<Barrio> listarBarrios(){
		return db.query("select * from satbarri", BeanPropertyRowMapper.newInstance(Barrio.class));
	}
	public DataResponse consultarDeuda(String documento, String pmc) {
		try {
			if(documento != null || pmc !=null) {
				if(!documento.isEmpty()) {
					List<ViewPersona> per = db.query("select * from view_persona where documento =?", BeanPropertyRowMapper.newInstance(ViewPersona.class), documento);
					if(per != null && !per.isEmpty()) {
						return new DataResponse(true,db.query("select * from view_deudor_gestion where documento = ?", BeanPropertyRowMapper.newInstance(ViewDeudorGestion.class), documento),"Se realizo la consulta exitosamente");
					} else {
						return new DataResponse(false,"No se encontro al usuario");
					}

				}else {
					if(!pmc.isEmpty()) {
						List<ViewPersona> per = db.query("select * from view_persona where id =?", BeanPropertyRowMapper.newInstance(ViewPersona.class), pmc);
						if(per != null && !per.isEmpty()) {
							return new DataResponse(true,db.query("select * from view_deudor_gestion where id = ?", BeanPropertyRowMapper.newInstance(ViewDeudorGestion.class), pmc),"Se realizo la consulta exitosamente");
						} else {
							return new DataResponse(false,"No se encontro al usuario");
						}
					} else {
						return new DataResponse(false, "No se ingreso parametros");
					}
				}
			} else {
				return new DataResponse(false, "No se ingresaron parametros");
			}
		} catch (Exception ex) {
			return new DataResponse(false, "Error al realizar la consulta");
		}
	}
}
