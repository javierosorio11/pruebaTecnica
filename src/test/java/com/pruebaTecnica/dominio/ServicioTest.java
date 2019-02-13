
 package com.pruebaTecnica.dominio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pruebaTecnica.persistencia.ServicioEntity;
import com.pruebaTecnica.repositorio.IRepositorioServicio;
import com.pruebaTecnica.servicio.EstacionamientoService;
import com.pruebaTecnica.utils.Utilitarios;

public class ServicioTest {
	
  @Autowired
  IRepositorioServicio iRepositorioServicio;


  
	@Test
	public void registrarEntradaCarroTest() {
		ServicioEntity servicioEntity= new ServicioEntity();
		servicioEntity.setEstado(1);
		servicioEntity.setModelo("1999");
		servicioEntity.setPlaca("TSQ");
		servicioEntity.setTipoVehiculo(1);
		EstacionamientoService estacionamientoService = new EstacionamientoService();
		Factura factura = new Factura();
	
		factura = estacionamientoService.registrarEntrada(servicioEntity);

		
		
		Assert.assertEquals("TSQ", factura.getPlaca());
	}


}