package com.pruebaTecnica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaTecnica.persistencia.FacturaEntity;
import com.pruebaTecnica.persistencia.ServicioEntity;

public interface IRepositorioFactura extends JpaRepository<FacturaEntity, Long>{

	public ServicioEntity findByPlaca(String placa);
	
	

}
