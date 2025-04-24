package org.cuatrovientos.dam.eedd.unittesting.ejercicio2;

import java.util.ArrayList;

public class Modulo {
	private String nombre;
	private ArrayList<Double> entregables;
	private ArrayList<Double> examenes;

//	Constructor para Módulo
	public Modulo(String nombre, ArrayList<Double> entregables, ArrayList<Double> examenes) {
		super();
		this.nombre = nombre;
		this.entregables = entregables;
		this.examenes = examenes;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Double> getEntregables() {
		return entregables;
	}

	public ArrayList<Double> getExamenes() {
		return examenes;
	}

//	Método para calcular la nota
	public double calcularNota() {
		if (entregables.contains(-1.0)) {
			return 0.0;

		}
		if (examenes.contains(-1.0)) {
			return 0.0;
		}

		double maxInferior = -1.0;
		for (Double nota : examenes) {
			if (nota < 4.0 && nota > maxInferior) {
				maxInferior = nota;
			}
		}
		if (maxInferior >= 0.0) {
			return maxInferior;
		}

		double sumaEnt = 0.0;
		for (Double nota : entregables) {
			sumaEnt += nota;
		}
		double sumaEx = 0.0;
		for (Double nota : examenes) {
			sumaEx += nota;
		}
		double mediaEnt = sumaEnt / entregables.size();
		double mediaEx = sumaEx / examenes.size();

		return mediaEnt * 0.6 + mediaEx * 0.4;
	}
}
