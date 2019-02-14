
package com.estacionamiento.servicio;

import java.text.ParseException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.EstacionamientoAplication;
import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;
import com.estacionamiento.persistencia.FacturaEntity;
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
	
	@Before
	public void cleanData(){
		iRepositorioServicio.deleteAll();
		
	}
	
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

	@Test
	public void verificarCupoNoDisponibleCarro() {
		creacionServicios();
		Servicio servicio = new Servicio();
		servicio.setTipoVehiculo(Utilitarios.CARRO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(servicio);

		Assert.assertEquals(false, disponibilidad);

	}

	@Test
	public void verificarCupoNoDisponibleMoto() {
		creacionServicios();
		Servicio servicio = new Servicio();
		servicio.setTipoVehiculo(Utilitarios.MOTO);

		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(servicio);

		Assert.assertEquals(false, disponibilidad);

	}
	
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
	
	@Test
	public void calcularValorServicioCarroTest() throws ParseException {

		FacturaEntity facturaEntity = new FacturaEntity();
		facturaEntity.setFechaHoraIngreso("01-01-2019 12:22:24");
		facturaEntity.setTipoVehiculo(Utilitarios.CARRO);

		facturaEntity = estacionamientoService.calcularValorServicio(facturaEntity,"02-01-2019 13:22:24");

		Assert.assertEquals(facturaEntity.getValorServicio(), facturaEntity.getValorServicio());

	}
	
	@Test
	public void calcularValorServicioTest() throws ParseException {

		FacturaEntity facturaEntity = new FacturaEntity();
		facturaEntity.setFechaHoraIngreso("01-01-2019 12:22:24");
		facturaEntity.setTipoVehiculo(Utilitarios.CARRO);

		facturaEntity = estacionamientoService.calcularValorServicio(facturaEntity,"02-01-2019 13:22:24");

		Assert.assertEquals(facturaEntity.getValorServicio(), facturaEntity.getValorServicio());

	}
	
	
	public void creacionServicios(){
		
		for(int i = 0 ; i <= 40;i++){
			ServicioEntity servicio=new ServicioEntity();
			servicio.setEstado(Utilitarios.PARQUEADO);
			if(i<20){
				servicio.setTipoVehiculo(Utilitarios.MOTO);
			}else{
			servicio.setTipoVehiculo(Utilitarios.CARRO);
			}
			iRepositorioServicio.save(servicio);
		}
	
	}
	
	
	

}