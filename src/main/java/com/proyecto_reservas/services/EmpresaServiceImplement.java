package com.proyecto_reservas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_reservas.dtos.EmpresaMapper;
import com.proyecto_reservas.dtos.requests.EmpresaRequest;
import com.proyecto_reservas.dtos.response.EmpresaResponse;
import com.proyecto_reservas.entities.Empresa;
import com.proyecto_reservas.entities.Persona;
import com.proyecto_reservas.repositories.EmpresaRepository;
import com.proyecto_reservas.repositories.PersonaRepository;

@Service
public class EmpresaServiceImplement implements EmpresaService{
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public Empresa RegistrarEmpresa (EmpresaRequest empresaRequest) {
		try {
			Persona persona = personaRepository.findById(empresaRequest.getIdPersona())
					.orElseThrow(() -> new RuntimeException("Persona no encontrada con el id: " + empresaRequest.getIdPersona()));
			Empresa empresa = Empresa.builder()
					.persona(persona)
					.nombre(empresaRequest.getNombre())
					.codigoQr(empresaRequest.getCodigoQr())
					.celular(empresaRequest.getCelular())
					.tipo(empresaRequest.getTipo())
					.documento(empresaRequest.getDocumento())
					.direccion(empresaRequest.getDireccion())
					.estado(empresaRequest.getEstado())
					.build();
			empresa = empresaRepository.save(empresa);
			return empresa;
			
		}catch (Exception e) {
			System.err.println("Error al registrar la empresa: " + e.getMessage());
	        throw new RuntimeException("No se pudo registrar la empresa. Por favor, inténtelo nuevamente.");
		}
	}
	
	@Override 
	public EmpresaResponse SeleccionarEmpresa(Long id) {
		Empresa empresa = empresaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No se encontró empresa con el id: " + id));
		return EmpresaMapper.mapper.empresaResponse(empresa);
	}
}
