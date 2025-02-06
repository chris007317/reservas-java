package com.proyecto_reservas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_reservas.dtos.UsuarioMapper;
import com.proyecto_reservas.dtos.requests.UsuarioRequest;
import com.proyecto_reservas.dtos.response.UsuarioResponse;
import com.proyecto_reservas.entities.Empresa;
import com.proyecto_reservas.entities.Persona;
import com.proyecto_reservas.entities.Usuario;
import com.proyecto_reservas.repositories.EmpresaRepository;
import com.proyecto_reservas.repositories.PersonaRepository;
import com.proyecto_reservas.repositories.UsuarioRepository;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UsuarioServiceImplement implements UsuarioService{
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioResponse RegistrarUsuario(UsuarioRequest usuarioRequest) {
		try {
			Persona persona = personaRepository.findById(usuarioRequest.getIdPersona())
					.orElseThrow(() -> new RuntimeException("Persona no encontrada con el id: " + usuarioRequest.getIdPersona()));
			Empresa empresa = empresaRepository.findByIdAndEstado(usuarioRequest.getIdEmpresa(), true);
			if(empresa == null) throw new RuntimeException("No se encontró la empresa con el id: " + usuarioRequest.getIdEmpresa());
			Usuario usuario = UsuarioMapper.mapper.usuario(usuarioRequest);
			usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));
			usuario.setPersona(persona);
			usuario.setEmpresa(empresa);
			usuario = usuarioRepository.save(usuario);
			return UsuarioMapper.mapper.usuarioResponse(usuario);
		}catch (Exception e) {
			System.err.println("Error al registrar al usuario: " + e.getMessage());
	        throw new RuntimeException("No se pudo registrar el usuario. Por favor, inténtelo nuevamente.");
		}
	}
}
