package com.example.habitaciones.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.habitaciones.mappers.HabitacionMapper;
import com.example.habitaciones.models.Habitacion;
import com.example.habitaciones.repositories.HabitacionRepository;
import com.jesus.commons.dto.HabitacionRequest;
import com.jesus.commons.dto.HabitacionResponse;
import java.util.NoSuchElementException;





@Service
@Transactional
public class HabitacionServiceImpl implements HabitacionService{
	
	private final HabitacionMapper habitacionMapper;
	private final HabitacionRepository habitacionRepository;

	
	
	public HabitacionServiceImpl(HabitacionMapper habitacionMapper, HabitacionRepository habitacionRepository) {
		this.habitacionMapper = habitacionMapper;
		this.habitacionRepository = habitacionRepository;
	}



	@Override
	public List<HabitacionResponse> listar() {
		return habitacionRepository.findAll().stream()
				.map(habitacionMapper::entityToResponse).toList();
	}



	@Override
	public HabitacionResponse ObtenerPorId(long id) {
		return habitacionMapper.entityToResponse(habitacionRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("Habitacion no encontrado con el id: " + id)));
	}



	@Override
	public HabitacionResponse Insertar(HabitacionRequest request) {
		return habitacionMapper.entityToResponse(habitacionRepository.save(habitacionMapper.requetsToEntity(request)) );
	}



	@Override
	public HabitacionResponse actualizar(HabitacionRequest request, Long id) {
		Habitacion habitacion = habitacionRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("La habitacion no encontrada con el id: " + id));
		habitacion.setNumero(request.numero());
		return habitacionMapper.entityToResponse(habitacionRepository.save(habitacion));
	}



	@Override
	public HabitacionResponse eliminar(long id) {
		Habitacion habitacion = habitacionRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Region no encontrada con el id: "+ id));
		habitacionRepository.deleteById(id);
			return habitacionMapper.entityToResponse(habitacion);
	}

}
