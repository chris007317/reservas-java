package com.proyecto_reservas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto_reservas.dtos.requests.PersonaRequest;
import com.proyecto_reservas.dtos.response.PersonaResponse;
import com.proyecto_reservas.entities.Persona;

public interface PersonaService {
	
	List<PersonaResponse> ListarPersonas(); 
	
	PersonaResponse RegistrarPersona(PersonaRequest personaRequest);
	
	PersonaResponse EditarPersona(Long id, PersonaRequest personaRequest);
	
	PersonaResponse SeleccionarPersonaId(Long id);
	
	Optional<PersonaResponse> BuscarPersonaDni(String dni);
	
	Page<Persona> paginadoListarPersona(Pageable pageable);
}
