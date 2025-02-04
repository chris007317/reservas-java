package com.proyecto_reservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto_reservas.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
