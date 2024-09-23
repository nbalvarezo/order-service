package com.meiggsmarket.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Marca la clase como la aplicación principal de Spring Boot, habilitando la configuración automática.
public class OrderServiceApplication {

	public static void main(String[] args) {
		// Inicia la aplicación Spring Boot, configurando el contexto y cargando los componentes necesarios.
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
