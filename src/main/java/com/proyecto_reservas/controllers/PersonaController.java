package com.proyecto_reservas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_reservas.entities.Persona;
import com.proyecto_reservas.services.PersonaService;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	public List<Persona> ListarPersonas(){
		return personaService.ListarPersonas();
	}
}
