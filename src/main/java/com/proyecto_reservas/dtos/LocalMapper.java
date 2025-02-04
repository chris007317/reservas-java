package com.proyecto_reservas.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.proyecto_reservas.dtos.requests.LocalRequest;
import com.proyecto_reservas.dtos.response.LocalResponse;
import com.proyecto_reservas.entities.Local;

@Mapper(componentModel = "spring")

public interface LocalMapper {
	LocalMapper mapper = Mappers.getMapper(LocalMapper.class);
	
	Local local(LocalRequest localRequest);
	
	LocalResponse localResponse(Local local);
	
	void actualizarLocal(@MappingTarget Local local, LocalRequest localRequest);
}
