
package com.estacionamiento.servicio;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.EstacionamientoAplication;
import com.estacionamiento.dominio.Recibo;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.persistencia.VehiculoEntity;
import com.estacionamiento.repositorio.IRepositorioVehiculo;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstacionamientoAplication.class)
public class EstacionamientoServicioTest {

	@Autowired
	EstacionamientoService estacionamientoService;

	@Autowired
	IRepositorioVehiculo iRepositorioVehiculo;

	@Before
	public void cleanData() {
		iRepositorioVehiculo.deleteAll();

	}

	@Test
	public void registrarEntradaCarroTest() throws EstacionamientoException {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setPlaca("TMQ");
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);
		vehiculo.setCilindraje(0);

		Recibo recibo = estacionamientoService.registrarEntrada(vehiculo);

		Assert.assertEquals("TMQ", recibo.getPlacaRecibo());
		Assert.assertEquals(Utilitarios.CARRO, recibo.getTipoVehiculoRecibo());

	}

	@Test
	public void registrarEntradaMotoTest() throws EstacionamientoException {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setPlaca("TSQ");
		vehiculo.setTipoVehiculo(Utilitarios.MOTO);

		Recibo recibo = estacionamientoService.registrarEntrada(vehiculo);

		Assert.assertEquals("TSQ", recibo.getPlacaRecibo());
		Assert.assertEquals(Utilitarios.MOTO, recibo.getTipoVehiculoRecibo());

	}

	@Test
	public void verificarCupoNoDisponibleCarro() throws EstacionamientoException {
		crearVehiculos();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(vehiculo);

		Assert.assertEquals(false, disponibilidad);

	}

	@Test
	public void verificarCupoNoDisponibleMoto() {
		crearVehiculos();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setTipoVehiculo(Utilitarios.MOTO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(vehiculo);

		Assert.assertEquals(false, disponibilidad);

	}

	@Test
	public void verificarCupoDisponibleCarroTest() throws EstacionamientoException {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(vehiculo);

		Assert.assertEquals(true, disponibilidad);

	}

	@Test
	public void verificarCupoDisponibleMotoTest() throws EstacionamientoException {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setTipoVehiculo(Utilitarios.MOTO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(vehiculo);

		Assert.assertEquals(true, disponibilidad);

	}

	@Test
	public void calcularValorServicioCarroTest() throws ParseException {

		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setFechaHoraIngresoVehiculo("01-01-2019 12:22:24");
		vehiculoEntity.setFechaHoraSalidaVehiculo("02-01-2019 15:22:24");
		vehiculoEntity.setTipoVehiculo(Utilitarios.CARRO);

		long ValorServicio = estacionamientoService.calcularValorServicio(vehiculoEntity);

		Assert.assertEquals(11000, ValorServicio);

	}

	@Test
	public void calcularValorServicioMotoTest() throws ParseException {

		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setFechaHoraIngresoVehiculo("01-01-2019 05:22:24");
		vehiculoEntity.setFechaHoraSalidaVehiculo("01-01-2019 18:22:24");
		vehiculoEntity.setTipoVehiculo(Utilitarios.MOTO);
		vehiculoEntity.setCilindrajeVehiculo(650);

		long ValorServicio = estacionamientoService.calcularValorServicio(vehiculoEntity);

		Assert.assertEquals(6000, ValorServicio);

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