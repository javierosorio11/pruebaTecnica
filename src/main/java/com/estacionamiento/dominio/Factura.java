package com.estacionamiento.dominio;

public class Factura {

	private String placa;
	private String fechaHoraIngreso;
	private String fechaHoraSalida;
	private Long valorServicio;
	private int tipoVehiculo;
	private int estado;
	private String error;

	public Factura(String placa, String fechaHoraIngreso, String fechaHoraSalida, Long valorServicio, int tipoVehiculo,
			int estado, String error) {
		super();
		this.placa = placa;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.valorServicio = valorServicio;
		this.tipoVehiculo = tipoVehiculo;
		this.estado = estado;
		this.error = error;
	}

	public Factura() {
		super();
	}

	public String getPlacaFactura() {
		return placa;
	}

	public void setPlacaFactura(String placa) {
		this.placa = placa;
	}

	public String getFechaHoraIngresoFactura() {
		return fechaHoraIngreso;
	}

	public void setFechaHoraIngresoFactura(String fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}

	public String getFechaHoraSalidaFactura() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalidaFactura(String fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public Long getValorServicioFactura() {
		return valorServicio;
	}

	public void setValorServicioFactura(Long valorServicio) {
		this.valorServicio = valorServicio;
	}

	public int getTipoVehiculoFactura() {
		return tipoVehiculo;
	}

	public void setTipoVehiculoFactura(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getEstadoFactura() {
		return estado;
	}

	public void setEstadoFactura(int estado) {
		this.estado = estado;
	}

	public String getErrorFactura() {
		return error;
	}

	public void setErrorFactura(String error) {
		this.error = error;
	}

}
