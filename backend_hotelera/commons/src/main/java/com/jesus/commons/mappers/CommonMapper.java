package com.jesus.commons.mappers;

import org.springframework.stereotype.Component;

@Component
public abstract class CommonMapper <RQ, RS, E>{
	
	public abstract RS entityToResponse(E entity);
	
	public abstract E requetsToEntity(RQ request);
}
