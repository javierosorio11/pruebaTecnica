
 package com.pruebaTecnica.dominio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pruebaTecnica.EstacionamientoAplication;
import com.pruebaTecnica.persistencia.ServicioEntity;
import com.pruebaTecnica.repositorio.IRepositorioServicio;
import com.pruebaTecnica.servicio.EstacionamientoService;
import com.pruebaTecnica.utils.Utilitarios;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstacionamientoAplication.class)
public class ServicioTest {
	

  @Autowired
  EstacionamientoService estacionamientoService;

	@Test
	public void registrarEntradaCarroTest() {
		ServicioEntity servicioEntity= new ServicioEntity();
		servicioEntity.setEstado(Utilitarios.PARQUEADO);
		servicioEntity.setModelo("1999");
		servicioEntity.setPlaca("TMQ");
		servicioEntity.setTipoVehiculo(Utilitarios.CARRO);
		Factura factura = new Factura();
	
		factura = estacionamientoService.registrarEntrada(servicioEntity);

		
		
		Assert.assertEquals("TMQ", factura.getPlaca());
		Assert.assertEquals(Utilitarios.CARRO,factura.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, factura.getEstado());
		
	}
	
	@Test
	public void registrarEntradaMotoTest() {
		ServicioEntity servicioEntity= new ServicioEntity();
		servicioEntity.setEstado(Utilitarios.PARQUEADO);
		servicioEntity.setModelo("1999");
		servicioEntity.setPlaca("TSQ");
		servicioEntity.setTipoVehiculo(Utilitarios.MOTO);
		Factura factura = new Factura();
	
		factura = estacionamientoService.registrarEntrada(servicioEntity);

		
		
		Assert.assertEquals("TSQ", factura.getPlaca());
		Assert.assertEquals(Utilitarios.MOTO,factura.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, factura.getEstado());
		
	}
	
	@Test
	public void verificarCupoDisponibleCarro() {
		ServicioEntity servicioEntity= new ServicioEntity();
		servicioEntity.setEstado(1);
		servicioEntity.setModelo("1999");
		servicioEntity.setPlaca("TSQ");
		servicioEntity.setTipoVehiculo(Utilitarios.MOTO);
		Factura factura = new Factura();
	
		factura = estacionamientoService.registrarEntrada(servicioEntity);

		
		
		Assert.assertEquals("TSQ", factura.getPlaca());
		Assert.assertEquals(Utilitarios.MOTO,factura.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, factura.getEstado());
		
	}



}