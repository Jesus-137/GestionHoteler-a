package com.jesus.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="mvs-habitaciones")
public interface HabitacionClient {

	
}
