package com.proyecto_reservas.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Empresa")
@Table(name = "Empresas") 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmpresa")
    private Long id;
	
	@OneToOne
    @JoinColumn(name = "idEmpresaPersona", referencedColumnName = "idPersona", nullable = false)
    private Persona persona;
	
	@Column(name = "nombreEmpresa", nullable = false, length = 100 )
    private String nombre;

	@Column(name = "codigoQrEmpresa", nullable = true, length = 200 )
    private String codigoQr;
	
	@Column(name = "celularEmpresa", nullable = true, length = 9 )
    private String celular;
	
	@Column(name = "tipoEmpresa", nullable = false, length = 6 )
    private String tipo;
	
	@Column(name = "documentoEmpresa", nullable = false, length = 15 )
    private String documento;
	
	@Column(name = "direccionEmpresa", nullable = false, length = 250 )
    private String direccion;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
	private Boolean estado;
	
    @CreationTimestamp
    @Column(updatable = false)
    private Date fechaRegistro;
    
    @UpdateTimestamp
    private Date fechaEdicion;
    
    @Column(nullable = true)
    private Integer usuarioEdicion;
}
