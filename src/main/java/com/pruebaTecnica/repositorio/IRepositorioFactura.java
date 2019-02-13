package com.pruebaTecnica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pruebaTecnica.persistencia.FacturaEntity;
import com.pruebaTecnica.persistencia.ServicioEntity;

public interface IRepositorioFactura extends JpaRepository<FacturaEntity, Long>{

	public ServicioEntity findByPlaca(String placa);
	
	

}
