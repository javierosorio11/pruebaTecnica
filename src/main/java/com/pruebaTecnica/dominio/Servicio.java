
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
	private Date FechaHoraIngreso;
	private Date FechaHoraSalida;
	

	public Servicio(Long tarifaCarro, Long tarifaMoto, Long cobroAdicional, Date fechaHoraIngreso,
			Date fechaHoraSalida) {
		super();
		this.tarifaCarro = tarifaCarro;
		this.tarifaMoto = tarifaMoto;
		this.cobroAdicional = cobroAdicional;
		FechaHoraIngreso = fechaHoraIngreso;
		FechaHoraSalida = fechaHoraSalida;
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

	public Date getFechaHoraIngreso() {
		return FechaHoraIngreso;
	}

	public void setFechaHoraIngreso(Date fechaHoraIngreso) {
		FechaHoraIngreso = fechaHoraIngreso;
	}

	public Date getFechaHoraSalida() {
		return FechaHoraSalida;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		FechaHoraSalida = fechaHoraSalida;
	}

}
