package com.proyecto_reservas.dtos.response;

import java.time.LocalTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LocalDatosResponse {
	private Long id;
	
	private String nombre;
	
	private String direccion;
	
}
