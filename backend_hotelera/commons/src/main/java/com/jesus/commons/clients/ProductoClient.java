package com.jesus.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="msv-productos")
public interface ProductoClient {
	
	@GetMapping("/id-proveedor/{id}")
	boolean proveedorIsPresent(@PathVariable Long id);
	
	@GetMapping("/id-categoria/{id}")
	boolean categoriaIsPresent(@PathVariable Long id);
}
