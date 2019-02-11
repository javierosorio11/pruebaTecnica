package com.pruebaTecnica.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.pruebaTecnica.dominio.Vehiculo;
import com.pruebaTecnica.repositorio.RepositorioVehiculo;
import com.pruebaTecnica.utils.VehiculoBuild;



public class RepositorioVehiculoPersistente implements RepositorioVehiculo {

	private static final String PLACA = "placa";
	private static final String PRODUCTO_FIND_BY_CODIGO = "vehiculo.findByCodigo";
	
	private EntityManager entityManager;

	public RepositorioVehiculoPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public Vehiculo obtenerVehiculoPorPlaca(String placa) {

		Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_CODIGO);
		query.setParameter(PLACA, placa);
		VehiculoEntity vehiculoEntity =(VehiculoEntity) query.getSingleResult();
		return VehiculoBuild.convertirADominio(vehiculoEntity);
	}

	@Override
	public void RegistraEntrada(Vehiculo vehiculo) {
		entityManager.persist(VehiculoBuild.convertirAEntity(vehiculo));
		
	}	

	

}
