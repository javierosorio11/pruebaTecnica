package com.estacionamiento.servicio;

import java.util.List;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.exception.EstacionamientoException;

public interface IEstacionamientoService {

	public Vehiculo registrarEntrada(Vehiculo vehiculo) throws EstacionamientoException;

	public boolean verificarDisponibilidadServicio(Vehiculo vehiculo);

	public Factura registrarSalida(Vehiculo vehiculo) throws EstacionamientoException;

	public List<Vehiculo> vehiculosEstacionados() throws EstacionamientoException;

}
