package net.siim.manager.service;

import net.siim.manager.model.General;
import net.siim.manager.model.GeneralWrap;
import net.siim.manager.model.NotificacionSucursalWrap;
import net.siim.manager.model.Sucursal;
import net.siim.manager.pagination.DataTableResults;
import net.siim.manager.util.DataResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SucursalS {
	Sucursal obtener(Integer cod_suc);
	DataResponse adicionar(Sucursal s);
	DataResponse modificar(Sucursal s);
	Boolean darEstado(Integer cod_suc,Boolean estado);
	Sucursal getSucursalNow(List<GeneralWrap> generalWrapList, General general);
	List<Sucursal> obtenerPorUsuario(Long codUsu);
	void asignarSucursal(Long codUsu,Integer sucursales[]);
	void adicionarNotificaciones(String titulo, String mensaje, Integer[] sucursales);

	void adicionarNotificacion(String titulo, String mensaje, Integer sucursal);

	void eliminarNotificaciones(Integer sucursales[]);

	void eliminarNotificacion(Integer sucursal);

	List<NotificacionSucursalWrap> listarNotificaciones();

	NotificacionSucursalWrap obtenerNotificacionPorSucursal(Integer sucursal);
	DataTableResults<Sucursal> listado(HttpServletRequest request, boolean estado);
	List<Sucursal> listAll();
}
