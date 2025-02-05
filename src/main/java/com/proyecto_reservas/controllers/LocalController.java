package com.proyecto_reservas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_reservas.dtos.requests.LocalRequest;
import com.proyecto_reservas.dtos.response.LocalResponse;
import com.proyecto_reservas.services.LocalService;

@RestController
@RequestMapping("/api/v1/locales")
public class LocalController {
	
	@Autowired LocalService localService;
	
	@PostMapping
	public ResponseEntity<?> RegistrarLocal(@RequestBody LocalRequest localRequest){
		try {
			LocalResponse nuevoLocal = localService.RegistrarLocal(localRequest);
			return new ResponseEntity<>(nuevoLocal, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> SeleccionarLocal(@PathVariable Long id){
		try {
			LocalResponse local = localService.SeleccionarLocal(id);
			return new ResponseEntity<>(local, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> ActualizarLocal(@PathVariable Long id, @RequestBody LocalRequest localRecuest){
		try {
			LocalResponse local = localService.EditarLocal(id, localRecuest);
			return new ResponseEntity<>(local, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> ListarLocales(){
		try {
			List<LocalResponse> locales = localService.ListarLocal();
			return new ResponseEntity<>(locales, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/eliminar/{id}")
	public ResponseEntity<?> EliminarLocal(@PathVariable Long id, @RequestParam int idUsuario) {
		try {
			localService.EliminarLocal(id, idUsuario);
			return new ResponseEntity<>("Local Eliminado correctamente", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
