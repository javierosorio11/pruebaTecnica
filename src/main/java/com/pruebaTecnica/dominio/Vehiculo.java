package com.pruebaTecnica.dominio;

import java.util.Date;

public class Vehiculo {
	
	private String modelo;
	private String placa;
	private Date fechaHoraIngreso;
	private Date fechaHoraSalida;
	private int tipoVehiculo;
	

	public Vehiculo(String modelo, String placa, Date fechaHoraIngreso, Date fechaHoraSalida, int tipoVehiculo) {
		super();
		this.modelo = modelo;
		this.placa = placa;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.tipoVehiculo = tipoVehiculo;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public Date getFechaHoraIngreso() {
		return fechaHoraIngreso;
	}


	public void setFechaHoraIngreso(Date fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}


	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}


	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}


	public int getTipoVehiculo() {
		return tipoVehiculo;
	}


	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}



	

}
