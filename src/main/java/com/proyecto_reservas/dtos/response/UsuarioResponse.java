package com.proyecto_reservas.dtos.response;

import com.proyecto_reservas.entities.Persona;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class UsuarioResponse {
    private Long id; 

    private Persona persona; 

    private String username;
}
