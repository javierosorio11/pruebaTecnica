/**
 * 
 */
package com.pruebaTecnica.servicio;


import com.pruebaTecnica.dominio.Factura;
import com.pruebaTecnica.persistencia.FacturaEntity;
import com.pruebaTecnica.persistencia.ServicioEntity;


/**
 * @author alvaro.osorio
 *
 */
public interface IEstacionamientoService {

	public Factura registrarEntrada(ServicioEntity servicio);
	
	public boolean  verificarDisponibilidadServicio(ServicioEntity servicio);
	
	public FacturaEntity registrarSalida(String placa);
	
	 
}
