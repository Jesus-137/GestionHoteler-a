package com.christian.oauth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

public record UsuarioRequest(
		@NotBlank(message = "El username es requerido")
		@Size(min = 5, max = 20, message = "El username debe tener entre 5 y 20 caracteres")
		String username,
		@NotBlank(message = "La password es requerida")
		@Size(min = 8,  message = "La password debe tener al menos 8 caracteres")
		String password,
		@NotNull(message = "Los roles son requeridos")
		@Size(min = 1,  message = "El usuario debe tener al menos 1 rol")
		Set<String> roles
)
{}