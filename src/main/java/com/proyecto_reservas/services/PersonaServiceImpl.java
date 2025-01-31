package com.proyecto_reservas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_reservas.entities.Persona;
import com.proyecto_reservas.repositories.PersonaRepository;



@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> ListarPersonas() {
		return personaRepository.findAll();
	}
}
