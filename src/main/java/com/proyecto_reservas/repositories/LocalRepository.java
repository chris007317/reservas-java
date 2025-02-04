package com.proyecto_reservas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto_reservas.entities.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {
	
	public Local findByIdAndEstado(Long id, boolean estado);
	
	public List<Local> findAllByEstado(boolean estado);
}
