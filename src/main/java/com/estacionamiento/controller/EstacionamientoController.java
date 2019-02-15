package com.estacionamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Recibo;
import com.estacionamiento.dominio.Vehiculo;
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
	public boolean verificarDisponibilidadServicio(@RequestBody Vehiculo vehiculo) {
		return this.iEstacionamiento.verificarDisponibilidadServicio(vehiculo);
	}

	@CrossOrigin
	@PostMapping("/registrarEntrada")
	public Recibo registrarEntradaVehiculo(@RequestBody Vehiculo vehiculo) throws EstacionamientoException {
		return this.iEstacionamiento.registrarEntrada(vehiculo);
	}

	@CrossOrigin
	@PostMapping("/registrarSalida")
	public Factura registrarSalidaVehiculo(@RequestBody Recibo recibo) throws EstacionamientoException {
		return this.iEstacionamiento.registrarSalida(recibo);
	}
}
