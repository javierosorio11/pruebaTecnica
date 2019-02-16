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
	private String placaVehiculo;
	private String fechaHoraIngresoVehiculo;
	private String fechaHoraSalidaVehiculo;
	private int tipoVehiculo;
	private int estadoVehiculo;
	private long cilindrajeVehiculo;
	private long valorServicioVehiculo;

	public VehiculoEntity(String placaVehiculo, String fechaHoraIngresoVehiculo, String fechaHoraSalidaVehiculo,
			int tipoVehiculo, int estadoVehiculo, long cilindrajeVehiculo, long valorServicioVehiculo) {
		super();
		this.placaVehiculo = placaVehiculo;
		this.fechaHoraIngresoVehiculo = fechaHoraIngresoVehiculo;
		this.fechaHoraSalidaVehiculo = fechaHoraSalidaVehiculo;
		this.tipoVehiculo = tipoVehiculo;
		this.estadoVehiculo = estadoVehiculo;
		this.cilindrajeVehiculo = cilindrajeVehiculo;
		this.valorServicioVehiculo = valorServicioVehiculo;
	}

	public VehiculoEntity() {

	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placa) {
		this.placaVehiculo = placa;
	}

	public String getFechaHoraIngresoVehiculo() {
		return fechaHoraIngresoVehiculo;
	}

	public void setFechaHoraIngresoVehiculo(String fechaHoraIngreso) {
		this.fechaHoraIngresoVehiculo = fechaHoraIngreso;
	}

	public String getFechaHoraSalidaVehiculo() {
		return fechaHoraSalidaVehiculo;
	}

	public void setFechaHoraSalidaVehiculo(String fechaHoraSalida) {
		this.fechaHoraSalidaVehiculo = fechaHoraSalida;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getEstadoVehiculo() {
		return estadoVehiculo;
	}

	public void setEstadoVehiculo(int estado) {
		this.estadoVehiculo = estado;
	}

	public long getCilindrajeVehiculo() {
		return cilindrajeVehiculo;
	}

	public void setCilindrajeVehiculo(long cilindraje) {
		this.cilindrajeVehiculo = cilindraje;
	}

	public long getValorServicioVehiculo() {
		return valorServicioVehiculo;
	}

	public void setValorServicioVehiculo(long valorServico) {
		this.valorServicioVehiculo = valorServico;
	}

	public long getId() {
		return id;
	}

}
