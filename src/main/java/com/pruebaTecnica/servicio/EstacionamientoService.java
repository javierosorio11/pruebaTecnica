/**
 * 
 */
package com.pruebaTecnica.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaTecnica.dominio.Vehiculo;
import com.pruebaTecnica.persistencia.ServicioEntity;
import com.pruebaTecnica.repositorio.IRepositorioServicio;
import com.pruebaTecnica.utils.VehiculoBuild;
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
	VehiculoBuild  vehiculoBuild;
	

	private static final Logger logger = LoggerFactory.getLogger(EstacionamientoService.class);

	@Override
	public Vehiculo registrarEntrada(Vehiculo vehiculo) {
		try{
		ServicioEntity servicio = new ServicioEntity();
		servicio=vehiculoBuild.convertirAEntity(vehiculo);
		iRepositorioServicio.save(servicio);
		}catch(Exception e){
			
			e.getMessage();
		}
		
		return vehiculo;
		
		
	}










}
