package com.estacionamiento.servicio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estacionamiento.dominio.Factura;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.persistencia.VehiculoEntity;
import com.estacionamiento.repositorio.IRepositorioVehiculo;
import com.estacionamiento.utils.Utilitarios;

@Service
@Transactional
public class EstacionamientoService implements IEstacionamientoService {

	@Autowired
	IRepositorioVehiculo iRepositorioVehiculo;

	private static final Logger LOGGER = LoggerFactory.getLogger(EstacionamientoService.class);

	@Override
	public Vehiculo registrarEntrada(Vehiculo vehiculo) throws EstacionamientoException {

		try {

			validarNoExiste(vehiculo.getPlaca());

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

				}

			} else {

				throw new EstacionamientoException(Utilitarios.SINCUPO);
			}
		} catch (ParseException e) {

			LOGGER.info(e.getMessage());
		}

		return vehiculo;

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
	public Factura registrarSalida(Vehiculo vehiculo) throws EstacionamientoException {

		Factura facturaCobro = new Factura();

		try {

			VehiculoEntity vehiculoEntity = iRepositorioVehiculo.findByPlacaByEstado(vehiculo.getPlaca(),
					Utilitarios.PARQUEADO);

			if (vehiculoEntity != null) {

				vehiculoEntity.setFechaHoraSalidaVehiculo(Utilitarios.fechaActualAString());
				vehiculoEntity.setEstadoVehiculo(Utilitarios.NOPAQUEADO);
				vehiculoEntity.setValorServicioVehiculo(this.calcularValorServicio(vehiculoEntity));
				iRepositorioVehiculo.save(vehiculoEntity);
				facturaCobro = new Factura(vehiculoEntity.getPlacaVehiculo(),
						vehiculoEntity.getFechaHoraIngresoVehiculo(), vehiculoEntity.getFechaHoraSalidaVehiculo(),
						vehiculoEntity.getValorServicioVehiculo(), vehiculoEntity.getTipoVehiculo(),
						vehiculoEntity.getEstadoVehiculo(), null);

			} else {

				throw new EstacionamientoException(Utilitarios.FACTURANOEXISTE);
			}
		} catch (Exception e) {

			LOGGER.error(Utilitarios.ERROR_REGISTRA_SALIDA, e);
			facturaCobro.setErrorFactura(Utilitarios.ERROR_REGISTRA_SALIDA);
		}

		return facturaCobro;
	}

	public long calcularValorServicio(VehiculoEntity vehiculoEntity) throws ParseException {

		Long tiempoMs;
		Long servicioHoras;
		Long servicioDias;
		long valorServicio = 0;

		if (vehiculoEntity != null) {

			Date fechaIngreso = Utilitarios.fechaStringADate(vehiculoEntity.getFechaHoraIngresoVehiculo());
			Date fechaSalida = Utilitarios.fechaStringADate(vehiculoEntity.getFechaHoraSalidaVehiculo());

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

	@Override
	public List<Vehiculo> vehiculosEstacionados() throws EstacionamientoException {

		List<VehiculoEntity> lstVehiculosEntity = iRepositorioVehiculo.findByEstadoVehiculo(Utilitarios.PARQUEADO);
		List<Vehiculo> lstVehiculos = new ArrayList<>();

		if (!lstVehiculosEntity.isEmpty()) {

			for (VehiculoEntity vehiculoEntity : lstVehiculosEntity) {

				Vehiculo vehiculo = new Vehiculo(vehiculoEntity.getPlacaVehiculo(),
						vehiculoEntity.getFechaHoraIngresoVehiculo(), vehiculoEntity.getFechaHoraSalidaVehiculo(),
						vehiculoEntity.getTipoVehiculo(), vehiculoEntity.getEstadoVehiculo(),
						vehiculoEntity.getCilindrajeVehiculo(), vehiculoEntity.getValorServicioVehiculo());

				lstVehiculos.add(vehiculo);
			}
		} else {

			throw new EstacionamientoException(Utilitarios.NO_EXISTEN_VEHICULOS);
		}

		return lstVehiculos;
	}

	public void validarNoExiste(String placa) throws EstacionamientoException {

		VehiculoEntity vehiculoEntity = iRepositorioVehiculo.findByPlacaByEstado(placa, Utilitarios.PARQUEADO);
		if (vehiculoEntity != null) {
			throw new EstacionamientoException(Utilitarios.VEHICULO_EXITE);
		}

	}

}
