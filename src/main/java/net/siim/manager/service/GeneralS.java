package net.siim.manager.service;

import net.siim.manager.model.General;
import net.siim.manager.pagination.DataTableResults;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface GeneralS {
	General obtener(Integer gestion, Integer cod_suc);
	DataTableResults<General> listado(HttpServletRequest request, boolean estado);
	List<General> listAll();
	Boolean adicionar(General g);
	Boolean modificar(General g);
	Boolean darEstado(Integer gestion,Integer cod_suc,Boolean estado);
	Boolean validarGestion(Integer gestion);
	List<General> listarPorSucursal(Integer cod_suc);
	General existeGestionAnterior(int gestion, int sucursal);
}
