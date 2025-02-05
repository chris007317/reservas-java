package com.proyecto_reservas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_reservas.dtos.CanchaMapper;
import com.proyecto_reservas.dtos.requests.CanchaRequest;
import com.proyecto_reservas.dtos.response.CanchaResponse;
import com.proyecto_reservas.entities.Cancha;
import com.proyecto_reservas.entities.Local;
import com.proyecto_reservas.repositories.CanchaRepository;
import com.proyecto_reservas.repositories.LocalRepository;

@Service
public class CanchaServiceImplement implements CanchaService {
	@Autowired
	LocalRepository localRepository;
	
	@Autowired
	CanchaRepository canchaRepository;
	
	@Override
	public CanchaResponse RegistrarCancha(CanchaRequest canchaRequest) {
		try {
			Local local = localRepository.findByIdAndEstado(canchaRequest.getIdLocal(), true);
			if(local == null) throw new RuntimeException("No se encontró la cancha con el id: " + canchaRequest.getIdLocal());
			Cancha cancha = CanchaMapper.mapper.cancha(canchaRequest);
			cancha.setLocal(local);
			cancha = canchaRepository.save(cancha);
			return CanchaMapper.mapper.canchaResponse(cancha);
		}catch (Exception e) {
			System.err.println("Error al registrar la cancha: " + e.getMessage());
	        throw new RuntimeException("No se pudo registrar la cancha. Por favor, inténtelo nuevamente.");
		}
	}
	
	@Override
	public CanchaResponse SeleccionarCancha(Long id) {
		Cancha cancha = canchaRepository.findByIdAndEstado(id, true);
		if(cancha == null) throw new RuntimeException("No se encontró la cancha con el id: " + id);
		return CanchaMapper.mapper.canchaResponse(cancha);
	}
	
	@Override
	public CanchaResponse EditarCancha(Long id, CanchaRequest canchaRequest) {
		try {
			Cancha cancha = canchaRepository.findByIdAndEstado(id, true);
			if(cancha == null) throw new RuntimeException("No se encontró la cancha con el id: " + id);
			Local local = localRepository.findByIdAndEstado(canchaRequest.getIdLocal(), true);
			if(local == null) throw new RuntimeException("No se encontró la cancha con el id: " + canchaRequest.getIdLocal());
			CanchaMapper.mapper.ActualizarCancha(cancha, canchaRequest);
			cancha.setLocal(local);
			canchaRepository.save(cancha);
			return CanchaMapper.mapper.canchaResponse(cancha);
		}catch (Exception e) {
			System.err.println("Error al editar la cancha: " + e.getMessage());
	        throw new RuntimeException("No se pudo editar la cancha. Por favor, inténtelo nuevamente.");
		}
	}
	
	@Override
	public List<CanchaResponse> ListarCanchas(Long idLocal, String nombre) {
	    List<Cancha> canchas;
	    if (idLocal != null && nombre != null) {
	        canchas = canchaRepository.findByEstadoAndLocalIdAndNombreLike(true, idLocal, "%" + nombre + "%");
	    } else if (idLocal != null) {
	        canchas = canchaRepository.findByEstadoAndLocalId(true, idLocal);
	    } else if (nombre != null) {
	        canchas = canchaRepository.findByEstadoAndNombreLike(true, "%" + nombre + "%");
	    } else {
	        canchas = canchaRepository.findByEstado(true);
	    }
	    return canchas.stream()
	                  .map(CanchaMapper.mapper::canchaResponse)
	                  .collect(Collectors.toList());
	}
	
	@Override
	public void EliminarCancha(Long id, int idUsuario) {
		try {
			Cancha cancha = canchaRepository.findByIdAndEstado(id, true);
			if(cancha == null) throw new RuntimeException("No se encontró la cancha con el id: " + id);
			cancha.setEstado(false);			
			cancha.setUsuarioEdicion(idUsuario);
			canchaRepository.save(cancha);
		}catch (Exception e) {
			System.err.println("Error al elimnar la cancha: " + e.getMessage());
	        throw new RuntimeException("No se pudo eliminar los datos de la cancha. Por favor, inténtelo nuevamente.");
		}
		
	}
}
