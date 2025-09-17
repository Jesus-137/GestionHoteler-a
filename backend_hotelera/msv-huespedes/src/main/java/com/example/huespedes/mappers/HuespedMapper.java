package com.example.huespedes.mappers;

import org.springframework.stereotype.Component;

import com.example.huespedes.models.Huesped;
import com.jesus.commons.dto.HuespedRequest;
import com.jesus.commons.dto.HuespedResponse;
import com.jesus.commons.mappers.CommonMapper;

@Component
public class HuespedMapper extends CommonMapper<HuespedRequest, HuespedResponse, Huesped>{
	@Override
	public HuespedResponse entityToResponse(Huesped entity) {
		if(entity == null) {
			return null;
		}
		return new HuespedResponse(entity.getId(),entity.getNombre(), entity.getApellido(), entity.getEmail(),
				entity.getTelefono(), entity.getDocumento(), entity.getNacionalidad());
	}
	@Override
	public Huesped requetsToEntity(HuespedRequest request) {
		if(request == null) {
			return null;
		}
		Huesped huesped = new Huesped();
		huesped.setNombre(request.nombre());
		huesped.setApellido(request.apellido());
		huesped.setEmail(request.email());
		huesped.setTelefono(request.telefono());
		huesped.setDocumento(request.documento());
		huesped.setNacionalidad(request.nacionalidad());
		return huesped;
	}

}
