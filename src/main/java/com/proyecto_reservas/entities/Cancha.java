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

@Entity(name = "Cancha")
@Table(name = "Canchas") 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cancha {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCancha")
    private Long id;
	
	@Column(name = "nombreCancha", nullable = false, length = 100 )
    private String nombre;
	
	private double precioDia;
	
	private double precioNoche;
	
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
