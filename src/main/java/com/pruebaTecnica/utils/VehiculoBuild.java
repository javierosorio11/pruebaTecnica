package com.pruebaTecnica.utils;

import com.pruebaTecnica.dominio.Vehiculo;
import com.pruebaTecnica.persistencia.VehiculoEntity;


public class VehiculoBuild {
	
	private VehiculoBuild() {}
	
public static Vehiculo convertirADominio(VehiculoEntity VehiculoEntity) {
		
		Vehiculo vehiculo = null;
		
		if(VehiculoEntity != null) {
			vehiculo = new Vehiculo(VehiculoEntity.getModelo(), VehiculoEntity.getPlaca(), VehiculoEntity.getFechaHoraIngreso(), VehiculoEntity.getFechaHoraSalida(), VehiculoEntity.getTipoVehiculo());
		}
		
		return vehiculo;
	}
	
	public static VehiculoEntity convertirAEntity(Vehiculo Vehiculo) {
		
		VehiculoEntity VehiculoEntity = new VehiculoEntity();
		
		VehiculoEntity.setPlaca(Vehiculo.getPlaca());
		VehiculoEntity.setModelo(Vehiculo.getModelo());
		VehiculoEntity.setFechaHoraIngreso(Vehiculo.getFechaHoraIngreso());
		VehiculoEntity.setFechaHoraSalida(Vehiculo.getFechaHoraSalida());
		VehiculoEntity.setTipoVehiculo(Vehiculo.getTipoVehiculo());
		
		return VehiculoEntity;
	}
}
