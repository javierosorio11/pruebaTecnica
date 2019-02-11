package com.pruebaTecnica.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "vehiculos")


public class VehiculoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "color")
	private String color;

	@Column(name = "placa")
	private String placa;

	@Column(name = "fechaHoraIngreso")
	private String fechaHoraIngreso;

	@Column(name = "fechaHoraSalida")
	private String fechaHoraSalida;

	@Column(name = "tipoVehiculo")
	private String tipoVehiculo;

	public VehiculoEntity() {
		//Constructor vacio
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFechaHoraIngreso() {
		return fechaHoraIngreso;
	}

	public void setFechaHoraIngreso(String fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}

	public String getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(String fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public String toString() {
		return "VehiculoEntity [id=" + id + ", modelo=" + modelo + ", color=" + color + ", placa=" + placa
				+ ", fechaHoraIngreso=" + fechaHoraIngreso + ", fechaHoraSalida=" + fechaHoraSalida + ", tipoVehiculo="
				+ tipoVehiculo + "]";
	}

}
