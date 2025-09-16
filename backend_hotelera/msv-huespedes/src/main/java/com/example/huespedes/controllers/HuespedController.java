package com.example.huespedes.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.example.huespedes.services.HuespedService;
import com.jesus.commons.contro.controllers.CommonController;
import com.jesus.commons.dto.HuespedRequest;
import com.jesus.commons.dto.HuespedResponse;

@RestController
public class HuespedController extends CommonController<HuespedRequest, HuespedResponse, HuespedService> {
	public HuespedController(HuespedService service) {
		super(service);
	}
}
