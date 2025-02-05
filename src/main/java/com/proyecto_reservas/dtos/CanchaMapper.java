package com.proyecto_reservas.dtos;

import org.hibernate.annotations.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.proyecto_reservas.dtos.requests.CanchaRequest;
import com.proyecto_reservas.dtos.response.CanchaResponse;
import com.proyecto_reservas.dtos.response.LocalDatosResponse;
import com.proyecto_reservas.entities.Cancha;

@Mapper(componentModel = "spring")
public interface CanchaMapper {
	CanchaMapper mapper = Mappers.getMapper( CanchaMapper.class );
	
	Cancha cancha(CanchaRequest canchaRequest);
	
	@Mapping(target = "local.id", source = "local.id")
	@Mapping(target = "local.nombre", source = "local.nombre")
	@Mapping(target = "local.direccion", source = "local.direccion")
	CanchaResponse canchaResponse(Cancha cancha);
	
	void ActualizarCancha(@MappingTarget Cancha cancha, CanchaRequest canchaRequest);
}
