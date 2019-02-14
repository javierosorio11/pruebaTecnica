
package com.estacionamiento.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.EstacionamientoAplication;
import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;
import com.estacionamiento.persistencia.ServicioEntity;
import com.estacionamiento.repositorio.IRepositorioServicio;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstacionamientoAplication.class)
public class EstacionamientoServicioTest {

	@Autowired
	EstacionamientoService estacionamientoService;

	@Autowired
	IRepositorioServicio iRepositorioServicio;

	@Test
	public void registrarEntradaCarroTest() {
		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("TMQ");
		servicio.setTipoVehiculo(Utilitarios.CARRO);
		Factura factura = new Factura();

		factura = estacionamientoService.registrarEntrada(servicio);

		Assert.assertEquals("TMQ", factura.getPlaca());
		Assert.assertEquals(Utilitarios.CARRO, factura.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, factura.getEstado());

	}

	@Test
	public void registrarEntradaMotoTest() {
		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("TSQ");
		servicio.setTipoVehiculo(Utilitarios.MOTO);
		Factura factura = new Factura();

		factura = estacionamientoService.registrarEntrada(servicio);

		Assert.assertEquals("TSQ", factura.getPlaca());
		Assert.assertEquals(Utilitarios.MOTO, factura.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, factura.getEstado());

	}
/*
	@Test
	public void verificarCupoNoDisponibleCarro() {

		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setTipoVehiculo(Utilitarios.CARRO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(servicio);

		Assert.assertEquals(false, disponibilidad);

	}

	@Test
	public void verificarCupoNoDisponibleMoto() {

		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setTipoVehiculo(Utilitarios.MOTO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(servicio);

		Assert.assertEquals(false, disponibilidad);

	}*/
	
	@Test
	public void verificarCupoDisponibleCarroTest() {

		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setTipoVehiculo(Utilitarios.CARRO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(servicio);

		Assert.assertEquals(true, disponibilidad);

	}

	@Test
	public void verificarCupoDisponibleMotoTest() {

		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setTipoVehiculo(Utilitarios.MOTO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(servicio);

		Assert.assertEquals(true, disponibilidad);

	}
	

}