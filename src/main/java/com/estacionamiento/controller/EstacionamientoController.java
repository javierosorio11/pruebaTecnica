package com.estacionamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.servicio.IEstacionamientoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class EstacionamientoController {

	@Autowired
	IEstacionamientoService iEstacionamiento;

	@CrossOrigin
	@GetMapping("/estacionamiento")
	public String index() {
		return "<div style=\"text-align : center\">Bienvenidos al Parqueadero <h1>CEIBA-PARKING</div>";
	}

	@CrossOrigin
	@PostMapping("estacionamiento/disponibilidad")
	public boolean verificarDisponibilidadServicio(@RequestBody Vehiculo vehiculo) {
		return this.iEstacionamiento.verificarDisponibilidadServicio(vehiculo);
	}

	@CrossOrigin
	@PostMapping("estacionamiento/registrarEntrada")
	public Vehiculo registrarEntradaVehiculo(@RequestBody Vehiculo vehiculo) throws EstacionamientoException {
		return this.iEstacionamiento.registrarEntrada(vehiculo);
	}

	@CrossOrigin
	@PostMapping("estacionamiento/registrarSalida")
	public Factura registrarSalidaVehiculo(@RequestBody Vehiculo vehiculo) throws EstacionamientoException {
		return this.iEstacionamiento.registrarSalida(vehiculo);
	}

	@CrossOrigin
	@GetMapping("estacionamiento/vehiculosEstacionados")
	public List<Vehiculo> vehiculosEstacionados() throws EstacionamientoException {
		return this.iEstacionamiento.vehiculosEstacionados();
	}
}
