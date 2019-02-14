package com.estacionamiento.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstacionamientoControllerTest {


	@Autowired
	private EstacionamientoController estacionamientoController;
	
	/*@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}*/
	
	@Test
	public void test() {
		
		Servicio servicio = new Servicio();
		servicio.setEstado(Utilitarios.PARQUEADO);
		servicio.setModelo("1999");
		servicio.setPlaca("TMQ");
		servicio.setTipoVehiculo(Utilitarios.CARRO);
		servicio.setModelo("2019");
	
	

		
		Factura factura=estacionamientoController.registrarEntradaVehiculo(servicio);
		
		Assert.assertEquals(servicio.getPlaca(), factura.getPlaca());
	
		
		
	}

}
