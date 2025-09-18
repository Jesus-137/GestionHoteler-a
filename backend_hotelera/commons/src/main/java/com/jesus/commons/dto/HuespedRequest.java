package com.jesus.commons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record HuespedRequest(
		@NotBlank(message = "El nombre es requerido")
		@Size(min=3, max=50, message="El nombre tiene que tener entre 3 a 50 caracteres")
		String nombre,
		@NotBlank(message = "El apellido es requerido")
		@Size(min=3, max=50, message="El apellido tiene que tener entre 3 a 50 caracteres")
		String apellido,
		@NotBlank(message = "El email es requerido")
		@Email(message = "Debe ser un email válido")
		String email,
		@NotBlank(message = "El telefono es requerido")
		@Pattern(regexp = "^[0-9\\-\\+\\s]+$", message = "Debe ser un teléfono válido")
		@Size(min = 10, max = 10, message = "El teléfono debe tener 10 caracteres")
		String telefono,
		@NotNull(message = "El documento es requerido")
		@Min(1)
		@Max(2)
		Integer documento,
		@NotBlank(message = "La nacionalidad es requerido")
		@Size(min=3, max=50, message="La nacionalidad tiene que tener entre 3 a 50 caracteres")
		String nacionalidad
) {}
