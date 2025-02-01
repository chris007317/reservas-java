package com.proyecto_reservas.services;

import java.util.List;

import com.proyecto_reservas.dtos.requests.PersonaRequest;
import com.proyecto_reservas.dtos.response.PersonaResponse;

public interface PersonaService {
	
	List<PersonaResponse> ListarPersonas(); 
	
	PersonaResponse RegistrarPersona(PersonaRequest personaRequest);
	
	PersonaResponse EditarPersona(Long id, PersonaRequest personaRequest);
}
