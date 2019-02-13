package com.estacionamiento.repositorio;

import com.estacionamiento.dominio.Vehiculo;

public interface RepositorioVehiculo {

	/**
	 * Permite optener un vehiculo por placa
	 * @param placa
	 * @return
	 */
	Vehiculo obtenerVehiculoPorPlaca(String placa);

	/**
	 * Permite registrar vehiculo en paqueadero
	 * @param producto
	 */
	void RegistraEntrada(Vehiculo vehiculo);

	

	
	
}
