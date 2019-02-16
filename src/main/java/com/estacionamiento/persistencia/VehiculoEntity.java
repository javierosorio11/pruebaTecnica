package com.estacionamiento.persistencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class VehiculoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String placaVehiculoEntity;
	private String fechaHoraIngresoVEntity;
	private String fechaHoraSalidaVEntity;
	private int tipoVehiculoEntity;
	private int estadoVehiculoEntity;
	private long cilindrajeVehiculoEntity;
	private long valorServicoVehiculoEntity;

	public VehiculoEntity(String placaVehiculoEntity, String fechaHoraIngresoVEntity, String fechaHoraSalidaVEntity,
			int tipoVehiculoEntity, int estadoVehiculoEntity, long cilindrajeVehiculoEntity,
			long valorServicoVehiculoEntity) {
		super();
		this.placaVehiculoEntity = placaVehiculoEntity;
		this.fechaHoraIngresoVEntity = fechaHoraIngresoVEntity;
		this.fechaHoraSalidaVEntity = fechaHoraSalidaVEntity;
		this.tipoVehiculoEntity = tipoVehiculoEntity;
		this.estadoVehiculoEntity = estadoVehiculoEntity;
		this.cilindrajeVehiculoEntity = cilindrajeVehiculoEntity;
		this.valorServicoVehiculoEntity = valorServicoVehiculoEntity;
	}

	public VehiculoEntity() {

	}

	public String getPlacaVehiculoEntity() {
		return placaVehiculoEntity;
	}

	public void setPlacaVehiculoEntity(String placa) {
		this.placaVehiculoEntity = placa;
	}

	public String getFechaHoraIngresoVEntity() {
		return fechaHoraIngresoVEntity;
	}

	public void setFechaHoraIngresoVEntity(String fechaHoraIngreso) {
		this.fechaHoraIngresoVEntity = fechaHoraIngreso;
	}

	public String getFechaHoraSalidaVEntity() {
		return fechaHoraSalidaVEntity;
	}

	public void setFechaHoraSalidaVEntity(String fechaHoraSalida) {
		this.fechaHoraSalidaVEntity = fechaHoraSalida;
	}

	public int getTipoVehiculoEntity() {
		return tipoVehiculoEntity;
	}

	public void setTipoVehiculoEntity(int tipoVehiculo) {
		this.tipoVehiculoEntity = tipoVehiculo;
	}

	public int getEstadoVehiculoEntity() {
		return estadoVehiculoEntity;
	}

	public void setEstadoVehiculoEntity(int estado) {
		this.estadoVehiculoEntity = estado;
	}

	public long getCilindrajeVehiculoEntity() {
		return cilindrajeVehiculoEntity;
	}

	public void setCilindrajeVehiculoEntity(long cilindraje) {
		this.cilindrajeVehiculoEntity = cilindraje;
	}

	public long getValorServicoVehiculoEntity() {
		return valorServicoVehiculoEntity;
	}

	public void setValorServicoVehiculoEntity(long valorServico) {
		this.valorServicoVehiculoEntity = valorServico;
	}

	public long getId() {
		return id;
	}

}
