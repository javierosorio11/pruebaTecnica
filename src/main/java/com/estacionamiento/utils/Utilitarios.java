package com.estacionamiento.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	public static final String PLACA_INI_EN_A = "Hoy no tiene permitido ingresar";
	public static final String SERVICIONULL = "No se encontraro servicios";
	public static final long CUPOMAXCARROS = 20;
	public static final long CUPOMAXMOTOS = 10;
	public static final Double HORAENMLS = 3.6e+6;
	public static final long RECARGOMOTOCC = 2000;
	public static final String FACTURANOEXISTE = "No existe la factura solicitada";
	public static final String ERROR_REGISTRA_SALIDA = "Se presento un error registrando salida";
	public static final String NO_EXISTEN_VEHICULOS = "No hay vehiculos en el estacionamiento";
	public static final String VEHICULO_EXITE = "Este vehiculo ya se encuentra registrado";

	Utilitarios() {
		throw new IllegalStateException("No instanciable");
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

}