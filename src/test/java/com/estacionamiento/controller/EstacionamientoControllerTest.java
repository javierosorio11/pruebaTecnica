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
import com.estacionamiento.dominio.Recibo;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.persistencia.VehiculoEntity;
import com.estacionamiento.repositorio.IRepositorioVehiculo;
import com.estacionamiento.servicio.EstacionamientoService;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstacionamientoControllerTest {

	@Autowired
	private EstacionamientoController estacionamientoController;

	@Autowired
	IRepositorioVehiculo iRepositorioVehiculo;

	@Autowired
	EstacionamientoService estacionamientoService;

	@Before
	public void cleanData() {

		iRepositorioVehiculo.deleteAll();
	}

	@Test
	public void registrarEntradaCarroTest() throws EstacionamientoException, ParseException {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setPlaca("TMQ");
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);

		Recibo recibo = estacionamientoController.registrarEntradaVehiculo(vehiculo);

		Assert.assertEquals(vehiculo.getPlaca(), recibo.getPlaca());
		Assert.assertEquals(vehiculo.getTipoVehiculo(), recibo.getTipoVehiculo());

	}

	@Test
	public void registrarEntradaMotoTest() throws EstacionamientoException, ParseException {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setPlaca("QTM");
		vehiculo.setTipoVehiculo(Utilitarios.MOTO);

		Recibo recibo = estacionamientoController.registrarEntradaVehiculo(vehiculo);

		Assert.assertEquals(vehiculo.getPlaca(), recibo.getPlaca());
		Assert.assertEquals(vehiculo.getTipoVehiculo(), recibo.getTipoVehiculo());

	}

	@Test
	public void verificarDisponibilidadServicioCarroTest() throws EstacionamientoException {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setPlaca("TMQ");
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);

		boolean cupoDisponible = estacionamientoController.verificarDisponibilidadServicio(vehiculo);
		Assert.assertTrue(cupoDisponible);

	}

	@Test
	public void verificarNoDisponibilidadServicioCarroTest() throws EstacionamientoException {
		creacionServicios();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setPlaca("TMQ");
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);

		boolean cupoDisponible = estacionamientoController.verificarDisponibilidadServicio(vehiculo);
		Assert.assertFalse(cupoDisponible);

	}

	@Test
	public void verificarDisponibilidadServicioMotoTest() throws EstacionamientoException {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca("TWU");
		vehiculo.setTipoVehiculo(Utilitarios.MOTO);

		boolean cupoDisponible = estacionamientoController.verificarDisponibilidadServicio(vehiculo);
		Assert.assertTrue(cupoDisponible);

	}

	@Test
	public void verificarNoDisponibilidadServicioMotoTest() throws EstacionamientoException {
		creacionServicios();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca("TXR");
		vehiculo.setTipoVehiculo(Utilitarios.MOTO);

		boolean cupoDisponible = estacionamientoController.verificarDisponibilidadServicio(vehiculo);
		Assert.assertFalse(cupoDisponible);

	}

	@Test
	public void registrarSalidaCarroTest() throws EstacionamientoException, ParseException {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setPlaca("QWE");
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);

		Factura facturaSalida = estacionamientoController
				.registrarSalidaVehiculo(estacionamientoService.registrarEntrada(vehiculo));

		Assert.assertEquals("QWE", facturaSalida.getPlaca());
		Assert.assertEquals(Utilitarios.CARRO, facturaSalida.getTipoVehiculo());
		Assert.assertNotEquals(Utilitarios.PARQUEADO, facturaSalida.getEstado());

	}

	public void creacionServicios() {
		for (int i = 0; i <= 40; i++) {
			VehiculoEntity servicio = new VehiculoEntity();
			servicio.setEstado(Utilitarios.PARQUEADO);
			if (i < 20) {
				servicio.setTipoVehiculo(Utilitarios.MOTO);
			} else {
				servicio.setTipoVehiculo(Utilitarios.CARRO);
			}
			iRepositorioVehiculo.save(servicio);
		}
	}
}
