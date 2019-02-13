/**
 * 
 */
package com.pruebaTecnica.servicio;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaTecnica.dominio.Factura;
import com.pruebaTecnica.persistencia.FacturaEntity;
import com.pruebaTecnica.persistencia.ServicioEntity;
import com.pruebaTecnica.repositorio.IRepositorioFactura;
import com.pruebaTecnica.repositorio.IRepositorioServicio;
import com.pruebaTecnica.utils.Utilitarios;

/**
 * @author alvaro.osorio
 *
 */

@Service
@Transactional
public class EstacionamientoService implements IEstacionamientoService {

	

	@Autowired
	IRepositorioServicio iRepositorioServicio;

	@Autowired
	IRepositorioFactura iRepositorioFactura;

	private static final Logger logger = LoggerFactory.getLogger(EstacionamientoService.class);
	Utilitarios util = new Utilitarios();

	@Override
	public Factura registrarEntrada(ServicioEntity servicio) {
		
		FacturaEntity facturaEntity = new FacturaEntity();
		Factura factura = new Factura();
		
		try {
			
			if (verificarDisponibilidadServicio(servicio)) {

				if(!util.esDomingoOLunes(Calendar.getInstance()) && util.placaVehiculoIniciaPorA(servicio.getPlaca())){
					throw new Exception(util.PLACA_INI_EN_A);
				}else{
					
					servicio.setFechaHoraIngreso(util.fechaActualAString());
					iRepositorioServicio.save(servicio);
					facturaEntity = new FacturaEntity(servicio);
					factura = util.convertirAFactura(facturaEntity);
					iRepositorioFactura.save(facturaEntity);
					
				}
			
			}else{
				
				throw new Exception(util.SINCUPO);
			}

		} catch (Exception e) {

			factura.setError(e.getMessage());
		}

		return factura;

	}

	@Override
	public boolean verificarDisponibilidadServicio(ServicioEntity servicio) {

		boolean cupoDisponible = true;
		try {

			int cantidaVehiculos = (iRepositorioServicio.findByTipoVehiculoByEstado(servicio.getTipoVehiculo(),servicio.getEstado())).size();

			if (cantidaVehiculos > util.CUPOMAXCARROS) {

				cupoDisponible = false;
			}
		} catch (Exception e) {

			e.printStackTrace();
			cupoDisponible = false;
		}

		return cupoDisponible;
	}

	@Override
	public FacturaEntity registrarSalida(String placa) {

		ServicioEntity servicio = iRepositorioServicio.findByPlacaByEstado(placa, 1);
		FacturaEntity factura = null;

		if (servicio != null) {

			
			try {
				factura = new FacturaEntity(servicio);
				factura.setEstado(util.NOPAQUEADO);
				factura.setFechaHoraSalida(util.fechaActualAString());
				iRepositorioServicio.updateEstado(util.NOPAQUEADO, servicio.getPlaca());
				this.calcularValorServicio(factura, factura.getFechaHoraSalida());
				iRepositorioFactura.save(factura);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			

		}

		return factura;
	}

	public FacturaEntity calcularValorServicio(FacturaEntity facturaEntity, String fechaActual) throws ParseException{
		
		double tiempoMs;
		double servicioHoras;
		double servicioDias;
		
		if(facturaEntity != null){
			
		Date fechaIngreso = util.fechaStringADate(facturaEntity.getFechaHoraIngreso());
		Date fechaSalida= util.fechaStringADate(fechaActual);	
		tiempoMs= fechaSalida.getTime() - fechaIngreso.getTime();
		servicioHoras=(tiempoMs / 3.6e+6)% 24;
		servicioDias=Math.floor((tiempoMs / 3.6e+6)/24);
		Long valorDia= (facturaEntity.getTipoVehiculo()==util.CARRO) ? util.VALORDIACARRO:util.VALORDIAMOTO;
		Long valorHora=(facturaEntity.getTipoVehiculo()==util.CARRO) ? util.VALORDIACARRO:util.VALORDIAMOTO;
		
		if(Math.floor(servicioHoras) !=0 && servicioDias != 0 ){
		
			if(servicioHoras > 9 && servicioDias != 0){
			 servicioDias += 1;
			 facturaEntity.setValorServicio((long) (servicioDias * valorDia));
			}else if(servicioHoras <= 9 && servicioDias != 0){
				
			 facturaEntity.setValorServicio((long)((Math.floor(servicioHoras)*valorHora)+(servicioDias*valorDia)));
			 
			}
			
		  }
			
		}
		return facturaEntity;
	}
	
}
