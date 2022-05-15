package net.siim.manager.service;

import net.siim.manager.model.Avatar;

import java.util.List;

public interface AvatarS {

	List<Avatar> listar();

    String getValuePorSexo(boolean sexo);
}