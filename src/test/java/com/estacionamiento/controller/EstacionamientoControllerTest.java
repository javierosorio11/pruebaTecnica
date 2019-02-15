package com.estacionamiento.controller;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.persistencia.ServicioEntity;
import com.estacionamiento.repositorio.IRepositorioFactura;
import com.estacionamiento.repositorio.IRepositorioServicio;
import com.estacionamiento.servicio.EstacionamientoService;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstacionamientoControllerTest {

	@Autowired
	private EstacionamientoController estacionamientoController;

	@Autowired
	IRepositorioServicio iRepositorioServicio;
	
	@Autowired
	EstacionamientoService estacionamientoService;
	
	@Before
	public void cleanData(){
		
		iRepositorioServicio.deleteAll();
	}

	@Test
	public void registrarEntradaCarroTest() throws EstacionamientoException, ParseException {

		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("TMQ");
		servicio.setTipoVehiculo(Utilitarios.CARRO);
		servicio.setModelo("2019");

		Factura factura = estacionamientoController.registrarEntradaVehiculo(servicio);

		Assert.assertEquals(servicio.getPlaca(), factura.getPlaca());
		Assert.assertEquals(servicio.getTipoVehiculo(), factura.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, factura.getEstado());

	}
	
	@Test
	public void registrarEntradaMotoTest() throws EstacionamientoException, ParseException {

		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("QTM");
		servicio.setTipoVehiculo(Utilitarios.MOTO);

		Factura factura = estacionamientoController.registrarEntradaVehiculo(servicio);

		Assert.assertEquals(servicio.getPlaca(), factura.getPlaca());
		Assert.assertEquals(servicio.getTipoVehiculo(), factura.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, factura.getEstado());

	}

	@Test
	public void verificarDisponibilidadServicioCarroTest() throws EstacionamientoException {

		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("TMQ");
		servicio.setTipoVehiculo(Utilitarios.CARRO);

		boolean cupoDisponible = estacionamientoController.verificarDisponibilidadServicio(servicio);
		Assert.assertTrue(cupoDisponible);

	}

	@Test
	public void verificarNoDisponibilidadServicioCarroTest() throws EstacionamientoException {
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
	
	@Test
	public void verificarDisponibilidadServicioMotoTest() throws EstacionamientoException {

		Servicio servicio = new Servicio();
		servicio.setPlaca("TWU");
		servicio.setTipoVehiculo(Utilitarios.MOTO);
		servicio.setModelo("2019");

		boolean cupoDisponible = estacionamientoController.verificarDisponibilidadServicio(servicio);
		Assert.assertTrue(cupoDisponible);

	}
	
	@Test
	public void verificarNoDisponibilidadServicioMotoTest() throws EstacionamientoException {
		creacionServicios();
		Servicio servicio = new Servicio();
		servicio.setPlaca("TXR");
		servicio.setTipoVehiculo(Utilitarios.MOTO);
		servicio.setModelo("2019");

		boolean cupoDisponible = estacionamientoController.verificarDisponibilidadServicio(servicio);
		Assert.assertFalse(cupoDisponible);

	}
	
	@Test
	public void registrarSalidaCarroTest() throws EstacionamientoException, ParseException {
		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("QWE");
		servicio.setTipoVehiculo(Utilitarios.CARRO);
		

		Factura facturaSalida = estacionamientoController.registrarSalidaVehiculo(estacionamientoService.registrarEntrada(servicio));
		

		Assert.assertEquals("QWE", facturaSalida.getPlaca());
		Assert.assertEquals(Utilitarios.CARRO, facturaSalida.getTipoVehiculo());
		Assert.assertNotEquals(Utilitarios.PARQUEADO, facturaSalida.getEstado());

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
