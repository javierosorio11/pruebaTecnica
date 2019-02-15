/**
 * 
 */
package com.estacionamiento.servicio;

import java.text.ParseException;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;
import com.estacionamiento.exception.EstacionamientoException;

/**
 * @author alvaro.osorio
 *
 */
public interface IEstacionamientoService {

	public Factura registrarEntrada(Servicio servicio) throws EstacionamientoException, ParseException;

	public boolean verificarDisponibilidadServicio(Servicio servicio) throws EstacionamientoException;

	public Factura registrarSalida(Factura factura) throws EstacionamientoException;

}
