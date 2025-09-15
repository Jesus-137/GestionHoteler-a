package com.jesus.commons.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductoRequest(
	@NotBlank(message = "El nombre es requerido")
	@Size(min = 1, max=30, message = "El nombre tiene que estar entre un rango de 1 a 30 caracteres")
	String nombre,
	@NotBlank(message = "La descripcion es requerida")
	@Size(min = 1, max=50, message = "La descripcion tiene que estar entre un rango de 1 a 50 caracteres")
	String descripcion,
	@NotNull(message = "El precio es requerido")
	@Positive(message = "El precio tiene que ser positivo")
	Double precio,
	@NotNull(message = "El stock es requerido")
	@Positive(message = "El stock tiene que ser positivo")
	Integer stock,
	@NotNull(message = "El id de la categoria es requerido")
	@Positive(message = "El id de la categoria tiene que ser positivo")
	Long idCategoria,
	@NotNull(message = "El id del proveedor es requerido")
	@Size(min = 1, message = "Tiene que tener almenos un proveedor")
	Set<Long> idProveedor
) {}
