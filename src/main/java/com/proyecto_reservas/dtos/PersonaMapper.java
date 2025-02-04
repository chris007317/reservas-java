package com.proyecto_reservas.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proyecto_reservas.dtos.response.PersonaResponse;
import com.proyecto_reservas.entities.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
	PersonaMapper mapper = Mappers.getMapper( PersonaMapper.class ); 
	
	PersonaResponse personaResponse(Persona persona);
	
	Persona persona (PersonaResponse personaResponse);
}
