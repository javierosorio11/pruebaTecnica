/**
 * 
 */
package com.estacionamiento.servicio;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;

/**
 * @author alvaro.osorio
 *
 */
public interface IEstacionamientoService {

	public Factura registrarEntrada(Servicio servicio);

	public boolean verificarDisponibilidadServicio(Servicio servicio);

	public Factura registrarSalida(Factura factura);

}
