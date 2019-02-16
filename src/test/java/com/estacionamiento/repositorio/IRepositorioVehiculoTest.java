package com.estacionamiento.repositorio;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.persistencia.VehiculoEntity;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IRepositorioVehiculoTest {

	@Autowired
	IRepositorioVehiculo iRepositorioVehiculo;

	@Before
	public void dataInicial() {
		VehiculoEntity vehiculo = new VehiculoEntity();
		vehiculo.setEstadoVehiculoEntity(Utilitarios.PARQUEADO);
		vehiculo.setPlacaVehiculoEntity("TMQ");
		vehiculo.setTipoVehiculoEntity(Utilitarios.CARRO);
		iRepositorioVehiculo.save(vehiculo);
	}

	@After
	public void Limpiardata() {
		iRepositorioVehiculo.deleteAll();
	}

	@Test
	public void findByTipoVehiculoByEstadoTest() {

		List<VehiculoEntity> vehiculosEntity = iRepositorioVehiculo.findByTipoVehiculoByEstado(Utilitarios.CARRO,
				Utilitarios.PARQUEADO);

		Assert.assertEquals(1, vehiculosEntity.size());

	}

	@Test
	public void findByPlacaByEstadoTest() {

		VehiculoEntity vehiculoEntity = iRepositorioVehiculo.findByPlacaByEstado("TMQ", Utilitarios.PARQUEADO);

		Assert.assertEquals(Utilitarios.PARQUEADO, vehiculoEntity.getEstadoVehiculoEntity());
		Assert.assertEquals(Utilitarios.CARRO, vehiculoEntity.getTipoVehiculoEntity());
		Assert.assertEquals("TMQ", vehiculoEntity.getPlacaVehiculoEntity());

	}

}
