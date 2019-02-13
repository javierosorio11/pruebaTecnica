package com.pruebaTecnica;

import java.sql.Date;
import java.util.Calendar;
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
				
				Utilitarios util = new Utilitarios();
				ServicioEntity servicio = new ServicioEntity();
				servicio.setFechaHoraIngreso("11-02-2019 09:22:23");
				servicio.setModelo("1999");
				servicio.setPlaca("AVJGEC");
				servicio.setTipoVehiculo(util.MOTO);
				servicio.setEstado(util.PARQUEADO);
				
				
				iRepositorioServicio.save(servicio);
				servicio = iRepositorioServicio.findByPlaca("AVJGEC");
				List <ServicioEntity> lstServicios= iRepositorioServicio.findAllByTipoVehiculo(servicio.getTipoVehiculo());
				
				System.out.println(servicio.getFechaHoraIngreso()+" Disponibles"+(lstServicios.size()-20) );
				
			};

		}
}
