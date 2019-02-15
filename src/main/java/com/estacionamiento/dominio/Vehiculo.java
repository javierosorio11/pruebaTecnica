
package com.estacionamiento.dominio;

/**
 * @author alvaro.osorio
 *
 */
public class Vehiculo {

	private String modelo;
	private String placa;
	private String fechaHoraIngreso;
	private String fechaHoraSalida;
	private int tipoVehiculo;
	private int estado;
	private long cilindraje;
	private long valorServicio;

	public Vehiculo(String modelo, String placa, String fechaHoraIngreso, String fechaHoraSalida, int tipoVehiculo,
			int estado, long cilindraje, long varorServicio) {
		super();
		this.modelo = modelo;
		this.placa = placa;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.tipoVehiculo = tipoVehiculo;
		this.estado = estado;
		this.cilindraje = cilindraje;
		this.valorServicio = varorServicio;
	}

	public Vehiculo() {

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

	public long getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(long cilindraje) {
		this.cilindraje = cilindraje;
	}

	public long getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(long valorServicio) {
		this.valorServicio = valorServicio;
	}

}
