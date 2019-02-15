package com.estacionamiento.servicio;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Recibo;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.exception.EstacionamientoException;

public interface IEstacionamientoService {

	public Recibo registrarEntrada(Vehiculo vehiculo) throws EstacionamientoException;

	public boolean verificarDisponibilidadServicio(Vehiculo vehiculo);

	public Factura registrarSalida(Recibo recibo) throws EstacionamientoException;

}
