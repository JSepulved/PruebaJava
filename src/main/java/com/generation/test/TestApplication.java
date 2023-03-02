package com.generation.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.generation.test.models.Curso;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		Curso cursoDefault = new Curso();
		cursoDefault.agregarNotasParaEstudiantesPorMateria();
	}
















}
