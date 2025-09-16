package com.example.habitaciones.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.habitaciones.services.HabitacionService;
import com.jesus.commons.controllers.CommonController;
import com.jesus.commons.dto.HabitacionRequest;
import com.jesus.commons.dto.HabitacionResponse;

@RestController
public class HabitacionController extends CommonController<HabitacionRequest, HabitacionResponse, HabitacionService>{

	public HabitacionController(HabitacionService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
