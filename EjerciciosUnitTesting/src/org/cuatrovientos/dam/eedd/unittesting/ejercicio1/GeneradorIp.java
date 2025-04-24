package org.cuatrovientos.dam.eedd.unittesting.ejercicio1;

import java.util.Random;

public class GeneradorIp {
	private Random rnd = new Random();

//	Método para generar un número aleatorio
	public int generarNumero(int min, int max) {
		return rnd.nextInt(min, max + 1);
	}

//	Método para generar un IPV4
	public String generarIPV4() {
		int[] numeros = new int[4];
		numeros[0] = generarNumero(1, 254);
		numeros[1] = generarNumero(0, 254);
		numeros[2] = generarNumero(0, 254);
		numeros[3] = generarNumero(1, 254);

		return numeros[0] + "." + numeros[1] + "." + numeros[2] + "." + numeros[3];
	}
}
