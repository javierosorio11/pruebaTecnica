package com.estacionamiento.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estacionamiento.persistencia.VehiculoEntity;

@Repository
public interface IRepositorioVehiculo extends JpaRepository<VehiculoEntity, Long> {

	public List<VehiculoEntity> findAllByTipoVehiculo(int tipoVehiculo);

	@Query("SELECT s FROM VehiculoEntity s WHERE s.tipoVehiculo=?1 and s.estado=?2")
	public List<VehiculoEntity> findByTipoVehiculoByEstado(int tipoVehiculo, int estado);

	@Query("SELECT s FROM VehiculoEntity s WHERE s.placa=?1 and s.estado=?2")
	public VehiculoEntity findByPlacaByEstado(String placa, int estado);

	@Modifying
	@Query("UPDATE VehiculoEntity s set s.estado = ?1, s.fechaHoraSalida = ?3 WHERE s.estado=1 and s.placa=?2")
	public void updateEstadoFechaHoraSalida(int estado, String placa, String fechaHoraSalida);

	@Query("SELECT s FROM VehiculoEntity s WHERE s.estado=0")
	public List<VehiculoEntity> findByEstado();

}
