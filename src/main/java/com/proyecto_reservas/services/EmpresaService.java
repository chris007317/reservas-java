package com.proyecto_reservas.services;

import com.proyecto_reservas.dtos.requests.EmpresaRequest;
import com.proyecto_reservas.dtos.response.EmpresaResponse;
import com.proyecto_reservas.entities.Empresa;


public interface EmpresaService {
	public Empresa RegistrarEmpresa (EmpresaRequest empresaRequest);
	
	public EmpresaResponse SeleccionarEmpresa(Long id);
}
