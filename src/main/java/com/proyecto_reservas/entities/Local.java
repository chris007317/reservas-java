package com.proyecto_reservas.entities;

import java.time.LocalTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Local")
@Table(name = "Locales") 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Local {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLocal")
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "idLocalEmpresa", referencedColumnName = "idEmpresa", nullable = true)
    private Empresa empresa;
	
	@Column(name = "nombreLocal", nullable = true, length = 50 )
    private String nombre;
	
	@Column(name = "ciudadLocal", nullable = false, length = 50 )
    private String ciudad;
	
	@Column(name = "direccionLocal", nullable = false, length = 200 )
    private String direccion;
	
	@Column(name = "ubicacionLocal", nullable = false, length = 255 )
    private String ubiacion;
	
    private LocalTime horaEntrad;
	
    private LocalTime horaSalida;
	
    private int diaInicio;
	
	private int diaFin;
	
    private double porcentajeReserva;
	
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
