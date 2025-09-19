package com.jesus.commons.dto;

import java.sql.Date;

public record ReservaResponse(
	Long id,
	String huesped,
	Long habitacion,
	Date fechaEntrada,
	Date fecheSalida,
	Long noches,
	Double total,
	String estado
) {}
