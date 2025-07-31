package com.example.Microservice_InventoryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceInventoryServiceApplication.class, args);
		System.out.println("Inventory application started...");
	}

}
