package com.proyecto_reservas.dtos.requests;

import lombok.Data;

@Data
public class UsuarioRequest { 

	private Long idPersona; 
    
    private Long idEmpresa;

    private String username;

    private String password;

    private boolean estado = true;
    
    private Integer usuarioEdicion;
}
