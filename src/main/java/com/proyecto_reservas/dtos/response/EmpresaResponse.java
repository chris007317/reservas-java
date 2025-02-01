package com.proyecto_reservas.dtos.response;

import lombok.Getter;

@Getter
public class EmpresaResponse {

	private Long id;
	
	private PersonaResponse persona;
	
	private String nombre;

    private String codigoQr;
	
    private String celular;
	
    private String tipo;
	
    private String documento;
	
    private String direccion;
    
    private Integer usuarioEdicion;
}
