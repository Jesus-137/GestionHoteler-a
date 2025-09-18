package com.jesus.commons.dto;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public record ReservaRequest(
	@NotNull(message="El id del huesped es requerido")
	@Positive(message="El id del huesped tiene que ser positivo")
	Long idHuesped,
	@NotNull(message="El id del habitacion es requerido")
	@Positive(message="El id del habitacion tiene que ser positivo")
	Long idHabitacion,
	@Future(message = "La fecha debe ser en el futuro")
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date fechaEntrada,
	@Future(message = "La fecha debe ser en el futuro")
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date fecheSalida,
	@NotNull(message="El numero de noches es requerido")
	@Positive(message="El numero de noches tiene que ser positivo")
	Integer noches,
	@NotNull(message="El total es requerido")
	@Positive(message="El total tiene que ser positivo")
	Double total,
	@NotNull(message="El estado es requerido")
	@Min(1)
	@Max(4)
	Integer estado
) {}
