package com.jesus.commons.dto;

import java.util.Set;

public record ProductoResponse(
		String nombre,
		String descripcion,
		Double precio,
		Integer stock,
		String categoria,
		Set<String> proveedores
) {}
