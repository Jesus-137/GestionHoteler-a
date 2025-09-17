package com.jesus.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jesus.commons.dto.HuespedResponse;

@FeignClient(name="msv-huespedes")
public interface HuespedClient {

	@GetMapping("/{id}")
	HuespedResponse getHuespedPorId(@PathVariable Long id);
}
