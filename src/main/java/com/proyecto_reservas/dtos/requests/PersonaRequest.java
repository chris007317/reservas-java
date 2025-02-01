package com.proyecto_reservas.dtos.requests;

import lombok.Data;

@Data
public class PersonaRequest {
	
	 private String dni;
	    
	 private String nombre;
	    
	 private String apellidoPaterno;
	    
	 private String apellidoMaterno;
	    
	 private String celular;

	 private String correo;

}
