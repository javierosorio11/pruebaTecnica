package com.estacionamiento.persistencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.estacionamiento.dominio.Servicio;

@Entity
@Table(name = "servicio")
public class ServicioEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String modelo;
	private String placa;
	private String fechaHoraIngreso;
	private String fechaHoraSalida;
	private int tipoVehiculo;
	private int estado;
	private long cilindraje;


	public ServicioEntity(String modelo, String placa, String fechaHoraIngreso, String fechaHoraSalida,
			int tipoVehiculo, int estado, long cilindraje) {
		super();
		this.modelo = modelo;
		this.placa = placa;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.tipoVehiculo = tipoVehiculo;
		this.estado = estado;
		this.cilindraje = cilindraje;
	}

	public ServicioEntity(Servicio servicio) {
		super();
		this.modelo = servicio.getModelo();
		this.placa = servicio.getPlaca();
		this.fechaHoraIngreso = servicio.getFechaHoraIngreso();
		this.fechaHoraSalida = servicio.getFechaHoraSalida();
		this.tipoVehiculo = servicio.getTipoVehiculo();
		this.estado = servicio.getEstado();
		this.cilindraje = servicio.getCilindraje();
	}

	public ServicioEntity() {
		
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

}
