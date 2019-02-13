package com.pruebaTecnica.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.pruebaTecnica.dominio.Factura;
import com.pruebaTecnica.dominio.Servicio;
import com.pruebaTecnica.persistencia.FacturaEntity;
import com.pruebaTecnica.persistencia.ServicioEntity;

public class Utilitarios {
	
 public static final String FORMATFECHAHORA="dd-MM-yyyy HH:mm:ss";
 public static final Long VALORDIACARRO=(long) 8000;
 public static final Long VALORHORACARRO=(long) 1000;
 public static final Long VALORDIAMOTO=(long) 4000;
 public static final Long VALORDHORAMOTO=(long) 500;
 public static final int CARRO=1;
 public static final int MOTO=0;
 public static final int PARQUEADO=1;
 public static final int NOPAQUEADO=0;
 public static final String SINCUPO="No hay cupo disponible";
 public static final String PLACA_INI_EN_A="Hoy no tiene permitido Ingresar";
 public static final int CUPOMAXCARROS = 20;
 public static final int CUPOMAXMOTOS = 10;
 

 public static Date formatFechaActual() throws ParseException {

  SimpleDateFormat sdf = new SimpleDateFormat(FORMATFECHAHORA);
  Date now= new Date();

  String dateAsString = sdf.format(now);
  Date dateFromString = sdf.parse(dateAsString);
  return dateFromString;

 }

 public static String fechaActualAString() throws ParseException {

	  SimpleDateFormat sdf = new SimpleDateFormat(FORMATFECHAHORA);
	  Date ahora = new Date();
	  String fechaString = sdf.format(ahora);
	 
	  return fechaString;

	 }
 
 public static Date fechaStringADate (String fecha) throws ParseException  {

	  SimpleDateFormat sdf = new SimpleDateFormat(FORMATFECHAHORA);
	  Date dateFromString = sdf.parse(fecha);
	  return dateFromString;

	 }
 public static boolean esDomingoOLunes(Calendar fechaActual) {

  boolean esDomingoOLunes = false;
  esDomingoOLunes = (fechaActual.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
  fechaActual.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY);

  return esDomingoOLunes;
 }

 public static boolean placaVehiculoIniciaPorA(String placaVehiculo) {

  return placaVehiculo.toUpperCase().indexOf('A') == 0;
 }
 
public static Servicio convertirAServicio(ServicioEntity servicioEntity) {
		Servicio servicio = null;
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
		factura.setTipoVehiculo(factura.getTipoVehiculo());
		factura.setValorServicio(facturaEntity.getValorServicio());
	}
	return factura;
}




}