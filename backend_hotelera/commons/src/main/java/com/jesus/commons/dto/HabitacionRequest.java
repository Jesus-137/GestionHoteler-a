package com.jesus.commons.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record HabitacionRequest(
		
		@NotBlank(message = "El numero de la habitacion es requerido")
		@Positive(message = "El número de la habitación debe ser mayor a 0")
		Long numero,
		
		@NotNull(message = "Los el tipo de habitacion es requerida")
		String tipo,
		
		@NotNull(message = "La descripcion es requerida")
		String descripcion,
		
		@NotNull(message = "La precio es requerido")
		@DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
		Double precio,
		
		@NotNull(message = "La capacidad es requerida es requerida")
		@Min(value = 1, message = "La capacidad debe ser mayor a 0")
		Long capacidad,
		
		@NotNull(message = "El estado es requerida")
		String estado
) {}
