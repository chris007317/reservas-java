package com.proyecto_reservas.dtos.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CanchaResponse {
    private Long id;
	  
    private String nombre;
	
	private double precioDia;
	
	private double precioNoche;
	
	private LocalDatosResponse local;
}
