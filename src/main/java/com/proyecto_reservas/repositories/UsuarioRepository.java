package com.proyecto_reservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto_reservas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
