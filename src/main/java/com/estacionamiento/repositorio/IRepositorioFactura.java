package com.estacionamiento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estacionamiento.persistencia.FacturaEntity;
import com.estacionamiento.persistencia.ServicioEntity;

public interface IRepositorioFactura extends JpaRepository<FacturaEntity, Long>{

	public ServicioEntity findByPlaca(String placa);
	
	

}
