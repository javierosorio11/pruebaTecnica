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
		Assert.assertEquals("TTT_223", vehiculo.getPlacaVehiculo());
		Assert.assertEquals("12-01-2019 12:22:23", vehiculo.getFechaHoraIngresoVehiculo());
		Assert.assertEquals("14-02-2019 12:22:23", vehiculo.getFechaHoraSalidaVehiculo());
		Assert.assertEquals(Utilitarios.MOTO, vehiculo.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, vehiculo.getEstadoVehiculo());
		Assert.assertEquals(500, vehiculo.getCilindrajeVehiculo());
		Assert.assertEquals(5000, vehiculo.getValorServicioVehiculo());

	}
	
	@Test
	public void gettersAndSetters() {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setCilindrajeVehiculo(500);
		vehiculo.setEstadoVehiculo(Utilitarios.PARQUEADO);
		vehiculo.setFechaHoraIngresoVehiculo("12-01-2019 12:22:23");
		vehiculo.setFechaHoraSalidaVehiculo("14-02-2019 12:22:23");
		vehiculo.setPlacaVehiculo("TTT_223");
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);
		vehiculo.setValorServicioVehiculo(5000);

		Assert.assertNotNull(vehiculo);
		Assert.assertEquals("TTT_223", vehiculo.getPlacaVehiculo());
		Assert.assertEquals("12-01-2019 12:22:23", vehiculo.getFechaHoraIngresoVehiculo());
		Assert.assertEquals("14-02-2019 12:22:23", vehiculo.getFechaHoraSalidaVehiculo());
		Assert.assertEquals(Utilitarios.CARRO, vehiculo.getTipoVehiculo());
		Assert.assertEquals(Utilitarios.PARQUEADO, vehiculo.getEstadoVehiculo());
		Assert.assertEquals(500, vehiculo.getCilindrajeVehiculo());
		Assert.assertEquals(5000, vehiculo.getValorServicioVehiculo());

	}

}
