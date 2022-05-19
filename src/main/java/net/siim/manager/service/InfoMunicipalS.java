package net.siim.manager.service;

import net.siim.manager.model.*;
import net.siim.manager.pagination.DataTableResults;
import net.siim.manager.util.DataResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface InfoMunicipalS {
    DataTableResults<ViewPersona> listarPersona(HttpServletRequest request);

    DataTableResults<ViewLiquidacion> listarLiquidacion(HttpServletRequest request, String id);

    DataTableResults<ViewTramiteOrden> listarTramiteOrden(HttpServletRequest request, String id);

    DataTableResults<ViewInmueble> listarInmueble(HttpServletRequest request, String id);

    DataTableResults<ViewRecaudacionInmueble> listarRecaudacionInmueble(HttpServletRequest request, String id);

    DataTableResults<ViewConstruccion> listarConstruccion(HttpServletRequest request, String id, String idInmueble);

    DataTableResults<ViewDeudorGestion> listarDeudorGestion(HttpServletRequest request);

    List<Barrio> listarBarrios();

    DataResponse consultarDeuda(String documento, String pmc);
}
