package com.example.habitaciones.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.habitaciones.mappers.HabitacionMapper;
import com.example.habitaciones.models.Habitacion;
import com.example.habitaciones.repositories.HabitacionRepository;
import com.jesus.commons.Enum.EstadoReservaEnum;
import com.jesus.commons.clients.ReservaClient;
import com.jesus.commons.dto.HabitacionRequest;
import com.jesus.commons.dto.HabitacionResponse;
import java.util.NoSuchElementException;

@Service
@Transactional
public class HabitacionServiceImpl implements HabitacionService{
	
	private final HabitacionMapper habitacionMapper;
	private final HabitacionRepository habitacionRepository;
	private final ReservaClient reservaClient;

	public HabitacionServiceImpl(HabitacionMapper habitacionMapper, HabitacionRepository habitacionRepository,
			ReservaClient reservaClient) {
		this.habitacionMapper = habitacionMapper;
		this.habitacionRepository = habitacionRepository;
		this.reservaClient = reservaClient;
	}

	@Override
	public List<HabitacionResponse> listar() {
		return habitacionRepository.findAll().stream().map(habitacionMapper::entityToResponse).toList();
	}

	@Override
	public HabitacionResponse ObtenerPorId(long id) {
		return habitacionMapper.entityToResponse(habitacionRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("Habitacion no encontrado con el id: " + id)));
	}

	@Override
	public HabitacionResponse Insertar(HabitacionRequest request) {
		habitacionRepository.findAll().forEach(h->{
			if(h.getNumero()==request.numero()) {
				throw new NoSuchElementException("El numero de la habitacion ya esta en uso");
			}
		});
		return habitacionMapper.entityToResponse(habitacionRepository.save(habitacionMapper.requetsToEntity(request)) );
	}



	@Override
	public HabitacionResponse actualizar(HabitacionRequest request, Long id) {
		Habitacion habitacion = habitacionRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("La habitacion no encontrada con el id: " + id));
		String estado;
		switch (request.estado()) {
			case 1-> {
				estado = EstadoReservaEnum.CONFIRMADA.getNombre();
			}
			case 2->{
				estado = EstadoReservaEnum.EN_CURSO.getNombre();
			}
			case 3->{
				estado = EstadoReservaEnum.FINALIZADA.getNombre();
			}
			case 4->{
				estado = EstadoReservaEnum.CANCELADA.getNombre();
			}
			default->{
				throw new IllegalArgumentException("Unexpected value: " + request.estado());
			}
		}
		habitacionRepository.findAll().forEach(h->{
			if(h.getNumero()==request.numero()&&h.getId()!=id) {
				throw new NoSuchElementException("El numero de la habitacion ya esta en uso");
			}
		});
		habitacion.setNumero(request.numero());
		habitacion.setTipo(request.tipo());
		habitacion.setDescripcion(request.descripcion());
		habitacion.setPrecio(request.precio());
		habitacion.setCapacidad(request.capacidad());
		habitacion.setEstado(estado);
		return habitacionMapper.entityToResponse(habitacionRepository.save(habitacion));
	}

	@Override
	public HabitacionResponse eliminar(long id) {
		Habitacion habitacion = habitacionRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Region no encontrada con el id: "+ id));
		if(reservaClient.habitacionIsPresent(id)) {
			throw new NoSuchElementException("La habitaion esta vinculada a una reserva");
		}
		habitacionRepository.deleteById(id);
		return habitacionMapper.entityToResponse(habitacion);
	}

}
