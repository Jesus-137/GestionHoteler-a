package com.hotelera.reserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hotelera.reserva", "com.jesus.commons"})
public class MsvReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvReservaApplication.class, args);
	}

}
