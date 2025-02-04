
package com.proyecto_reservas.services;

import java.util.List;

import com.proyecto_reservas.dtos.requests.LocalRequest;
import com.proyecto_reservas.dtos.response.LocalResponse;

public interface LocalService {
	public LocalResponse RegistrarLocal(LocalRequest localRequest);
	
	public LocalResponse SeleccionarLocal(Long id);
	
	public LocalResponse EditarLocal(long id, LocalRequest localRequest);
	
	public List<LocalResponse> ListarLocal();
	
	public void EliminarLocal(Long id, int idUsuario);
}
