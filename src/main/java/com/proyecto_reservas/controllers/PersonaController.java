package com.proyecto_reservas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_reservas.dtos.requests.PersonaRequest;
import com.proyecto_reservas.dtos.response.PersonaResponse;
import com.proyecto_reservas.services.PersonaService;


@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	public List<PersonaResponse> ListarPersonas(){
		return personaService.ListarPersonas();
	}
	
	@PostMapping
	public ResponseEntity<?> RegistrarPersona(@RequestBody PersonaRequest persona) {
	    try {
	        PersonaResponse nuevaPersona = personaService.RegistrarPersona(persona);
	        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> EditarPersona(@PathVariable Long id, @RequestBody PersonaRequest personaRequest) {
	    try {
	        PersonaResponse persona = personaService.EditarPersona(id, personaRequest);
	        return new ResponseEntity<>(persona, HttpStatus.OK);
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> SeleccionarPersonaId(@PathVariable Long id) {
	    try {
	        PersonaResponse persona = personaService.SeleccionarPersonaId(id);
	        return new ResponseEntity<>(persona, HttpStatus.OK);
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	} 
	
	@GetMapping("/buscar/{dni}")
	public ResponseEntity<?> BuscarPersonaDni(@PathVariable String dni) {
	    try {
	        Optional<PersonaResponse> persona = personaService.BuscarPersonaDni(dni);
	        if (persona.isPresent()) {
	            return new ResponseEntity<>(persona.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Persona no encontrada.", HttpStatus.NOT_FOUND);
	        }
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}
}
