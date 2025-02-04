package com.proyecto_reservas.dtos.response;

import java.time.LocalTime;

import com.proyecto_reservas.entities.Empresa;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LocalResponse {
	private Long id;
	
	private EmpresaResponse empresa;
	
	private String nombre;
	
	private String ciudad;
	
	private String direccion;
	
	private String ubiacion;
	
    private LocalTime horaEntrad;
	
    private LocalTime horaSalida;
	
    private int diaInicio;
	
	private int diaFin;
	
    private double porcentajeReserva;
    
}
