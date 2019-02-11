package com.pruebaTecnica.utils;

import java.sql.Date;

import com.pruebaTecnica.dominio.Vehiculo;
import com.pruebaTecnica.persistencia.ServicioEntity;


public class VehiculoBuild {
	
	private VehiculoBuild() {}
	
public static Vehiculo convertirADominio(ServicioEntity servicioEntity) {
		
		Vehiculo vehiculo = null;
		
		if(servicioEntity != null) {
			vehiculo = new Vehiculo(servicioEntity.getModelo(),servicioEntity.getPlaca(),servicioEntity.getFechaHoraIngreso(),servicioEntity.getFechaHoraSalida(),servicioEntity.getTipoVehiculo());
		}
		
		return vehiculo;
	}
	
	public static ServicioEntity convertirAEntity(Vehiculo vehiculo) {
		
		ServicioEntity servicioEntity = new ServicioEntity();
		
		servicioEntity.setPlaca(vehiculo.getPlaca());
		servicioEntity.setModelo(vehiculo.getModelo());
		servicioEntity.setFechaHoraIngreso((Date) vehiculo.getFechaHoraIngreso());;
		servicioEntity.setFechaHoraSalida((Date)vehiculo.getFechaHoraSalida());
		servicioEntity.setTipoVehiculo(vehiculo.getTipoVehiculo());
		
		return servicioEntity;
	}
}
