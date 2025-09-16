package com.example.habitaciones.mappers;

import org.springframework.stereotype.Component;

import com.example.habitaciones.models.Habitacion;
import com.jesus.commons.dto.HabitacionRequest;
import com.jesus.commons.dto.HabitacionResponse;
import com.jesus.commons.mappers.CommonMapper;

@Component
public class HabitacionMapper extends CommonMapper <HabitacionRequest, HabitacionResponse, Habitacion>{

	@Override
	public HabitacionResponse entityToResponse(Habitacion entity) {
		if (entity == null) {
			return null;
		}
		
		return new HabitacionResponse(
				entity.getId(),
				entity.getNumero(),
				entity.getTipo(),
				entity.getDescripcion(),
				entity.getPrecio(),
				entity.getCapacidad(),
				entity.getEstado()
				);
	}

	@Override
	public Habitacion requetsToEntity(HabitacionRequest request) {
		if (request == null) {
			return null;
		}
		Habitacion habitacion = new Habitacion();
		habitacion.setNumero(request.numero());
		return habitacion;
	}

	

}
