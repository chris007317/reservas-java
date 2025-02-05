package com.proyecto_reservas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto_reservas.entities.Cancha;

public interface CanchaRepository extends JpaRepository<Cancha, Long> {
	public Cancha findByIdAndEstado(Long id, boolean estado);
	
	public List<Cancha> findByEstadoAndLocalIdAndNombreLike(boolean estado, Long id, String nombre);
	
	public List<Cancha> findByEstadoAndNombreLike(boolean estado, String nombre);
	
	public List<Cancha> findByEstadoAndLocalId(boolean estado, Long id);
	
	public List<Cancha> findByEstado(boolean estado);
}
