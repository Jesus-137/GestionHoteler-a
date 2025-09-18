package com.example.huespedes.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jesus.commons.Enum.DocumentoEnum;
import com.jesus.commons.clients.ReservaClient;
import com.jesus.commons.dto.HuespedRequest;
import com.jesus.commons.dto.HuespedResponse;
import com.example.huespedes.mappers.HuespedMapper;
import com.example.huespedes.models.Huesped;
import com.example.huespedes.repositories.HuespedRepository;



@Service
@Transactional
public class HuespedServiceImpl implements HuespedService {
	
	private final HuespedMapper huespedMapper;
	private final HuespedRepository huespedRepository;
	private final ReservaClient reservaClient;
	
	public HuespedServiceImpl(HuespedMapper huespedMapper, HuespedRepository huespedRepository,
			ReservaClient reservaClient) {
		this.huespedMapper = huespedMapper;
		this.huespedRepository = huespedRepository;
		this.reservaClient = reservaClient;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HuespedResponse> listar() {
		return huespedRepository.findAll().stream().map(huespedMapper::entityToResponse).toList();
	}

	@Override
	public HuespedResponse ObtenerPorId(long id) {
		return huespedMapper.entityToResponse(huespedRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("Huesped no encontrado con el id: " + id )));
	}

	@Override
	public HuespedResponse Insertar(HuespedRequest request) {
		huespedRepository.findAll().forEach(hu->{
			if(hu.getEmail()==request.email()) {
				throw new NoSuchElementException("El email ya esta en uso");
			}
			if(hu.getTelefono()==request.telefono()) {
				throw new NoSuchElementException("El telefono ya esta en uso");
			}
		});
		return huespedMapper.entityToResponse(huespedRepository.save(huespedMapper.requetsToEntity(request)));
	}

	@Override
	public HuespedResponse actualizar(HuespedRequest request, Long id) {
		Huesped huesped = huespedRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("Huesped no encontrado con el id: " + id));
		huespedRepository.findAll().forEach(hu->{
			if(hu.getEmail()==request.email()&&hu.getId()!=id) {
				throw new NoSuchElementException("El email ya esta en uso");
			}
			if(hu.getTelefono()==request.telefono()&&hu.getId()!=id) {
				throw new NoSuchElementException("El telefono ya esta en uso");
			}
		});
		huesped.setNombre(request.nombre());
		huesped.setApellido(request.apellido());
		huesped.setEmail(request.email());
		huesped.setTelefono(request.telefono());
		huesped.setDocumento(request.documento()==1?DocumentoEnum.INE.getNombre():DocumentoEnum.PASAPORTE.getNombre());
		huesped.setNacionalidad(request.nacionalidad());
		
		return huespedMapper.entityToResponse(huespedRepository.save(huesped));
	}

	@Override
	public HuespedResponse eliminar(long id) {
		Huesped huesped = huespedRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("Huesped no encontrado con el id: " + id));
		if(reservaClient.huespedIsPresent(id)) {
			throw new NoSuchElementException("El huesped no se puede eliminar porque tiene una reservacion");
		}
		huespedRepository.deleteById(id);
		return huespedMapper.entityToResponse(huesped);
	}
}
