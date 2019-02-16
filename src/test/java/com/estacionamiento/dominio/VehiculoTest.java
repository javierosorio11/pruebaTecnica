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

}
