package com.jesus.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jesus.commons.dto.ProveedorResponse;

@FeignClient(name="msv-proveedores")
public interface ProveedorClient {
	
	@GetMapping("/{id}")
	ProveedorResponse getProveedorPorId(@PathVariable Long id);

}
