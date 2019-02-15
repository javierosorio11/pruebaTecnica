package com.estacionamiento;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.estacionamiento.repositorio.IRepositorioVehiculo;

@SpringBootApplication

public class EstacionamientoAplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamientoAplication.class, args);
	}

	@Bean
	public CommandLineRunner initServiciosParqueadero(IRepositorioVehiculo iRepositorioVehiculo) {

		return args -> {

		};

	}
}
