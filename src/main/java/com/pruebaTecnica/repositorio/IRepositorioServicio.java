package com.pruebaTecnica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pruebaTecnica.persistencia.ServicioEntity;




public interface IRepositorioServicio extends JpaRepository<ServicioEntity, Long>{

	public ServicioEntity findByPlaca(String placa);
	
	public List<ServicioEntity> findAllByTipoVehiculo(int tipoVehiculo);
	
	
}
