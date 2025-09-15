package com.jesus.commons.services;

import java.util.List;

public interface CommonService <RQ,RS>{
	List<RS> listar();
	RS ObtenerPorId(long id);
	RS Insertar(RQ request);
	RS actualizar(RQ request, Long id);
	RS eliminar(long id);
	
}
