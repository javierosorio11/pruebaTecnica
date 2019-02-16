package com.estacionamiento.dominio;

public class Recibo {

	private String placa;
	private String fechaHoraIngreso;
	private String fechaHoraSalida;
	private int tipoVehiculo;
	private String error;

	public Recibo(String placa, String fechaHoraIngreso, String fechaHoraSalida, int tipoVehiculo, String error) {
		super();
		this.placa = placa;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.tipoVehiculo = tipoVehiculo;
		this.error = error;
	}

	public Recibo() {
		super();
	}

	public String getPlacaRecibo() {
		return placa;
	}

	public void setPlacaRecibo(String placa) {
		this.placa = placa;
	}

	public String getFechaHoraIngresoRecibo() {
		return fechaHoraIngreso;
	}

	public void setFechaHoraIngresoRecibo(String fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}

	public String getFechaHoraSalidaRecibo() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalidaRecibo(String fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public int getTipoVehiculoRecibo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculoRecibo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getErrorRecibo() {
		return error;
	}

	public void setErrorRecibo(String error) {
		this.error = error;
	}

}
