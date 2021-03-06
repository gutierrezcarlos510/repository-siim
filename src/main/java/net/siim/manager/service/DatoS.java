package net.siim.manager.service;

import net.siim.manager.model.Dato;
import net.siim.manager.model.Persona;

import java.util.Map;

public interface DatoS {
	Map<String, Object> obtenerDato(Long cod);
	Dato obtener(Long cod);
	boolean adicionarDatos(Dato d, Integer obtenidos[]);
	boolean guardarBiometrico(Persona p);
	boolean eliminar(Long cod);
	boolean adicionar(Long cod,String log,String cla);
	boolean validarBiometrico(String biometrico);
	boolean existeLogin(String login);
	boolean cambiarDatos(Long cod, String log, String cla);
}
