package com.pruebaTecnica;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pruebaTecnica.controller.EstacionamientoController;


@SpringBootTest

public class EstacionamientoAplicationTest {

	@Autowired
    EstacionamientoController estacionamientoController;

	@Test
	public void contextLoads() {
		assertThat(estacionamientoController).isNotNull();
	}

}
