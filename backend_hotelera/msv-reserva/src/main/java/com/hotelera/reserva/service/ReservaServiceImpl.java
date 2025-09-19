package com.hotelera.reserva.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelera.reserva.mappers.ReservaMapper;
import com.hotelera.reserva.model.Reserva;
import com.hotelera.reserva.repositories.ReservaReposity;
import com.jesus.commons.Enum.EstadoReservaEnum;
import com.jesus.commons.clients.HabitacionClient;
import com.jesus.commons.clients.HuespedClient;
import com.jesus.commons.dto.HabitacionResponse;
import com.jesus.commons.dto.HuespedResponse;
import com.jesus.commons.dto.ReservaRequest;
import com.jesus.commons.dto.ReservaResponse;


@Service
@Transactional
public class ReservaServiceImpl implements ReservaService{

	private final ReservaMapper reservaMapper;
	private final ReservaReposity reservaRepo;
	private final HabitacionClient habitacionClient;
	private final HuespedClient huespedClient;
	
	public ReservaServiceImpl(ReservaMapper reservaMapper, ReservaReposity reservaRepo,
			HabitacionClient habitacionClient, HuespedClient huespedClient) {
		this.reservaMapper = reservaMapper;
		this.reservaRepo = reservaRepo;
		this.habitacionClient = habitacionClient;
		this.huespedClient = huespedClient;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReservaResponse> listar() {
		return reservaRepo.findAll().stream().map(reservaMapper::entityToResponse).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public ReservaResponse ObtenerPorId(long id) {
		return reservaMapper.entityToResponse(reservaRepo.findById(id).orElseThrow(
				()-> new NoSuchElementException("Reserva no encontrada con el id: "+id)));
	}

	@Override
	public ReservaResponse Insertar(ReservaRequest request) {
		if(request.fechaEntrada().after(request.fecheSalida())) {
			throw new NoSuchElementException("La fecha de entrada no puede ser despues de la fecha de salida");
		}
		long noches = request.fechaEntrada().getTime()-request.fecheSalida().getTime();
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
		HabitacionResponse habitacionResponse = habitacionClient.getHabitacionPorId(request.idHabitacion());
		double total = habitacionResponse.precio() * noches;
		if(total<1) {
			throw new NoSuchElementException("Error al calcular el costo de la reservacion");
		}
		Reserva reserva =  new Reserva();
		reserva.setIdHuesped(request.idHuesped());
		reserva.setIdHabitacion(request.idHabitacion());
		reserva.setFechaEntrada(request.fechaEntrada());
		reserva.setFecheSalida(request.fecheSalida());
		reserva.setNoches(noches);
		reserva.setEstado(estado);
		reserva.setTotal(total);
		return reservaMapper.entityToResponse(reservaRepo.save(reservaMapper.requetsToEntity(request)));
	}

	@Override
	public ReservaResponse actualizar(ReservaRequest request, Long id) {		
		Reserva reserva =  reservaRepo.findById(id).orElseThrow(
				()-> new NoSuchElementException("Reserva no encontrada con el id: "+id));
		if(request.fechaEntrada().after(request.fecheSalida())) {
			throw new NoSuchElementException("La fecha de entrada no puede ser despues de la fecha de salida");
		}
		long noches = request.fechaEntrada().getTime()-request.fecheSalida().getTime();
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
		HuespedResponse huespedResponse = huespedClient.getHuespedPorId(request.idHuesped());
		HabitacionResponse habitacionResponse = habitacionClient.getHabitacionPorId(request.idHabitacion());
		double total = habitacionResponse.precio() * noches;
		reserva.setIdHuesped(habitacionResponse.id());
		reserva.setIdHabitacion(huespedResponse.id());
		reserva.setFechaEntrada(request.fechaEntrada());
		reserva.setFecheSalida(request.fecheSalida());
		reserva.setNoches(noches);
		reserva.setTotal(total);
		reserva.setEstado(estado);
		return reservaMapper.entityToResponse(reserva);
	}

	@Override
	public ReservaResponse eliminar(long id) {
		Reserva reserva =  reservaRepo.findById(id).orElseThrow(
				()-> new NoSuchElementException("Reserva no encontrada con el id: "+id));
		reservaRepo.deleteById(id);
		return reservaMapper.entityToResponse(reserva);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean habitacionIsPresent(Long id) {
		return reservaRepo.existsByIdHabitacion(id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean huespedIsPresent(Long id) {
		return reservaRepo.existsByIdHuesped(id);
	}
}
