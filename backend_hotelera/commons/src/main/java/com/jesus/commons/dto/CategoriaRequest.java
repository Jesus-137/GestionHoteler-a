package com.jesus.commons.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequest(
	@NotBlank(message = "El nombre es requerido")
	@Size(min = 1, max=30, message = "El nombre tiene que estar entre un rango de 1 a 30 caracteres")
	String nombre,
	@NotBlank(message = "La descripcion es requerida")
	@Size(min = 1, max=50, message = "La descripcion tiene que estar entre un rango de 1 a 50 caracteres")
	String descripcion
) {}
