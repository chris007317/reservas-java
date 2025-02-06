package com.proyecto_reservas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_reservas.dtos.requests.UsuarioRequest;
import com.proyecto_reservas.dtos.response.UsuarioResponse;
import com.proyecto_reservas.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<?> RegistrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
		try {
			UsuarioResponse usuario = usuarioService.RegistrarUsuario(usuarioRequest);
			return new ResponseEntity<>(usuario, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
