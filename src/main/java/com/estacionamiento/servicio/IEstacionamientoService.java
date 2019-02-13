/**
 * 
 */
package com.estacionamiento.servicio;


import com.estacionamiento.dominio.Factura;
import com.estacionamiento.persistencia.FacturaEntity;
import com.estacionamiento.persistencia.ServicioEntity;


/**
 * @author alvaro.osorio
 *
 */
public interface IEstacionamientoService {

	public Factura registrarEntrada(ServicioEntity servicio);
	
	public boolean  verificarDisponibilidadServicio(ServicioEntity servicio);
	
	public FacturaEntity registrarSalida(String placa);
	
	 
}
