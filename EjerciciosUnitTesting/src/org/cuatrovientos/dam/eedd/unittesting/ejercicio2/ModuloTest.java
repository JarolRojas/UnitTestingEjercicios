/**
 * 
 */
package org.cuatrovientos.dam.eedd.unittesting.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class ModuloTest {

	//Arrays.asList() --> sirve para crear listas
	
	@Test
	void testFaltaEntregable() {
		Modulo m = new Modulo("M1", new ArrayList<>(Arrays.asList(5.0, -1.0, 7.0)),
				new ArrayList<>(Arrays.asList(6.0, 8.0)));
		assertEquals(0.0, m.calcularNota());
	}

	@Test
	void testFaltaExamen() {
		Modulo m = new Modulo("M2", new ArrayList<>(Arrays.asList(5.0, 6.0)),
				new ArrayList<>(Arrays.asList(7.0, -1.0)));
		assertEquals(0.0, m.calcularNota());
	}

	@Test
	void testExamenInsuficiente() {
		Modulo m = new Modulo("M3", new ArrayList<>(Arrays.asList(6.0, 7.0)), new ArrayList<>(Arrays.asList(3.5, 5.0)));
		assertEquals(3.5, m.calcularNota());
	}

	@Test
	void testCalculoNormal() {
		Modulo m = new Modulo("M4", new ArrayList<>(Arrays.asList(8.0, 6.0)), new ArrayList<>(Arrays.asList(7.0, 9.0)));
		double expected = (8.0 + 6.0) / 2 * 0.6 + (7.0 + 9.0) / 2 * 0.4;
		assertEquals(expected, m.calcularNota());
	}

	@Test
	void testSinEntregablesNiExamenes() {
		Modulo m = new Modulo("M5", new ArrayList<>(), new ArrayList<>());
		assertTrue(Double.isNaN(m.calcularNota()));
	}

}
