package com.jesus.commons.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProveedorRequest(
	@NotBlank(message = "El nombre es requerido")
	@Size(min = 1, max=30, message = "El nombre tiene que estar entre un rango de 1 a 30 caracteres")
	String nombre,
	@NotBlank(message = "La direccion es requerido")
	@Size(min = 1, max=100, message = "La direccion tiene que estar entre un rango de 1 a 100 caracteres")
	String direccion
) {}
