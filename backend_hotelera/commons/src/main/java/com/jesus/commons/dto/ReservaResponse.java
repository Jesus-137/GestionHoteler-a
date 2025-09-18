package com.jesus.commons.dto;

import java.sql.Date;

public record ReservaResponse(
	Long id,
	Long idHuesped,
	Long idHabitacion,
	Date fechaEntrada,
	Date fecheSalida,
	Integer noches,
	Double total,
	String estado
) {}
