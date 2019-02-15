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
import com.estacionamiento.exception.EstacionamientoException;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(EstacionamientoService.class);

	@Override
	public Factura registrarEntrada(Servicio servicio) throws EstacionamientoException {

		FacturaEntity facturaEntity;
		Factura factura = new Factura();

		try {
			if (verificarDisponibilidadServicio(servicio)) {

				if (!Utilitarios.esDomingoOLunes(Calendar.getInstance())
						&& Utilitarios.placaVehiculoIniciaPorA(servicio.getPlaca())) {

					throw new EstacionamientoException(Utilitarios.PLACA_INI_EN_A);

				} else {

					servicio.setFechaHoraIngreso(Utilitarios.fechaActualAString());
					servicio.setEstado(Utilitarios.PARQUEADO);
					ServicioEntity servicioEntity = Utilitarios.convertiServicioAServicioEntity(servicio);
					iRepositorioServicio.save(servicioEntity);

					facturaEntity = Utilitarios.convertiServicioAFacturaEntity(servicio);
					factura = Utilitarios.convertirAFactura(facturaEntity);
					iRepositorioFactura.save(facturaEntity);

				}

			} else {

				throw new EstacionamientoException(Utilitarios.SINCUPO);
			}
		} catch (ParseException e) {

			LOGGER.info(e.getMessage());
		}

		return factura;

	}

	@Override
	public boolean verificarDisponibilidadServicio(Servicio servicio) {

		boolean cupoDisponible = true;

		List<ServicioEntity> cantidaVehiculos = iRepositorioServicio
				.findByTipoVehiculoByEstado(servicio.getTipoVehiculo(), Utilitarios.PARQUEADO);
		Long cupoMax = (servicio.getTipoVehiculo() == Utilitarios.CARRO) ? Utilitarios.CUPOMAXCARROS
				: Utilitarios.CUPOMAXMOTOS;

		if (cantidaVehiculos.size() >= cupoMax) {

			cupoDisponible = false;
		}

		return cupoDisponible;
	}

	@Override
	public Factura registrarSalida(Factura facturaSalida) throws EstacionamientoException {

		FacturaEntity facturaEntity = iRepositorioFactura.findByPlacaByEstado(facturaSalida.getPlaca(),
				Utilitarios.PARQUEADO);
		ServicioEntity servicioEntity = iRepositorioServicio.findByPlacaByEstado(facturaSalida.getPlaca(),
				Utilitarios.PARQUEADO);
		Factura facturaCobro = new Factura();
		if (facturaEntity != null) {

			try {
				String fechaSalida = Utilitarios.fechaActualAString();
				facturaEntity.setFechaHoraSalida(fechaSalida);
				facturaEntity.setEstado(Utilitarios.NOPAQUEADO);
				facturaCobro = Utilitarios.convertirAFactura(
						this.calcularValorServicio(facturaEntity, facturaEntity.getFechaHoraSalida()));
				iRepositorioFactura.save(facturaEntity);

				servicioEntity.setFechaHoraSalida(fechaSalida);
				servicioEntity.setEstado(Utilitarios.NOPAQUEADO);
				iRepositorioServicio.save(servicioEntity);

			} catch (ParseException e) {

				LOGGER.info(e.getMessage());
			}

		} else {

			throw new EstacionamientoException(Utilitarios.FACTURANOEXISTE);
		}

		return facturaCobro;
	}

	public FacturaEntity calcularValorServicio(FacturaEntity facturaEntity, String fechaActual) throws ParseException {

		Long tiempoMs;
		Long servicioHoras;
		Long servicioDias;

		if (facturaEntity != null) {

			Date fechaIngreso = Utilitarios.fechaStringADate(facturaEntity.getFechaHoraIngreso());
			Date fechaSalida = Utilitarios.fechaStringADate(fechaActual);

			tiempoMs = fechaSalida.getTime() - fechaIngreso.getTime();
			servicioHoras = (long) ((tiempoMs / Utilitarios.HORAENMLS) % 24);
			servicioDias = (long) (tiempoMs / Utilitarios.HORAENMLS) / 24;

			Long valorDia = (facturaEntity.getTipoVehiculo() == Utilitarios.CARRO) ? Utilitarios.VALORDIACARRO
					: Utilitarios.VALORDIAMOTO;
			Long valorHora = (facturaEntity.getTipoVehiculo() == Utilitarios.CARRO) ? Utilitarios.VALORHORACARRO
					: Utilitarios.VALORDHORAMOTO;

			if (servicioHoras >= 9) {

				servicioDias += 1;
				long valorTotalDias = servicioDias * valorDia;
				long valorServicio = (facturaEntity.getTipoVehiculo() == Utilitarios.MOTO
						? valorTotalDias + (Utilitarios.RECARGOMOTOCC) : valorTotalDias);
				facturaEntity.setValorServicio(valorServicio);

			} else if (servicioHoras < 9) {
				long valorTotalDias = servicioDias * valorDia;
				long valorTotalHoras = servicioHoras * valorHora;
				long valorServicio = (facturaEntity.getTipoVehiculo() == Utilitarios.MOTO
						? (valorTotalHoras + valorTotalDias + Utilitarios.RECARGOMOTOCC)
						: (valorTotalDias + valorTotalHoras));
				facturaEntity.setValorServicio(valorServicio);

			}

		}
		return facturaEntity;
	}

}
