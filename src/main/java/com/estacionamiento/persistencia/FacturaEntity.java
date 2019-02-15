package com.estacionamiento.persistencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.estacionamiento.dominio.Servicio;

@Entity
@Table(name = "factura")
public class FacturaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String placa;
	private String fechaHoraIngreso;
	private String fechaHoraSalida;
	private long valorServicio;
	private int tipoVehiculo;
	private int estado;
	private long cilindraje;

	public FacturaEntity() {

	}

	public FacturaEntity(long id, String placa, String fechaHoraIngreso, String fechaHoraSalida, Long valorServicio,
			int tipoVehiculo, int estado, Long cilindraje) {
		super();
		this.id = id;
		this.placa = placa;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.valorServicio = valorServicio;
		this.tipoVehiculo = tipoVehiculo;
		this.estado = estado;
		this.cilindraje = cilindraje;
	}

	public FacturaEntity(Servicio servicio) {
		super();
		this.placa = servicio.getPlaca();
		this.fechaHoraIngreso = servicio.getFechaHoraIngreso();
		this.fechaHoraSalida = servicio.getFechaHoraSalida();
		this.valorServicio = 0;
		this.tipoVehiculo = servicio.getTipoVehiculo();
		this.estado = servicio.getEstado();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(long valorServicio) {
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

	public long getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(long cilindraje) {
		this.cilindraje = cilindraje;
	}

}
