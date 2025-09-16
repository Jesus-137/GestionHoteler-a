package com.example.habitaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.habitaciones", "com.jesus.commons"})
public class MvsHabitacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvsHabitacionesApplication.class, args);
	}

}
