package com.proyecto_reservas.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "idUsuarioPersona", referencedColumnName = "idPersona", nullable = false)
    private Persona persona; 
    
    @ManyToOne
    @JoinColumn(name = "idUsuarioEmpresa", referencedColumnName = "idEmpresa", nullable = true)
    private Empresa empresa;

    @Column(name = "nombreUsuario")
    private String username;

    @Column(name = "contraUsuario")
    private String password;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean estado;

    @CreationTimestamp
    @Column(updatable = false)
    private Date fechaRegistro; 

    @UpdateTimestamp
    private Date fechaEdicion;

    @Column(nullable = true)
    private Integer usuarioEdicion;
}
