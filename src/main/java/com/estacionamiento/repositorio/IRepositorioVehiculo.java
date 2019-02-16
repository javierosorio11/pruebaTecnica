package com.estacionamiento.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estacionamiento.persistencia.VehiculoEntity;

@Repository
public interface IRepositorioVehiculo extends JpaRepository<VehiculoEntity, Long> {

	@Query("SELECT s FROM VehiculoEntity s WHERE s.tipoVehiculo=?1 and s.estado=?2")
	public List<VehiculoEntity> findByTipoVehiculoByEstado(int tipoVehiculo, int estado);

	@Query("SELECT s FROM VehiculoEntity s WHERE s.placa=?1 and s.estado=?2")
	public VehiculoEntity findByPlacaByEstado(String placa, int estado);

}
