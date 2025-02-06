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

import com.proyecto_reservas.dtos.requests.CanchaRequest;
import com.proyecto_reservas.dtos.response.CanchaResponse;
import com.proyecto_reservas.services.CanchaService;

@RestController
@RequestMapping("/api/v1/canchas")
public class CanchaCotroller {
	@Autowired
	CanchaService canchaService;
	
	@PostMapping
	public ResponseEntity<?> RegistrarCancha(@RequestBody CanchaRequest canchaRequest){
		try {
			CanchaResponse cancha = canchaService.RegistrarCancha(canchaRequest);
			return new ResponseEntity<>(cancha, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> SeleccionarCancha(@PathVariable Long id){
		try {
			CanchaResponse cancha = canchaService.SeleccionarCancha(id);
			return new ResponseEntity<>(cancha, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> EditarCancha(@PathVariable Long id, @RequestBody CanchaRequest canchaRequest) {
		try {
			CanchaResponse canchaAcutalizada = canchaService.EditarCancha(id, canchaRequest);
			return new ResponseEntity<>(canchaAcutalizada, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> ListarCanchas(
			@RequestParam(required = false) Long idLocal, 
			@RequestParam(required = false) String nombre) {
		try {
			List<CanchaResponse> listaCanchas = canchaService.ListarCanchas(idLocal, nombre);
			return new ResponseEntity<>(listaCanchas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/eliminar/{id}")
	public ResponseEntity<?> EliminarCancha(@PathVariable Long id, @RequestParam int idUsuario) {
		try {
			canchaService.EliminarCancha(id, idUsuario);
			return new ResponseEntity<>("Cancha eliminado correctamente", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
