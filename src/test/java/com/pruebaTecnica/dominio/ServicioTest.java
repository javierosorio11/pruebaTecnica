package com.pruebaTecnica.dominio;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pruebaTecnica.EstacionamientoAplication;
import com.pruebaTecnica.controller.EstacionamientoController;
import com.pruebaTecnica.persistencia.ServicioEntity;
import com.pruebaTecnica.repositorio.IRepositorioServicio;
import com.pruebaTecnica.servicio.EstacionamientoService;
import com.pruebaTecnica.utils.Utilitarios;

public class ServicioTest {
	
  @Autowired
  IRepositorioServicio iRepositorioServicio;


  /*
	@Test
	public void registrarEntradaCarroTest() {
		ServicioEntity servicioEntity= new ServicioEntity();
		servicioEntity.setEstado(1);
		servicioEntity.setModelo("1999");
		servicioEntity.setPlaca("TSQ");
		servicioEntity.setTipoVehiculo(1);
		Utilitarios util= new Utilitarios();
		EstacionamientoService estacionamientoService = new EstacionamientoService();
		Factura factura = new Factura();
	
		factura = estacionamientoService.registrarEntrada(servicioEntity);

		
		
		Assert.assertEquals("TSQ", factura.getPlaca());
	}*/


}
