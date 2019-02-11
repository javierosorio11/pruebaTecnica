/**
 * 
 */
package com.pruebaTecnica.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaTecnica.dominio.Servicio;
import com.pruebaTecnica.persistencia.ServicioEntity;
import com.pruebaTecnica.repositorio.IRepositorioServicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author alvaro.osorio
 *
 */

@Service
@Transactional
public class EstacionamientoService implements IEstacionamientoService {


	@Autowired
	IRepositorioServicio iRepositorioServicio;
	

	private static final Logger logger = LoggerFactory.getLogger(EstacionamientoService.class);


	@Override
	public void registrarEntrada(ServicioEntity servicio) {
		
		iRepositorioServicio.save(servicio);
		
	}










}
