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
class AlumnoTest {
	@Test
	void testApruebaSinModulos() {
		Alumno a = new Alumno("Juan", "juan@gmail.com", new ArrayList<>());
		assertTrue(a.apruebaCurso());
	}

	@Test
	void testApruebaTodosModulos() {
		Modulo m1 = new Modulo("M1", new ArrayList<>(Arrays.asList(8.0)), new ArrayList<>(Arrays.asList(7.0)));
		Modulo m2 = new Modulo("M2", new ArrayList<>(Arrays.asList(6.0)), new ArrayList<>(Arrays.asList(6.0)));
		Alumno a = new Alumno("Ana", "ana@gmail.com", new ArrayList<>(Arrays.asList(m1, m2)));
		assertTrue(a.apruebaCurso());
	}

	@Test
	void testNoApruebaPorModuloSuspenso() {
		Modulo m1 = new Modulo("M1", new ArrayList<>(Arrays.asList(8.0)), new ArrayList<>(Arrays.asList(7.0)));
		Modulo m2 = new Modulo("M2", new ArrayList<>(Arrays.asList(5.0)), new ArrayList<>(Arrays.asList(5.0)));
		Alumno a = new Alumno("Luis", "luis@gmail.com", new ArrayList<>(Arrays.asList(m1, m2)));
		assertFalse(a.apruebaCurso());
	}

	@Test
	void testEmailNulo() {
		Alumno a = new Alumno("Eva", null, new ArrayList<>());
		assertThrows(IllegalArgumentException.class, a::apruebaCurso);
	}

	@Test
	void testEmailInvalido() {
		Alumno a = new Alumno("Paco", "paco-at-mail.com", new ArrayList<>());
		assertThrows(IllegalArgumentException.class, a::apruebaCurso);
	}

	// assertThrows espera que se lance una excepción IllegalArgumentException
}
