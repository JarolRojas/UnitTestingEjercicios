/**
 * 
 */
package UnitTests.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.cuatrovientos.dam.eedd.unittesting.ejercicio1.GeneradorIp;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class GeneradorIpTest {

	/**
	 * Test method for
	 * {@link org.cuatrovientos.dam.eedd.unittesting.ejercicio1.GeneradorIp#GenerarNumero(int, int)}.
	 */
	@Test
	void testGenerarNumero() {
		// Crear instancia de la clase que se va a testear
		GeneradorIp generador = new GeneradorIp();

		int min = 0;
		int max = 254;

		// Ejecutar 1000 veces para asegurarse de que los valores estén siempre dentro
		// del rango
		for (int i = 0; i < 1000; i++) {
			int numero = generador.generarNumero(min, max);
			assertTrue(numero >= min && numero <= max, "El número generado está fuera del rango " + min + " y " + max);
		}
	}

	/**
	 * Test method for
	 * {@link org.cuatrovientos.dam.eedd.unittesting.ejercicio1.GeneradorIp#generarIPV4()}.
	 */
	@Test
	void testGenerarIPV4() {
		// Crear instancia de la clase que se va a testear
		GeneradorIp generador = new GeneradorIp();

		String ip = generador.generarIPV4();
		String[] partes = ip.split("\\.");

		// Verificar que la dirección IP tenga 4 octetos
		assertEquals(4, partes.length, "La IP no tiene 4 octetos");

		// Validar que cada octeto esté en el rango de 0 a 254
		for (String parte : partes) {
			int num = Integer.parseInt(parte);

			assertTrue(num >= 0 && num <= 254, "Parte de la IP fuera de rango");
		}

		// Verificar que la IP no comience ni termine con 0
		assertNotEquals(0, Integer.parseInt(partes[0]), "La IP no debe empezar con 0");
		assertNotEquals(0, Integer.parseInt(partes[3]), "La IP no debe terminar con 0");
	}

}
