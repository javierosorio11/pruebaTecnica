package com.pruebaTecnica.dominio;

public class Vehiculo {
	
	private String modelo;
	private String placa;
	private String fechaHoraIngreso;
	private String fechaHoraSalida;
	private String tipoVehiculo;
	
	

	



	public Vehiculo(String modelo, String placa, String fechaHoraIngreso, String fechaHoraSalida, String tipoVehiculo) {
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
		return "Vehiculo [modelo=" + modelo + ", placa=" + placa + ", fechaHoraIngreso="
				+ fechaHoraIngreso + ", fechaHoraSalida=" + fechaHoraSalida + ", tipoVehiculo=" + tipoVehiculo + "]";
	}
	
	
	
	

}
