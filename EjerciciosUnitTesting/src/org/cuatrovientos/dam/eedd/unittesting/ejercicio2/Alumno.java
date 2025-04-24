package org.cuatrovientos.dam.eedd.unittesting.ejercicio2;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Alumno {
	private String nombre;
	private String email;
	private ArrayList<Modulo> modulos;

//    No hemos visto como hacer validaciones, chatGPT, me planteo esto:
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

//    Constructor para Alumno
	public Alumno(String nombre, String email, ArrayList<Modulo> modulos) {
		this.nombre = nombre;
		this.email = email;
		this.modulos = modulos;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Modulo> getModulos() {
		return modulos;
	}

//    Método para saber si un alumno aprueba o nno
	public boolean apruebaCurso() {
		if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
			throw new IllegalArgumentException("Email inválido");
		}
		if (modulos == null || modulos.isEmpty()) {
			return true;
		}
		for (Modulo m : modulos) {
			if (m.calcularNota() <= 5.0) {
				return false;
			}
		}
		return true;
	}
}
