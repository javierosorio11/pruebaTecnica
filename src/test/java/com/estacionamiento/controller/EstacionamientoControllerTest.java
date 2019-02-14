package com.estacionamiento.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;
import com.estacionamiento.persistencia.ServicioEntity;
import com.estacionamiento.repositorio.IRepositorioServicio;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstacionamientoControllerTest {

	@Autowired
	private EstacionamientoController estacionamientoController;

	@Autowired
	IRepositorioServicio iRepositorioServicio;
	
	@Before
	public void cleanData(){
		
		iRepositorioServicio.deleteAll();
	}

	@Test
	public void registrarEntradaVehiculoTest() {

		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("TMQ");
		servicio.setTipoVehiculo(Utilitarios.CARRO);
		servicio.setModelo("2019");

		Factura factura = estacionamientoController.registrarEntradaVehiculo(servicio);

		Assert.assertEquals(servicio.getPlaca(), factura.getPlaca());

	}

	@Test
	public void verificarDisponibilidadServicioTest() {

		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("TMQ");
		servicio.setTipoVehiculo(Utilitarios.CARRO);
		servicio.setModelo("2019");

		boolean cupoDisponible = estacionamientoController.verificarDisponibilidadServicio(servicio);
		Assert.assertTrue(cupoDisponible);

	}

	@Test
	public void verificarNoDisponibilidadServicioTest() {
		creacionServicios();
		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("TMQ");
		servicio.setTipoVehiculo(Utilitarios.CARRO);
		servicio.setModelo("2019");

		boolean cupoDisponible = estacionamientoController.verificarDisponibilidadServicio(servicio);
		Assert.assertFalse(cupoDisponible);

	}

	public void creacionServicios() {
		for (int i = 0; i <= 40; i++) {
			ServicioEntity servicio = new ServicioEntity();
			servicio.setEstado(Utilitarios.PARQUEADO);
			if (i < 20) {
				servicio.setTipoVehiculo(Utilitarios.MOTO);
			} else {
				servicio.setTipoVehiculo(Utilitarios.CARRO);
			}
			iRepositorioServicio.save(servicio);
		}
	}
}
