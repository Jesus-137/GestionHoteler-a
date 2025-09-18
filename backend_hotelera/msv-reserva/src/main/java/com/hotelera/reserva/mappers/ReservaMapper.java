package com.hotelera.reserva.mappers;

import com.hotelera.reserva.model.Reserva;
import com.jesus.commons.clients.HabitacionClient;
import com.jesus.commons.clients.HuespedClient;
import com.jesus.commons.dto.ReservaRequest;
import com.jesus.commons.dto.ReservaResponse;
import com.jesus.commons.mappers.CommonMapper;

public class ReservaMapper extends CommonMapper<ReservaRequest, ReservaResponse, Reserva> {

	private final HuespedClient huespedClient;
	private final HabitacionClient habitacionClient;
	
	public ReservaMapper(HuespedClient huespedClient, HabitacionClient habitacionClient) {
		super();
		this.huespedClient = huespedClient;
		this.habitacionClient = habitacionClient;
	}

	@Override
	protected ReservaResponse entityToResponse(Reserva entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Reserva requetsToEntity(ReservaRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
