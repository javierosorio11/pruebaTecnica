package com.estacionamiento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estacionamiento.persistencia.FacturaEntity;

@Repository
public interface IRepositorioFactura extends JpaRepository<FacturaEntity, Long> {

	@Query("SELECT f FROM FacturaEntity f WHERE f.placa=?1 and f.estado=?2")
	public FacturaEntity findByPlacaByEstado(String placa, int estado);

	@Modifying
	@Query("UPDATE FacturaEntity f set f.estado = ?1, f.fechaHoraSalida = ?3 WHERE f.estado=1 and f.placa=?2")
	public void updateEstadoFechaHoraSalida(int estado, String placa, String fechaHoraSalida);
}
