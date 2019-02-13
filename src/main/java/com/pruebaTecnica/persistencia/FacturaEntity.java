package com.pruebaTecnica.persistencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Long valorServicio;
	private int tipoVehiculo;
	private int estado;

	public FacturaEntity() {

	}

	public FacturaEntity(String placa, String fechaHoraIngreso, String fechaHoraSalida, Long valorServicio,
			int tipoVehiculo, int estado) {
		super();
		this.placa = placa;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.valorServicio = valorServicio;
		this.tipoVehiculo = tipoVehiculo;
		this.estado = estado;
	}
	
	public FacturaEntity(ServicioEntity servicio) {
		super();
		this.placa = servicio.getPlaca();
		this.fechaHoraIngreso = servicio.getFechaHoraIngreso();
		this.fechaHoraSalida = servicio.getFechaHoraSalida();
		this.valorServicio = (long) 0;
		this.tipoVehiculo = servicio.getTipoVehiculo();
		this.estado = 1;
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



}
