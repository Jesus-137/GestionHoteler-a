package com.jesus.commons.mappers;

import org.springframework.stereotype.Component;

@Component
public abstract class CommonMapper <RQ, RS, E>{
	
	protected abstract RS entityToResponse(E entity);
	
	protected abstract E requestToEntity(RQ request);
}
