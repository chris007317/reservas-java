package com.proyecto_reservas.services;

import com.proyecto_reservas.dtos.requests.UsuarioRequest;
import com.proyecto_reservas.dtos.response.UsuarioResponse;

public interface UsuarioService {
	public UsuarioResponse RegistrarUsuario(UsuarioRequest usuarioRequest);
}
