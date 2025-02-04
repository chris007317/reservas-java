package com.proyecto_reservas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_reservas.dtos.PersonaMapper;
import com.proyecto_reservas.dtos.requests.PersonaRequest;
import com.proyecto_reservas.dtos.response.PersonaResponse;
import com.proyecto_reservas.entities.Persona;
import com.proyecto_reservas.repositories.PersonaRepository;


@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<PersonaResponse> ListarPersonas() {
	    List<Persona> personas = personaRepository.findAll();
	    return personas.stream()
	            .map(persona -> PersonaResponse.builder()
	                    .id(persona.getId())
	                    .nombre(persona.getNombre())
	                    .dni(persona.getDni())
	                    .apellidoPaterno(persona.getApellidoPaterno())
	                    .apellidoMaterno(persona.getApellidoMaterno())
	                    .celular(persona.getCelular())
	                    .correo(persona.getCorreo())
	                    .build()
	            )
	            .collect(Collectors.toList());
	}
	
	@Override
	public PersonaResponse RegistrarPersona(PersonaRequest personaRequest) {
		try {
			// Validar que no exista el número del DNI antes de realizar el registro
			if (personaRepository.existsByDni(personaRequest.getDni())) {
	            throw new RuntimeException("La persona con DNI " + personaRequest.getDni() + " ya está registrada.");
	        }
			Persona persona = Persona.builder()
					.dni(personaRequest.getDni())
					.nombre(personaRequest.getNombre())
					.apellidoPaterno(personaRequest.getApellidoPaterno())
					.apellidoMaterno(personaRequest.getApellidoPaterno())
					.celular(personaRequest.getCelular())
					.correo(personaRequest.getCorreo())
					.build();
			persona = personaRepository.save(persona);
			PersonaResponse respuesta = PersonaResponse.builder()
					.id(persona.getId())
					.dni(persona.getDni())
					.nombre(persona.getNombre())
					.apellidoPaterno(persona.getApellidoPaterno())
					.apellidoMaterno(persona.getApellidoPaterno())
					.celular(persona.getCelular())
					.correo(persona.getCorreo())
					.build();
			return respuesta;
		}
		catch (Exception e) {
	        System.err.println("Error al registrar la persona: " + e.getMessage());
	        throw new RuntimeException("No se pudo registrar la persona. Por favor, inténtelo nuevamente.");
	    }
	}
	
	@Override
	public PersonaResponse EditarPersona(Long id, PersonaRequest personaRequest) {
	    // Validar que no exista el número del DNI antes de realizar la edición del registro
	    if (personaRepository.existsByDniAndIdNot(personaRequest.getDni(), id)) {
	        throw new RuntimeException("La persona con DNI " + personaRequest.getDni() + " ya está registrada.");
	    }
	    try {
	        // Buscar la persona por id
	        Persona persona = personaRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Persona no encontrada con el id: " + id));
	        persona.setDni(personaRequest.getDni());
	        persona.setNombre(personaRequest.getNombre());
	        persona.setApellidoPaterno(personaRequest.getApellidoPaterno());
	        persona.setApellidoMaterno(personaRequest.getApellidoMaterno());
	        persona.setCelular(personaRequest.getCelular());
	        persona.setCorreo(personaRequest.getCorreo());

	        persona = personaRepository.save(persona);

	        return PersonaResponse.builder()
	                .id(persona.getId())
	                .dni(persona.getDni())
	                .nombre(persona.getNombre())
	                .apellidoPaterno(persona.getApellidoPaterno())
	                .apellidoMaterno(persona.getApellidoMaterno())
	                .celular(persona.getCelular())
	                .correo(persona.getCorreo())
	                .build();
	    } catch (Exception e) {
	        System.err.println("Error al actualizar la persona: " + e.getMessage());
	        throw new RuntimeException("No se pudo actualizar la persona. Por favor, inténtelo nuevamente.");
	    }
	}
	
	@Override
	public PersonaResponse SeleccionarPersonaId(Long id) {
		Persona persona = personaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Persona no encontrada con el id: " + id));
		return PersonaMapper.mapper.personaResponse(persona);
	}
	
	@Override
	public Optional<PersonaResponse> BuscarPersonaDni(String dni) {
	    Persona persona = personaRepository.findByDni(dni);
	    if (persona == null) {
	        throw new RuntimeException("Persona no encontrada con el DNI: " + dni);
	    }
	    PersonaResponse personaResponse = PersonaResponse.builder()
	            .id(persona.getId())
	            .dni(persona.getDni())
	            .nombre(persona.getNombre())
	            .apellidoPaterno(persona.getApellidoPaterno())
	            .apellidoMaterno(persona.getApellidoMaterno())
	            .celular(persona.getCelular())
	            .correo(persona.getCorreo())
	            .build();

	    return Optional.of(personaResponse);
	}
	
}
