
package com.estacionamiento.servicio;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.EstacionamientoAplication;
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

		Vehiculo recibo = estacionamientoService.registrarEntrada(vehiculo);

		Assert.assertEquals("TMQ", recibo.getPlaca());
		Assert.assertEquals(Utilitarios.CARRO, recibo.getTipoVehiculo());

	}

	@Test
	public void registrarEntradaMotoTest() throws EstacionamientoException {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setPlaca("TSQ");
		vehiculo.setTipoVehiculo(Utilitarios.MOTO);

		Vehiculo recibo = estacionamientoService.registrarEntrada(vehiculo);

		Assert.assertEquals("TSQ", recibo.getPlaca());
		Assert.assertEquals(Utilitarios.MOTO, recibo.getTipoVehiculo());

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
	public void validarNoExisteTest() throws ParseException {

		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlacaVehiculo("TQM556");
		vehiculoEntity.setFechaHoraIngresoVehiculo("01-01-2019 05:22:24");
		vehiculoEntity.setFechaHoraSalidaVehiculo("01-01-2019 18:22:24");
		vehiculoEntity.setTipoVehiculo(Utilitarios.MOTO);
		vehiculoEntity.setEstadoVehiculo(Utilitarios.PARQUEADO);
		vehiculoEntity.setCilindrajeVehiculo(650);
		iRepositorioVehiculo.save(vehiculoEntity);
		String exception = "";
		try {

			estacionamientoService.validarNoExiste(vehiculoEntity.getPlacaVehiculo());

		} catch (EstacionamientoException e) {

			exception = e.getMessage();
		}
		Assert.assertEquals(Utilitarios.VEHICULO_EXITE, exception);

	}

	@Test
	public void vehiculosEstacionadosTest() throws EstacionamientoException {

		crearVehiculos();

		List<Vehiculo> lstVehiculos = estacionamientoService.vehiculosEstacionados();

		Assert.assertNotNull(lstVehiculos);

	}

	@Test
	public void calcularValorServicioMotoTest() throws ParseException {

		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setFechaHoraIngresoVehiculo("01-01-2019 05:22:24");
		vehiculoEntity.setFechaHoraSalidaVehiculo("01-01-2019 18:22:24");
		vehiculoEntity.setTipoVehiculo(Utilitarios.MOTO);
		vehiculoEntity.setEstadoVehiculo(Utilitarios.PARQUEADO);
		vehiculoEntity.setCilindrajeVehiculo(650);

		long ValorServicio = estacionamientoService.calcularValorServicio(vehiculoEntity);

		Assert.assertEquals(6000, ValorServicio);

	}

	public void crearVehiculos() {
		for (int i = 0; i <= 40; i++) {
			VehiculoEntity vehiculoEntity = new VehiculoEntity();
			vehiculoEntity.setPlacaVehiculo("TTR" + i);
			vehiculoEntity.setEstadoVehiculo(Utilitarios.PARQUEADO);
			if (i < 20) {
				vehiculoEntity.setTipoVehiculo(Utilitarios.MOTO);
			} else {
				vehiculoEntity.setTipoVehiculo(Utilitarios.CARRO);
			}
			iRepositorioVehiculo.save(vehiculoEntity);
		}
	}

}