package com.estacionamiento.repositorio;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.dominio.Recibo;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.persistencia.VehiculoEntity;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IRepositorioVehiculoTest {

	@Autowired
	IRepositorioVehiculo iRepositorioVehiculo;
	
	@Test
	public void findByTipoVehiculoByEstadoTest() throws EstacionamientoException, ParseException {

		VehiculoEntity vehiculo = new VehiculoEntity();
		vehiculo.setEstado(Utilitarios.PARQUEADO);
		vehiculo.setPlaca("TMQ");
		vehiculo.setTipoVehiculo(Utilitarios.CARRO);
		iRepositorioVehiculo.save(vehiculo);

		List<VehiculoEntity> vehiculosEntity = iRepositorioVehiculo.findByTipoVehiculoByEstado(Utilitarios.CARRO,Utilitarios.PARQUEADO);

		Assert.assertEquals(1, vehiculosEntity.size());

	}

}
