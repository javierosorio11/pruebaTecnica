package com.estacionamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.servicio.IEstacionamientoService;

@RestController
public class EstacionamientoController {

	@Autowired
	IEstacionamientoService iEstacionamiento;

	@CrossOrigin
	@GetMapping("/")
	public String index() {
		return "<div style=\"text-align : center\">Bienvenidos al Parqueadero <h1>CEIBA-PARKING</div>";
	}

	@CrossOrigin
	@PostMapping("/disponibilidad")
	public boolean verificarDisponibilidadServicio(@RequestBody Servicio servicio) throws EstacionamientoException {
		return this.iEstacionamiento.verificarDisponibilidadServicio(servicio);
	}

	@CrossOrigin
	@PostMapping("/registrarEntrada")
	public Factura registrarEntradaVehiculo(@RequestBody Servicio servicio) throws EstacionamientoException {
		return this.iEstacionamiento.registrarEntrada(servicio);
	}


	@CrossOrigin
	@PostMapping("/registrarSalida")
	public Factura registrarSalidaVehiculo(@RequestBody Factura factura) throws EstacionamientoException {
		return this.iEstacionamiento.registrarSalida(factura);
	}
}
