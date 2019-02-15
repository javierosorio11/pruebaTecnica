package com.estacionamiento.dominio;

/**
 * @author alvaro.osorio
 *
 */
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

	public Long getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(Long valorServicio) {
		this.valorServicio = valorServicio;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
