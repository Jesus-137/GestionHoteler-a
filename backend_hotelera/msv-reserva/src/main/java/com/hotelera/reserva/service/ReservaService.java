package com.hotelera.reserva.service;

import com.jesus.commons.dto.ReservaRequest;
import com.jesus.commons.dto.ReservaResponse;
import com.jesus.commons.services.CommonService;

public interface ReservaService extends CommonService<ReservaRequest, ReservaResponse>{
	
	boolean habitacionIsPresent(Long id);
	
	boolean huespedIsPresent(Long id);
}
