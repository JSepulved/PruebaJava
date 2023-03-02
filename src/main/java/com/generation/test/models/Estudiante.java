package com.generation.test.models;
import java.util.ArrayList;

public class Estudiante extends Persona{
    Double promedio;
    ArrayList<Double> notas = new ArrayList<Double>();
    public Estudiante(String nombreEstudiante) {
        nombre = nombreEstudiante;
    }

    public ArrayList<Double> getNotas() {
       return notas;
    }

    public void agregarNota(Double nota) {
        notas.add(nota);
    }

    public void promedioNotas() {
        Double suma = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            suma += notas.get(i);
        }
        promedio = suma/notas.size();
    
    }
}




