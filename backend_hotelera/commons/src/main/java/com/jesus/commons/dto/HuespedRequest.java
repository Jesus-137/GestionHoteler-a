package com.jesus.commons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


import org.hibernate.validator.constraints.UniqueElements;



public record HuespedRequest(
		@NotBlank(message = "El nombre es requerido")
		String nombre,
		@NotBlank(message = "El apellido es requerido")
		String apellido,
		@NotBlank(message = "El email es requerido")
		@Email(message = "Debe ser un email válido")
	    @UniqueElements
		String email,
		@NotBlank(message = "El telefono es requerido")
		@Email(message = "Debe ser un telefono válido")
	    @UniqueElements
		String telefono,
		@NotBlank(message = "El documento es requerido")
		String documento,
		@NotBlank(message = "La nacionalidad es requerido")
		String nacionalidad
		) {

}
