package com.estacionamiento.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estacionamiento.persistencia.ServicioEntity;



@Repository
public interface IRepositorioServicio extends JpaRepository<ServicioEntity, Long>{

	public ServicioEntity findByPlaca(String placa);
	
	public List<ServicioEntity> findAllByTipoVehiculo(int tipoVehiculo);
	
	@Query("SELECT s FROM ServicioEntity s WHERE s.tipoVehiculo=?1 and s.estado=?2")
	public List<ServicioEntity> findByTipoVehiculoByEstado (int tipoVehiculo,int estado);
	
	
	@Query("SELECT s FROM ServicioEntity s WHERE s.placa=?1 and s.estado=?2")
	public ServicioEntity findByPlacaByEstado (String placa,int estado);
	
	@Modifying
	@Query("UPDATE ServicioEntity s  set s.estado=?1 WHERE s.estado=1 and s.placa=?2")
	public void updateEstado (int estado,String placa);
	
}
