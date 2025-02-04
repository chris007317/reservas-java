package com.proyecto_reservas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PutMapping("/{id}")
	public ResponseEntity<?> EditarEmpresa(@PathVariable Long id, @RequestBody EmpresaRequest empresaRequest){
		try {
	        EmpresaResponse empresa = empresaService.EditarEmpresa(id, empresaRequest);
	        return new ResponseEntity<>(empresa, HttpStatus.CREATED);
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }		
	}
	
	@PutMapping("/eliminar/{id}")
	public ResponseEntity<?> EliminarEmpresa(@PathVariable Long id, @RequestParam boolean estado){
		try {
	        empresaService.EliminarEmpresa(id, estado);
	        return new ResponseEntity<>("Empresa Eliminada con exito", HttpStatus.OK);
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
}
