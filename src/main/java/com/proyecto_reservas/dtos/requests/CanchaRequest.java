package com.proyecto_reservas.dtos.requests;

import com.proyecto_reservas.entities.Local;

import lombok.Data;

@Data
public class CanchaRequest {
	private String nombre;
	
	private Long idLocal;
	
	private double precioDia;
	
	private double precioNoche;
	
	private boolean estado = true;
	
	private Integer usuarioEdicion;
}
