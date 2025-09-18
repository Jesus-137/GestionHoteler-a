package com.example.habitaciones.mappers;

import org.springframework.stereotype.Component;

import com.example.habitaciones.models.Habitacion;
import com.jesus.commons.Enum.EstadoHabitacionEnum;
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
		/*DISPONIBLE,
		OCUPADA,
		LIMPIEZA,
		MANTENIMIENTO;*/
		String estado;
		switch (request.estado()){
			case 1-> {
				estado = EstadoHabitacionEnum.DISPONIBLE.getNombre();
			}
			case 2->{
				estado = EstadoHabitacionEnum.OCUPADA.getNombre();
			}
			case 3->{
				estado = EstadoHabitacionEnum.LIMPIEZA.getNombre();
			}
			case 4->{
				estado = EstadoHabitacionEnum.MANTENIMIENTO.getNombre();
			}
			default->{
				throw new IllegalArgumentException("Unexpected value: " + request.estado());
			}
		}
		Habitacion habitacion = new Habitacion();
		habitacion.setNumero(request.numero());
		habitacion.setTipo(request.tipo());
		habitacion.setDescripcion(request.descripcion());
		habitacion.setPrecio(request.precio());
		habitacion.setCapacidad(request.capacidad());
		habitacion.setEstado(estado);
		return habitacion;
	}
}
