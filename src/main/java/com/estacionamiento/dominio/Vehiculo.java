package com.estacionamiento.dominio;

public class Vehiculo {

	private String placaVehiculo;
	private String fechaHoraIngresoVehiculo;
	private String fechaHoraSalidaVehiculo;
	private int tipoVehiculo;
	private int estadoVehiculo;
	private long cilindrajeVehiculo;
	private long valorServicioVehiculo;

	public Vehiculo(String placaVehiculo, String fechaHoraIngresoVehiculo, String fechaHoraSalidaVehiculo,
			int tipoVehiculoVehiculo, int estadoVehiculo, long cilindrajeVehiculo, long valorServicioVehiculo) {
		super();
		this.placaVehiculo = placaVehiculo;
		this.fechaHoraIngresoVehiculo = fechaHoraIngresoVehiculo;
		this.fechaHoraSalidaVehiculo = fechaHoraSalidaVehiculo;
		this.tipoVehiculo = tipoVehiculoVehiculo;
		this.estadoVehiculo = estadoVehiculo;
		this.cilindrajeVehiculo = cilindrajeVehiculo;
		this.valorServicioVehiculo = valorServicioVehiculo;
	}

	public Vehiculo() {
		super();
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

	public void setValorServicioVehiculo(long valorServicio) {
		this.valorServicioVehiculo = valorServicio;
	}

}
