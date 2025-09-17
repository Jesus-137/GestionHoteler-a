package com.jesus.authorization.service;

import java.util.Set;

import com.jesus.authorization.dto.UsuarioRequest;
import com.jesus.authorization.dto.UsuarioResponse;

public interface UsuarioService {
	
	Set<UsuarioResponse> listarUsuarios();

	UsuarioResponse crearUsuario(UsuarioRequest request);
	
	UsuarioResponse eliminarUsuario(String username);
}
