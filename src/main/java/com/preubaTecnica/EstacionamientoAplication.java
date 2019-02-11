package com.preubaTecnica;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pruebaTecnica.persistencia.ServicioEntity;
import com.pruebaTecnica.repositorio.IRepositorioServicio;


@SpringBootApplication
@ComponentScan({"com.pruebaTecnica.repositorio"})
@EntityScan("com.pruebaTecnica.persistencia")
@EnableJpaRepositories("com.pruebaTecnica.repositorio")
public class EstacionamientoAplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamientoAplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initServiciosParqueadero(IRepositorioServicio iRepositorioServicio) {
			
		
			return args -> {
				
				
				ServicioEntity servicio = new ServicioEntity();
				servicio.setFechaHoraIngreso(new Date(1));
				servicio.setFechaHoraSalida(new Date(1));
				servicio.setModelo("1999");
				servicio.setPlaca("AVJGEC");
				servicio.setTipoVehiculo(1);
				
				
				iRepositorioServicio.save(servicio);
				servicio = iRepositorioServicio.findByPlaca("AVJGEC");
				List <ServicioEntity> lstServicios= iRepositorioServicio.findAllByTipoVehiculo(servicio.getTipoVehiculo());
				
				System.out.println(servicio.getFechaHoraIngreso()+" Disponibles"+(lstServicios.size()-20) );
				
			};

		}
}
