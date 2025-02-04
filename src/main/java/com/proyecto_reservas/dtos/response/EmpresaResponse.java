package com.proyecto_reservas.dtos.response;

import lombok.Builder;
import lombok.Getter;

@Builder
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
    
}
