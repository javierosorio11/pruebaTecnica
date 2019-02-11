
package com.pruebaTecnica.dominio;

import java.sql.Date;

/**
 * @author alvaro.osorio
 *
 */
public class Servicio {

	private Long tarifaCarro;
	private Long tarifaMoto;
	private Long cobroAdicional;
	private Date FechaHoraingreso;
	private Date FechaHorasalida;
	

	public Servicio(Long tarifaCarro, Long tarifaMoto, Long cobroAdicional, Date fechaHoraingreso,
			Date fechaHorasalida) {
		super();
		this.tarifaCarro = tarifaCarro;
		this.tarifaMoto = tarifaMoto;
		this.cobroAdicional = cobroAdicional;
		this.FechaHoraingreso = fechaHoraingreso;
		this.FechaHorasalida = fechaHorasalida;
	}


	public Long getTarifaCarro() {
		return tarifaCarro;
	}


	public void setTarifaCarro(Long tarifaCarro) {
		this.tarifaCarro = tarifaCarro;
	}


	public Long getTarifaMoto() {
		return tarifaMoto;
	}


	public void setTarifaMoto(Long tarifaMoto) {
		this.tarifaMoto = tarifaMoto;
	}


	public Long getCobroAdicional() {
		return cobroAdicional;
	}


	public void setCobroAdicional(Long cobroAdicional) {
		this.cobroAdicional = cobroAdicional;
	}


	public Date getFechaHoraingreso() {
		return FechaHoraingreso;
	}


	public void setFechaHoraingreso(Date fechaHoraingreso) {
		FechaHoraingreso = fechaHoraingreso;
	}


	public Date getFechaHorasalida() {
		return FechaHorasalida;
	}


	public void setFechaHorasalida(Date fechaHorasalida) {
		FechaHorasalida = fechaHorasalida;
	}



}
