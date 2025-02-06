package com.proyecto_reservas.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proyecto_reservas.dtos.requests.UsuarioRequest;
import com.proyecto_reservas.dtos.response.UsuarioResponse;
import com.proyecto_reservas.entities.Usuario;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);
	
	Usuario usuario(UsuarioRequest usuarioRequest);
	
	UsuarioResponse usuarioResponse(Usuario usuario);
}
