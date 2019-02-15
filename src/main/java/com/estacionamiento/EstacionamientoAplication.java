package com.estacionamiento;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.estacionamiento.repositorio.IRepositorioFactura;
import com.estacionamiento.repositorio.IRepositorioServicio;

@SpringBootApplication

public class EstacionamientoAplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamientoAplication.class, args);
	}

	@Bean
	public CommandLineRunner initServiciosParqueadero(IRepositorioServicio iRepositorioServicio,
			IRepositorioFactura iRepositorioFactura) {

		return args -> {

			/*
			 * ServicioEntity servicio = new ServicioEntity();
			 * servicio.setFechaHoraIngreso("13-02-2019 23:50:23");
			 * servicio.setModelo("1999"); servicio.setPlaca("AVJGEC");
			 * servicio.setTipoVehiculo(Utilitarios.CARRO);
			 * servicio.setEstado(Utilitarios.PARQUEADO); FacturaEntity
			 * facturaEntity=new FacturaEntity();
			 * facturaEntity.setFechaHoraIngreso(servicio.getFechaHoraIngreso())
			 * ; facturaEntity.setPlaca(servicio.getPlaca());
			 * facturaEntity.setTipoVehiculo(servicio.getTipoVehiculo());
			 * iRepositorioServicio.save(servicio);
			 * iRepositorioFactura.save(facturaEntity);
			 */

		};

	}
}
