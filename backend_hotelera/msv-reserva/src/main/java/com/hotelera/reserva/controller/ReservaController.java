package com.hotelera.reserva.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hotelera.reserva.service.ReservaService;
import com.jesus.commons.controllers.CommonController;
import com.jesus.commons.dto.ReservaRequest;
import com.jesus.commons.dto.ReservaResponse;

public class ReservaController extends CommonController<ReservaRequest, ReservaResponse, ReservaService>{

	public ReservaController(ReservaService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/id-habitacion/{id}")
	boolean habitacionIsPresent(@PathVariable Long id) {
		return Service.habitacionIsPresent(id);
	}
	
	@GetMapping("id-huesped/{id}")
	boolean huespedIsPresent(@PathVariable Long id) {
		return Service.huespedIsPresent(id);
	}
}
