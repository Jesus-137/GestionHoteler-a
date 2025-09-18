package com.jesus.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jesus.commons.dto.HabitacionResponse;

@FeignClient(name="mvs-habitaciones")
public interface HabitacionClient {

	@GetMapping("/{id}")
	HabitacionResponse getHabitacionPorId(@PathVariable Long id);
	
}
