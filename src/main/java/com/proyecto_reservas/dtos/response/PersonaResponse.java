package com.proyecto_reservas.dtos.response;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class PersonaResponse {
    private Long id; 

    private String dni;
    
    private String nombre;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String celular;

    private String correo;
}
