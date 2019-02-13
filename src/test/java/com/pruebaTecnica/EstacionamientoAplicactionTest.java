package com.pruebaTecnica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pruebaTecnica.controller.EstacionamientoController;





@RunWith(SpringRunner.class)
@SpringBootTest
public class EstacionamientoAplicactionTest {
	
	@Autowired
    private EstacionamientoController parqueaderoController;

	/*@Test
	public void contextLoads() {
		assertThat(parqueaderoController).isNotNull();
	}*/

}
