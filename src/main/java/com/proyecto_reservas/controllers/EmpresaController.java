package com.proyecto_reservas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_reservas.dtos.requests.EmpresaRequest;
import com.proyecto_reservas.dtos.response.EmpresaResponse;
import com.proyecto_reservas.entities.Empresa;
import com.proyecto_reservas.services.EmpresaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {
	@Autowired
	EmpresaService empresaService;
	
	@PostMapping
	public ResponseEntity<?> RegistrarPersona(@RequestBody EmpresaRequest empresaRequest) {
	    try {
	        Empresa nuevaEmpresa = empresaService.RegistrarEmpresa(empresaRequest);
	        return new ResponseEntity<>(nuevaEmpresa, HttpStatus.CREATED);
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> SeleccionarEmpresa(@PathVariable Long id) {
		try {
			EmpresaResponse empresa = empresaService.SeleccionarEmpresa(id);
			return new ResponseEntity<>(empresa, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
