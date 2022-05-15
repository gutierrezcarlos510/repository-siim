package net.siim.manager.service;

import net.siim.manager.util.DataResponse;

public interface EjecucionScriptS {

	DataResponse script1(int num[]);

	DataResponse script2();
	DataResponse script3(int num[],Integer sucursalId);

}