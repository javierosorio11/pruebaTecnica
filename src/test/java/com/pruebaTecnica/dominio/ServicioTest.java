package com.pruebaTecnica.dominio;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pruebaTecnica.persistencia.ServicioEntity;
import com.pruebaTecnica.servicio.EstacionamientoService;
import com.pruebaTecnica.utils.Utilitarios;

public class ServicioTest {
	


	@Test
	public void registrarEntradaCarroTest() {
		Utilitarios util= new Utilitarios();
		EstacionamientoService estacionamientoService = new EstacionamientoService();
		Factura factura = new Factura();
		ServicioEntity servicio=new ServicioEntity();
		servicio.setEstado(util.PARQUEADO);
		servicio.setModelo("999");
		servicio.setPlaca("ITB2334");
		servicio.setTipoVehiculo(util.CARRO);
		
		factura = estacionamientoService.registrarEntrada(servicio);
		Assert.assertNotNull(factura);
	}


}
