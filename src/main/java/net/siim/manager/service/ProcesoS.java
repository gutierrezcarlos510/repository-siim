package net.siim.manager.service;

import net.siim.manager.model.Proceso;
import net.siim.manager.pagination.DataTableResults;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ProcesoS {
	List<Proceso> obtenerProcesos(Integer cod_men);
	List<Proceso> obtenerPorMenu(Integer cod_men);
	DataTableResults<Proceso> listado(HttpServletRequest request, boolean estado);
	List<Proceso> listAll();
	Map<String, Object> obtener(Integer codpro);
	Boolean adicionar(Proceso p);
	Boolean modificar(Proceso p);
	Boolean darEstado(Integer codpro,Boolean estado);
	Boolean validarNom(String nom);
}
