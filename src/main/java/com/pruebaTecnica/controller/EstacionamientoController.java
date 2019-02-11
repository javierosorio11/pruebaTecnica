package com.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaTecnica.dominio.Vehiculo;
import com.pruebaTecnica.servicio.IEstacionamientoService;

@RestController
public class EstacionamientoController {
	
	@Autowired
	IEstacionamientoService iEstacionamiento;
	
	@CrossOrigin
	@GetMapping("/")
	public String index() {
		return "<div style=\"text-align : center\">Bienvenidos al Parqueadero <h1>SEGURAR</div>";
	}
	
/*	@CrossOrigin
	@PostMapping("/disponibilidad")	
	public Servicio verificarDisponibilidadServicio(@RequestBody SolicitudServicio solicitudServicio) {
		return this.parqueaderoService.verificarDisponibilidadServicio(solicitudServicio);		
	}*/
	/*
	@CrossOrigin
	@PostMapping("/entrada")
	public Vehiculo registrarEntradaCarro(@RequestBody Vehiculo vehiculo) {
		return this.iEstacionamiento.registrarEntrada(vehiculo);		
	}	*/
	/*
	@CrossOrigin
	@GetMapping("/getAllCobros")
	public List<CobroEntity> consultarCobros(@RequestParam("estado") String estado) {
		return this.parqueaderoService.consultarCobros(estado);
	}
	
	@CrossOrigin
	@GetMapping("/salida")
	public Cobro registrarSalida(@RequestParam ("id") Long idCobro) {
		return this.parqueaderoService.registrarSalida(idCobro);
	}*/
}
