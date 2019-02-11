package com.pruebaTecnica.persistencia;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



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
	private Date fechaHoraIngreso;
	private Date fechaHoraSalida;
	private int tipoVehiculo;

	public ServicioEntity() {

	}


	public ServicioEntity(String modelo, String placa, Date fechaHoraIngreso, Date fechaHoraSalida,
			int tipoVehiculo) {
		super();
		this.modelo = modelo;
		this.placa = placa;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.tipoVehiculo = tipoVehiculo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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
