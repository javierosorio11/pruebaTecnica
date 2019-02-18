package com.estacionamiento.exception;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.EstacionamientoAplication;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.persistencia.VehiculoEntity;
import com.estacionamiento.repositorio.IRepositorioVehiculo;
import com.estacionamiento.servicio.EstacionamientoService;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstacionamientoAplication.class)
public class EstacionamientoExceptionTest {

	@Autowired
	EstacionamientoService estacionamientoService;

	@Autowired
	IRepositorioVehiculo iRepositorioVehiculo;

	@Before
	public void cleanData() {

		iRepositorioVehiculo.deleteAll();
	}

	@Ignore
	@Test
	public void ExcepcionPlacaATest() throws ParseException {

		String exception = "";

		try {
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setEstado(Utilitarios.PARQUEADO);
			vehiculo.setPlaca("AMQ");
			vehiculo.setTipoVehiculo(Utilitarios.CARRO);
			vehiculo.setCilindraje(0);

			estacionamientoService.registrarEntrada(vehiculo);
		} catch (EstacionamientoException e) {

			exception = e.getMessage();
		}

		Assert.assertEquals("Hoy no tiene permitido ingresar", exception);

	}

	@Test
	public void ExcepcionCupoTest() throws ParseException {

		String exception = "";

		try {
			crearVehiculos();
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setEstado(Utilitarios.PARQUEADO);
			vehiculo.setPlaca("AMQ");
			vehiculo.setTipoVehiculo(Utilitarios.CARRO);
			vehiculo.setCilindraje(0);

			estacionamientoService.registrarEntrada(vehiculo);
		} catch (EstacionamientoException e) {

			exception = e.getMessage();
		}

		Assert.assertEquals("No hay cupo disponible", exception);

	}

	@Test
	public void ExcepcionNoHayVehiculos() {

		String exception = "";

		try {

			estacionamientoService.vehiculosEstacionados();

		} catch (EstacionamientoException e) {

			exception = e.getMessage();
		}

		Assert.assertEquals(Utilitarios.NO_EXISTEN_VEHICULOS, exception);

	}

	public void crearVehiculos() {

		for (int i = 0; i <= 40; i++) {
			VehiculoEntity servicio = new VehiculoEntity();
			servicio.setEstadoVehiculo(Utilitarios.PARQUEADO);
			if (i < 20) {
				servicio.setTipoVehiculo(Utilitarios.MOTO);
			} else {
				servicio.setTipoVehiculo(Utilitarios.CARRO);
			}
			iRepositorioVehiculo.save(servicio);
		}

	}

}
