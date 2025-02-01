package com.proyecto_reservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto_reservas.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	boolean existsByDni(String dni);
	boolean existsByDniAndIdNot(String dni, Long id);
}
