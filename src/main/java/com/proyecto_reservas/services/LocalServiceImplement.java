package com.proyecto_reservas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_reservas.dtos.LocalMapper;
import com.proyecto_reservas.dtos.requests.LocalRequest;
import com.proyecto_reservas.dtos.response.LocalResponse;
import com.proyecto_reservas.entities.Empresa;
import com.proyecto_reservas.entities.Local;
import com.proyecto_reservas.repositories.EmpresaRepository;
import com.proyecto_reservas.repositories.LocalRepository;

@Service
public class LocalServiceImplement implements LocalService{
	@Autowired
	LocalRepository localRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Override
	public LocalResponse RegistrarLocal(LocalRequest localRequest) {
		try {
			
		Empresa empresa = empresaRepository.findByIdAndEstado(localRequest.getIdempresa(), true);
		if(empresa == null) throw new RuntimeException("No se encontró empresa con el id: " + localRequest.getIdempresa());
		Local local = LocalMapper.mapper.local(localRequest);
		local.setEmpresa(empresa);
		local = localRepository.save(local);
		return LocalMapper.mapper.localResponse(local);
		}catch (Exception e) {
			System.err.println("Error al registrar el local: " + e.getMessage());
	        throw new RuntimeException("No se pudo registrar el local. Por favor, inténtelo nuevamente.");
		}
	}
	
	@Override
	public LocalResponse SeleccionarLocal(Long id) {
		Local local = localRepository.findByIdAndEstado(id, true);
		if(local == null) throw new RuntimeException("No se encontró el local con el id: " + id);
		return LocalMapper.mapper.localResponse(local);
	}
	
	@Override
	public LocalResponse EditarLocal(long id, LocalRequest localRequest) {
		try {
			Local local = localRepository.findByIdAndEstado(id, true);
			if(local == null) throw new RuntimeException("No se encontró el local con el id: " + id);
			Empresa empresa = empresaRepository.findByIdAndEstado(localRequest.getIdempresa(), true);
			if(empresa == null) throw new RuntimeException("No se encontró empresa con el id: " + localRequest.getIdempresa());
			LocalMapper.mapper.actualizarLocal(local, localRequest);
			local.setEmpresa(empresa);
			localRepository.save(local);
			return LocalMapper.mapper.localResponse(local);
		}catch (Exception e) {
			System.err.println("Error al editar el local: " + e.getMessage());
	        throw new RuntimeException("No se pudo editar el local. Por favor, inténtelo nuevamente.");
		}
	}
	
	@Override
	public List<LocalResponse> ListarLocal(){
		List<Local> locales = localRepository.findAllByEstado(true);
		return locales.stream().map(
				local -> LocalMapper.mapper.localResponse(local)).collect(Collectors.toList());
	}
	
	@Override
	public void EliminarLocal(Long id, int idUsuario) {
		try {
			Local local = localRepository.findByIdAndEstado(id, true);
			if(local == null) throw new RuntimeException("No se encontró el local con el id: " + id);
			local.setEstado(false);
			local.setUsuarioEdicion(idUsuario);
			localRepository.save(local);
		}catch (Exception e) {
			System.err.println("Error al elimnar el local: " + e.getMessage());
	        throw new RuntimeException("No se pudo eliminar los datos del local. Por favor, inténtelo nuevamente.");
		}
	}
}