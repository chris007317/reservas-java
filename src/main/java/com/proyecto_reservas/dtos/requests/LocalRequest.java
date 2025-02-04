package com.proyecto_reservas.dtos.requests;

import java.time.LocalTime;

import lombok.Data;

@Data
public class LocalRequest {
	
	private Long idempresa;
	
	private String nombre;
	
	private String ciudad;
	
	private String direccion;
	
	private String ubiacion;
	
    private LocalTime horaEntrad;
	
    private LocalTime horaSalida;
	
    private int diaInicio;
	
	private int diaFin;
	
    private double porcentajeReserva;
	
    private boolean estado = true;
    
    private Integer usuarioEdicion;
}
