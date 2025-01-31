package com.proyecto_reservas.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Persona")
@Table(name = "Personas") 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Long id; 

    @Column(name = "dniPersona", nullable = false, length = 8 )
    private String dni;

    @Column(name = "nombrePersona", nullable = false, length = 60)
    private String nombre;

    @Column(name = "apellidoPaternoPersona", nullable = false, length = 100)
    private String apellidoPaterno;

    @Column(name = "apellidoMaternoPersona", nullable = false, length = 100)
    private String apellidoMaterno;

    @Column(name = "celularPersona", nullable = false, length = 9)
    private String celular;

    @Column(name = "correoPersona", nullable = false, length = 150)
    private String correo;

    @CreationTimestamp
    @Column(updatable = false)
    private Date fechaRegistro;
    
    @UpdateTimestamp
    private Date fechaEdicion;
}
