package com.example.huspedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.huespedes","com.jesus.commons"})
public class MsvHuespedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvHuespedesApplication.class, args);
	}

}
