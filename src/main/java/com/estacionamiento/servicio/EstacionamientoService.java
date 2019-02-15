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
import com.estacionamiento.dominio.Recibo;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.persistencia.VehiculoEntity;
import com.estacionamiento.repositorio.IRepositorioVehiculo;
import com.estacionamiento.utils.Utilitarios;

/**
 * @author alvaro.osorio
 *
 */

@Service
@Transactional
public class EstacionamientoService implements IEstacionamientoService {

	@Autowired
	IRepositorioVehiculo iRepositorioVehiculo;

	private static final Logger LOGGER = LoggerFactory.getLogger(EstacionamientoService.class);

	@Override
	public Recibo registrarEntrada(Vehiculo vehiculo) throws EstacionamientoException {

		Recibo recibo = new Recibo();

		try {
			if (verificarDisponibilidadServicio(vehiculo)) {

				if (!Utilitarios.esDomingoOLunes(Calendar.getInstance())
						&& Utilitarios.placaVehiculoIniciaPorA(vehiculo.getPlaca())) {

					throw new EstacionamientoException(Utilitarios.PLACA_INI_EN_A);

				} else {

					vehiculo.setFechaHoraIngreso(Utilitarios.fechaActualAString());
					vehiculo.setEstado(Utilitarios.PARQUEADO);
					VehiculoEntity vehiculoEntity = new VehiculoEntity(vehiculo.getPlaca(),
							vehiculo.getFechaHoraIngreso(), vehiculo.getFechaHoraSalida(), vehiculo.getTipoVehiculo(),
							Utilitarios.PARQUEADO, vehiculo.getCilindraje(), 0);

					iRepositorioVehiculo.save(vehiculoEntity);

					recibo = new Recibo(vehiculo.getPlaca(), vehiculo.getFechaHoraIngreso(),
							vehiculo.getFechaHoraSalida(), vehiculo.getTipoVehiculo(), null);

				}

			} else {

				throw new EstacionamientoException(Utilitarios.SINCUPO);
			}
		} catch (ParseException e) {

			LOGGER.info(e.getMessage());
		}

		return recibo;

	}

	@Override
	public boolean verificarDisponibilidadServicio(Vehiculo vehiculo) {

		boolean cupoDisponible = true;

		List<VehiculoEntity> cantidaVehiculos = iRepositorioVehiculo
				.findByTipoVehiculoByEstado(vehiculo.getTipoVehiculo(), Utilitarios.PARQUEADO);
		Long cupoMax = (vehiculo.getTipoVehiculo() == Utilitarios.CARRO) ? Utilitarios.CUPOMAXCARROS
				: Utilitarios.CUPOMAXMOTOS;

		if (cantidaVehiculos.size() >= cupoMax) {

			cupoDisponible = false;
		}

		return cupoDisponible;
	}

	@Override
	public Factura registrarSalida(Recibo recibo) throws EstacionamientoException {

		Factura facturaCobro = new Factura();

		try {

			VehiculoEntity vehiculoEntity = iRepositorioVehiculo.findByPlacaByEstado(recibo.getPlaca(),
					Utilitarios.PARQUEADO);

			if (vehiculoEntity != null) {

				vehiculoEntity.setFechaHoraSalida(Utilitarios.fechaActualAString());
				vehiculoEntity.setEstado(Utilitarios.NOPAQUEADO);
				vehiculoEntity.setValorServico(this.calcularValorServicio(vehiculoEntity));
				iRepositorioVehiculo.save(vehiculoEntity);
				facturaCobro = new Factura(vehiculoEntity.getPlaca(), vehiculoEntity.getFechaHoraIngreso(),
						vehiculoEntity.getFechaHoraSalida(), vehiculoEntity.getValorServico(),
						vehiculoEntity.getTipoVehiculo(), vehiculoEntity.getEstado(), null);

			} else {

				throw new EstacionamientoException(Utilitarios.FACTURANOEXISTE);
			}
		} catch (Exception e) {

			LOGGER.info(e.getMessage());
		}

		return facturaCobro;
	}

	public long calcularValorServicio(VehiculoEntity vehiculoEntity) throws ParseException {

		Long tiempoMs;
		Long servicioHoras;
		Long servicioDias;
		long valorServicio = 0;

		if (vehiculoEntity != null) {

			Date fechaIngreso = Utilitarios.fechaStringADate(vehiculoEntity.getFechaHoraIngreso());
			Date fechaSalida = Utilitarios.fechaStringADate(vehiculoEntity.getFechaHoraSalida());

			tiempoMs = fechaSalida.getTime() - fechaIngreso.getTime();
			servicioHoras = (long) ((tiempoMs / Utilitarios.HORAENMLS) % 24);
			servicioDias = (long) (tiempoMs / Utilitarios.HORAENMLS) / 24;

			long valorDia = (vehiculoEntity.getTipoVehiculo() == Utilitarios.CARRO) ? Utilitarios.VALORDIACARRO
					: Utilitarios.VALORDIAMOTO;
			long valorHora = (vehiculoEntity.getTipoVehiculo() == Utilitarios.CARRO) ? Utilitarios.VALORHORACARRO
					: Utilitarios.VALORDHORAMOTO;

			if (servicioHoras >= 9) {

				servicioDias += 1;
				long valorTotalDias = servicioDias * valorDia;
				valorServicio = (vehiculoEntity.getTipoVehiculo() == Utilitarios.MOTO
						? valorTotalDias + (Utilitarios.RECARGOMOTOCC) : valorTotalDias);

			} else if (servicioHoras < 9) {
				long valorTotalDias = servicioDias * valorDia;
				long valorTotalHoras = servicioHoras * valorHora;
				valorServicio = (vehiculoEntity.getTipoVehiculo() == Utilitarios.MOTO
						? (valorTotalHoras + valorTotalDias + Utilitarios.RECARGOMOTOCC)
						: (valorTotalDias + valorTotalHoras));

			}

		}
		return valorServicio;
	}

}
