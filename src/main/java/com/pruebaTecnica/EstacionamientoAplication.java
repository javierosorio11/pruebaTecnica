package com.pruebaTecnica;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pruebaTecnica.persistencia.ServicioEntity;
import com.pruebaTecnica.repositorio.IRepositorioServicio;
import com.pruebaTecnica.utils.Utilitarios;


@SpringBootApplication

public class EstacionamientoAplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamientoAplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initServiciosParqueadero(IRepositorioServicio iRepositorioServicio) {
			
		
			return args -> {
				
				
				ServicioEntity servicio = new ServicioEntity();
				servicio.setFechaHoraIngreso("11-02-2019 09:22:23");
				servicio.setModelo("1999");
				servicio.setPlaca("AVJGEC");
				servicio.setTipoVehiculo(Utilitarios.MOTO);
				servicio.setEstado(Utilitarios.PARQUEADO);
				
				
				iRepositorioServicio.save(servicio);
				servicio = iRepositorioServicio.findByPlaca("AVJGEC");
				List <ServicioEntity> lstServicios= iRepositorioServicio.findAllByTipoVehiculo(servicio.getTipoVehiculo());
				
				
			};

		}
}
