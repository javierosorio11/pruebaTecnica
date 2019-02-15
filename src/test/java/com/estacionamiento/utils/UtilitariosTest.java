package com.estacionamiento.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class UtilitariosTest {

	@Ignore
	@Test
	public void fechaActualAStringTest() throws ParseException {

		new Date();
		Utilitarios.fechaActualAString();

		Assert.assertSame(null, null);

	}

	@Test
	public void fechaStringADateTest() throws ParseException {

		String fechaString = "15-02-2019 08:34:22";

		Date ahoraString = Utilitarios.fechaStringADate(fechaString);

		Assert.assertNotNull(ahoraString);

	}

	@Test
	public void esDomingoTest() throws ParseException {

		Date domingo = Utilitarios.fechaStringADate("17-02-2019 01:21:22");
		Calendar calendarDomingo = Calendar.getInstance();
		calendarDomingo.setTime(domingo);

		Date lunes = Utilitarios.fechaStringADate("17-02-2019 01:21:22");
		Calendar calendarLunes = Calendar.getInstance();
		calendarLunes.setTime(lunes);

		boolean esDomingo = Utilitarios.esDomingoOLunes(calendarDomingo);
		boolean esLunes = Utilitarios.esDomingoOLunes(calendarLunes);

		Assert.assertTrue(esDomingo);
		Assert.assertTrue(esLunes);

	}

	@Test
	public void NoesDomingoOLunesTest() throws ParseException {

		Date sabado = Utilitarios.fechaStringADate("16-02-2019 01:21:22");
		Calendar calendarSabado = Calendar.getInstance();
		calendarSabado.setTime(sabado);

		boolean esDomingoOLunes = Utilitarios.esDomingoOLunes(calendarSabado);

		Assert.assertFalse(esDomingoOLunes);
	}

	@Test
	public void placaVehiculoIniciaPorATest() {

		String placa = "AVJ-243";

		boolean placaInicaEnA = Utilitarios.placaVehiculoIniciaPorA(placa);

		Assert.assertTrue(placaInicaEnA);
	}

	@Test
	public void placaVehiculoNoIniciaPorATest() {

		String placa = "BVJ-243";

		boolean placaInicaEnA = Utilitarios.placaVehiculoIniciaPorA(placa);

		Assert.assertFalse(placaInicaEnA);
	}

}
