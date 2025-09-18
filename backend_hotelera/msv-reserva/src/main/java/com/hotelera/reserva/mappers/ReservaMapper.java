package com.hotelera.reserva.mappers;

import java.sql.Date;

import com.hotelera.reserva.model.Reserva;
import com.jesus.commons.clients.HabitacionClient;
import com.jesus.commons.clients.HuespedClient;
import com.jesus.commons.dto.HabitacionResponse;
import com.jesus.commons.dto.HuespedResponse;
import com.jesus.commons.dto.ReservaRequest;
import com.jesus.commons.dto.ReservaResponse;
import com.jesus.commons.mappers.CommonMapper;

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
		
		Reserva reserva = new Reserva();
		reserva.setIdHuesped(request.idHuesped());
		reserva.setIdHabitacion(request.idHabitacion());
		reserva.setFechaEntrada(request.fechaEntrada());
		reserva.setFecheSalida(request.fecheSalida());
		reserva.setNoches(request.noches());
		reserva.setTotal(request.total());
		reserva.setEstado(request.estado());
		return reserva;
	}

}
