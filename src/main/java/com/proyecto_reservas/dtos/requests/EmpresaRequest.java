package com.proyecto_reservas.dtos.requests;

import lombok.Data;

@Data
public class EmpresaRequest {
	
	private Long idPersona;
	
    private String nombre;

    private String codigoQr;
	
    private String celular;
	
    private String tipo;
	
    private String documento;
	
    private String direccion;
    
    private Integer usuarioEdicion;
    
    private Boolean estado = true;
}
