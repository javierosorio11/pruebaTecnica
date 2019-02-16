package com.estacionamiento.dominio;

import org.junit.Assert;
import org.junit.Test;

import com.estacionamiento.utils.Utilitarios;

public class VehiculoTest {

	@Test
	public void constructorTest() {

		Vehiculo vehiculo = new Vehiculo("TTT_223", "12-01-2019 12:22:23", "14-02-2019 12:22:23", Utilitarios.MOTO,
				Utilitarios.PARQUEADO, 500, 5000);

		Assert.assertNotNull(vehiculo);
		Assert.assertEquals("TTT_223", vehiculo.getPlaca());
		Assert.assertEquals("12-01-2019 12:22:23", vehiculo.getFechaHoraIngreso());
		Assert.assertEquals("14-02-2019 12:22:23", vehiculo.getFechaHoraSalida());
		Assert.assertEquals(Utilitarios.MOTO, vehiculo.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, vehiculo.getEstado());
		Assert.assertEquals(500, vehiculo.getCilindraje());
		Assert.assertEquals(5000, vehiculo.getValorServicio());

	}

	@Test
	public void gettersAndSetters() {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setCilindraje(500);
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setFechaHoraIngreso("12-01-2019 12:22:23");
		vehiculo.setFechaHoraSalida("14-02-2019 12:22:23");
		vehiculo.setPlaca("TTT_223");
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);
		vehiculo.setValorServicio(5000);

		Assert.assertNotNull(vehiculo);
		Assert.assertEquals("TTT_223", vehiculo.getPlaca());
		Assert.assertEquals("12-01-2019 12:22:23", vehiculo.getFechaHoraIngreso());
		Assert.assertEquals("14-02-2019 12:22:23", vehiculo.getFechaHoraSalida());
		Assert.assertEquals(Utilitarios.CARRO, vehiculo.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, vehiculo.getEstado());
		Assert.assertEquals(500, vehiculo.getCilindraje());
		Assert.assertEquals(5000, vehiculo.getValorServicio());

	}

}
