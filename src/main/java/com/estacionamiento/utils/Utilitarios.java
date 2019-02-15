package com.estacionamiento.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.persistencia.FacturaEntity;
import com.estacionamiento.persistencia.ServicioEntity;

public final class Utilitarios {

	public static final String FORMATFECHAHORA = "dd-MM-yyyy HH:mm:ss";
	public static final long VALORDIACARRO = 8000;
	public static final long VALORHORACARRO = 1000;
	public static final long VALORDIAMOTO = 4000;
	public static final long VALORDHORAMOTO = 500;
	public static final int CARRO = 1;
	public static final int MOTO = 0;
	public static final int PARQUEADO = 1;
	public static final int NOPAQUEADO = 0;
	public static final String SINCUPO = "No hay cupo disponible";
	public static final String PLACA_INI_EN_A = "Hoy no tiene permitido Ingresar";
	public static final String SERVICIONULL = "No se encontraro servicios";
	public static final long CUPOMAXCARROS = 20;
	public static final long CUPOMAXMOTOS = 10;
	public static final Double HORAENMLS = 3.6e+6;
	public static final long RECARGOMOTOCC = 2000;
	public static final String FACTURANOEXISTE = "No existe la factura solicitada";

	private Utilitarios() {
		throw new IllegalStateException("Utilitarios class");
	}

	public static String fechaActualAString() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat(FORMATFECHAHORA);
		Date ahora = new Date();
		return sdf.format(ahora);

	}

	public static Date fechaStringADate(String fecha) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat(FORMATFECHAHORA);
		return sdf.parse(fecha);

	}

	public static boolean esDomingoOLunes(Calendar fechaActual) {

		boolean esDomingoOLunes = false;
		esDomingoOLunes = (fechaActual.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| fechaActual.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY);

		return esDomingoOLunes;
	}

	public static boolean placaVehiculoIniciaPorA(String placaVehiculo) {

		return placaVehiculo.toUpperCase().indexOf('A') == 0;
	}

	public static Servicio convertirAServicio(ServicioEntity servicioEntity) {
		Servicio servicio = new Servicio();
		if (servicioEntity != null) {

			servicio.setEstado(servicioEntity.getEstado());
			servicio.setFechaHoraIngreso(servicioEntity.getFechaHoraIngreso());
			servicio.setFechaHoraSalida(servicioEntity.getFechaHoraSalida());
			servicio.setModelo(servicio.getModelo());
			servicio.setPlaca(servicioEntity.getPlaca());
			servicio.setTipoVehiculo(servicioEntity.getTipoVehiculo());
		}
		return servicio;
	}

	public static Factura convertirAFactura(FacturaEntity facturaEntity) {
		Factura factura = new Factura();
		if (facturaEntity != null) {

			factura.setEstado(facturaEntity.getEstado());
			factura.setFechaHoraIngreso(facturaEntity.getFechaHoraIngreso());
			factura.setFechaHoraSalida(facturaEntity.getFechaHoraSalida());
			factura.setPlaca(facturaEntity.getPlaca());
			factura.setTipoVehiculo(facturaEntity.getTipoVehiculo());
			factura.setValorServicio(facturaEntity.getValorServicio());
		}
		return factura;
	}

	public static ServicioEntity convertiServicioAServicioEntity(Servicio servicio) throws EstacionamientoException {

		ServicioEntity servicioEntity = null;

		if (servicio != null) {

			servicioEntity = new ServicioEntity(servicio.getModelo(), servicio.getPlaca(),
					servicio.getFechaHoraIngreso(), servicio.getFechaHoraSalida(), servicio.getTipoVehiculo(),
					servicio.getEstado(), servicio.getCilindraje());

		} else {

			throw new EstacionamientoException(SERVICIONULL);
		}

		return servicioEntity;
	}

	public static FacturaEntity convertiServicioAFacturaEntity(Servicio servicio) throws EstacionamientoException {

		FacturaEntity facturaEntity = null;

		if (servicio != null) {

			facturaEntity = new FacturaEntity(servicio.getPlaca(), servicio.getFechaHoraIngreso(),
					servicio.getFechaHoraSalida(), 0, servicio.getTipoVehiculo(), servicio.getEstado(),
					servicio.getCilindraje());

		} else {

			throw new EstacionamientoException(SERVICIONULL);
		}

		return facturaEntity;
	}

}