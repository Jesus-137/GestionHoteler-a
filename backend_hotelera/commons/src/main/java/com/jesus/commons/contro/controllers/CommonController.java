package com.jesus.commons.contro.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.jesus.commons.services.CommonService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@Validated
public class CommonController <RQ, RS, S extends CommonService<RQ, RS>>{
	
	protected S Service;

	public CommonController(S service) {
		this.Service = service;
	}
	
	@GetMapping
	public ResponseEntity <List<RS>> listar(){
		return ResponseEntity.ok(Service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RS> obtenerPorId(@PathVariable
			@Positive(message="El id deveser un entero positivo") Long id){
		return ResponseEntity.ok(Service.ObtenerPorId(id));
	}
	
	@PostMapping
	public ResponseEntity <RS> insertar(@Valid @RequestBody RQ request){
		return ResponseEntity.status(HttpStatus.CREATED).body(Service.Insertar(request));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RS> actualizar(@PathVariable
			@Positive(message="El id debe ser un numero positivo") Long id, @Valid @RequestBody RQ request){
		return ResponseEntity.ok(Service.actualizar(request, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RS> eliminar(@PathVariable @Positive(message = "El id debe ser positivo") Long id){
		return ResponseEntity.ok(Service.eliminar(id));
	}
}
