package com.proyecto_reservas.dtos;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proyecto_reservas.dtos.response.EmpresaResponse;
import com.proyecto_reservas.entities.Empresa;

@Mapper(componentModel = "spring")
public interface EmpresaMapper{
	EmpresaMapper mapper = Mappers.getMapper( EmpresaMapper.class );
	
	EmpresaResponse empresaResponse(Empresa empresa);

}