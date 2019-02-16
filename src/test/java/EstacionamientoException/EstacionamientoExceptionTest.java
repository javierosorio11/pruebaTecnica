package EstacionamientoException;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estacionamiento.EstacionamientoAplication;
import com.estacionamiento.dominio.Recibo;
import com.estacionamiento.dominio.Vehiculo;
import com.estacionamiento.exception.EstacionamientoException;
import com.estacionamiento.servicio.EstacionamientoService;
import com.estacionamiento.utils.Utilitarios;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstacionamientoAplication.class)
public class EstacionamientoExceptionTest {


	@Autowired
	EstacionamientoService estacionamientoService;
		
		
		@Test
		public void ExcepcionPlacaATest() throws ParseException {
			
			String exception="";
			
			try{
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setEstado(Utilitarios.PARQUEADO);
			vehiculo.setPlaca("AMQ");
			vehiculo.setTipoVehiculo(Utilitarios.CARRO);
			vehiculo.setCilindraje(0);

			estacionamientoService.registrarEntrada(vehiculo);
			}catch (EstacionamientoException e) {
				
				exception= e.getMessage();
			}
			
			Assert.assertEquals("Hoy no tiene permitido ingresar", exception);

	    } 

}
