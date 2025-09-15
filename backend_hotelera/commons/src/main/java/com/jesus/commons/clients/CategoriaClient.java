package com.jesus.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jesus.commons.dto.CategoriaResponse;

@FeignClient(name="msv-categorias")
public interface CategoriaClient {
	
	@GetMapping("/{id}")
	CategoriaResponse getCategoriaPorId(@PathVariable Long id);

}
