package com.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaTecnica.dominio.Factura;
import com.pruebaTecnica.dominio.Vehiculo;
import com.pruebaTecnica.persistencia.FacturaEntity;
import com.pruebaTecnica.persistencia.ServicioEntity;
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
	
	@CrossOrigin
	@PostMapping("/disponibilidad")	
	public boolean verificarDisponibilidadServicio(@RequestBody ServicioEntity servicio) {
		return this.iEstacionamiento.verificarDisponibilidadServicio(servicio);		
	}
	
	@CrossOrigin
	@PostMapping("/registrarEntrada")
	public Factura registrarEntradaVehiculo(@RequestBody ServicioEntity servicio) {
		return this.iEstacionamiento.registrarEntrada(servicio);		
	}	
	/*
	@CrossOrigin
	@GetMapping("/getAllCobros")
	public List<CobroEntity> consultarCobros(@RequestParam("estado") String estado) {
		return this.parqueaderoService.consultarCobros(estado);
	}*/
	
	@CrossOrigin
	@GetMapping("/registrarSalida")
	public FacturaEntity registrarSalidaVehiculo(@RequestParam ("placa") String placa) {
		return this.iEstacionamiento.registrarSalida(placa);
	}
}
