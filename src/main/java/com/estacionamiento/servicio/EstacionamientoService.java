/**
 * 
 */
package com.estacionamiento.servicio;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Servicio;
import com.estacionamiento.exception.ParqueaderoException;
import com.estacionamiento.persistencia.FacturaEntity;
import com.estacionamiento.persistencia.ServicioEntity;
import com.estacionamiento.repositorio.IRepositorioFactura;
import com.estacionamiento.repositorio.IRepositorioServicio;
import com.estacionamiento.utils.Utilitarios;

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

	@Override
	public Factura registrarEntrada(Servicio servicio) {
		
		FacturaEntity facturaEntity = new FacturaEntity();
		Factura factura = new Factura();
		
		try {
			
			if (verificarDisponibilidadServicio(servicio)) {

				if(!Utilitarios.esDomingoOLunes(Calendar.getInstance()) && Utilitarios.placaVehiculoIniciaPorA(servicio.getPlaca())){
					throw new Exception(Utilitarios.PLACA_INI_EN_A);
				}else{
					
					servicio.setFechaHoraIngreso(Utilitarios.fechaActualAString());
					servicio.setEstado(Utilitarios.PARQUEADO);
					ServicioEntity servicioEntity=new ServicioEntity(servicio);
					iRepositorioServicio.save(servicioEntity);
					
					facturaEntity = new FacturaEntity(servicio);
					factura = Utilitarios.convertirAFactura(facturaEntity);
					iRepositorioFactura.save(facturaEntity);
					
				}
			
			}else{
				
				throw new Exception(Utilitarios.SINCUPO);
			}

		} catch (Exception e) {

			factura.setError(e.getMessage());
		}

		return factura;

	}

	@Override
	public boolean verificarDisponibilidadServicio(Servicio servicio) {

		boolean cupoDisponible = true;
		try {

			List<ServicioEntity> cantidaVehiculos = iRepositorioServicio.findByTipoVehiculoByEstado(servicio.getTipoVehiculo(),servicio.getEstado());
			Long cupoMax= (servicio.getTipoVehiculo() == Utilitarios.CARRO) ? Utilitarios.CUPOMAXCARROS:Utilitarios.CUPOMAXMOTOS;
			
			if (cantidaVehiculos.size() >= cupoMax) {

				cupoDisponible = false;
			}
		} catch (Exception e) {

			e.printStackTrace();
			cupoDisponible = false;
		}

		return cupoDisponible;
	}

	@Override
	public Factura registrarSalida(Factura facturaSalida) {

		FacturaEntity facturaEntity = iRepositorioFactura.findByPlacaByEstado(facturaSalida.getPlaca(),Utilitarios.PARQUEADO);
		Factura facturaCobro = new Factura();
		if (facturaEntity != null) {
                       
			try {
				
				facturaEntity.setFechaHoraSalida(Utilitarios.fechaActualAString());
				facturaEntity.setEstado(Utilitarios.NOPAQUEADO);
				facturaCobro= Utilitarios.convertirAFactura(this.calcularValorServicio(facturaEntity, facturaEntity.getFechaHoraSalida()));
				iRepositorioServicio.updateEstadoFechaHoraSalida(Utilitarios.NOPAQUEADO, facturaEntity.getPlaca(),facturaEntity.getFechaHoraSalida());
				iRepositorioFactura.updateEstadoFechaHoraSalida(Utilitarios.NOPAQUEADO, facturaEntity.getPlaca(),facturaEntity.getFechaHoraSalida());
			
			} catch (ParseException e) {

				ParqueaderoException pExeption = new ParqueaderoException(e.getMessage());
			}
			

		}

		return facturaCobro;
	}

	public FacturaEntity calcularValorServicio(FacturaEntity facturaEntity, String fechaActual) throws ParseException{
		
		double tiempoMs;
		double servicioHoras;
		double servicioDias;
		
		if(facturaEntity != null){
			
		Date fechaIngreso = Utilitarios.fechaStringADate(facturaEntity.getFechaHoraIngreso());
		Date fechaSalida= Utilitarios.fechaStringADate(fechaActual);	
		tiempoMs= fechaSalida.getTime() - fechaIngreso.getTime();
		servicioHoras=(tiempoMs / 3.6e+6)% 24;
		servicioDias=Math.floor((tiempoMs / 3.6e+6)/24);
		Long valorDia= (facturaEntity.getTipoVehiculo()==Utilitarios.CARRO) ? Utilitarios.VALORDIACARRO:Utilitarios.VALORDIAMOTO;
		Long valorHora=(facturaEntity.getTipoVehiculo()==Utilitarios.CARRO) ? Utilitarios.VALORDIACARRO:Utilitarios.VALORDIAMOTO;
		
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
