package com.hotelera.reserva.mappers;


import java.sql.Date;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Component;

import com.hotelera.reserva.model.Reserva;
import com.jesus.commons.Enum.EstadoReservaEnum;
import com.jesus.commons.clients.HabitacionClient;
import com.jesus.commons.clients.HuespedClient;
import com.jesus.commons.dto.HabitacionResponse;
import com.jesus.commons.dto.HuespedResponse;
import com.jesus.commons.dto.ReservaRequest;
import com.jesus.commons.dto.ReservaResponse;
import com.jesus.commons.mappers.CommonMapper;

@Component
public class ReservaMapper extends CommonMapper<ReservaRequest, ReservaResponse, Reserva> {

	private final HuespedClient huespedClient;
	private final HabitacionClient habitacionClient;
	
	public ReservaMapper(HuespedClient huespedClient, HabitacionClient habitacionClient) {
		this.huespedClient = huespedClient;
		this.habitacionClient = habitacionClient;
	}

	@Override
	public ReservaResponse entityToResponse(Reserva entity) {
		if(entity==null) {
			return null;
		}
		
		HuespedResponse huespedResponse = huespedClient.getHuespedPorId(entity.getIdHuesped());
		HabitacionResponse habitacionResponse = habitacionClient.getHabitacionPorId(entity.getIdHabitacion());
		String nombreHuesped = huespedResponse.nombre()+" "+huespedResponse.apellido();
		return new ReservaResponse(
				entity.getId(),
				nombreHuesped,
				habitacionResponse.numero(),
				entity.getFechaEntrada(),
				entity.getFecheSalida(),
				entity.getNoches(),
				entity.getTotal(),
				entity.getEstado()
		);
	}

	@Override
	public Reserva requetsToEntity(ReservaRequest request) {
		if(request==null) {
			return null;
		}

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
		return reserva;
	}
}
