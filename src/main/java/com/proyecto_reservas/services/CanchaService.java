package com.proyecto_reservas.services;

import java.util.List;

import com.proyecto_reservas.dtos.requests.CanchaRequest;
import com.proyecto_reservas.dtos.response.CanchaResponse;

public interface CanchaService {
	public CanchaResponse RegistrarCancha(CanchaRequest canchaRequest);
	
	public CanchaResponse SeleccionarCancha(Long id);
	
	public CanchaResponse EditarCancha(Long id, CanchaRequest canchaRequest);
	
	public List<CanchaResponse> ListarCanchas(Long idLocal, String nombre);
	
	public void EliminarCancha(Long id, int idUsuario);
}
