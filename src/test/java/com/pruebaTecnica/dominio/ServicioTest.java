
 package com.pruebaTecnica.dominio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.EstacionamientoAplication;
import com.estacionamiento.dominio.Factura;
import com.estacionamiento.persistencia.ServicioEntity;
import com.estacionamiento.repositorio.IRepositorioServicio;
import com.estacionamiento.servicio.EstacionamientoService;
import com.estacionamiento.utils.Utilitarios;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstacionamientoAplication.class)
public class ServicioTest {
	

  @Autowired
  EstacionamientoService estacionamientoService;
  
  @Autowired
  IRepositorioServicio iRepositorioServicio;

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
	public void verificarCupoNoDisponibleCarro() {
		ServicioEntity servicioEntity= new ServicioEntity();
		
		for(int i = 0; i <= 20; i++){
		servicioEntity.setEstado(1);
		servicioEntity.setModelo("1999");
		servicioEntity.setPlaca("TSQ");
		servicioEntity.setTipoVehiculo(Utilitarios.MOTO);
		Factura factura = new Factura();
		iRepositorioServicio.save(servicioEntity);
		
		}
		
		boolean disponibilidad = estacionamientoService.verificarDisponibilidadServicio(servicioEntity);

		
		
		Assert.assertEquals(true, disponibilidad);
		
		
	}



}