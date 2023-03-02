package com.generation.test.models;
import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    String nomMateria;
    String nomProfesor;
    Double promedioCurso;
    Double mejorNotaCurso;
    Double peorNotaCurso;
    Profesor profesor = new Profesor();
    ArrayList <Estudiante> estudiantes = new ArrayList<Estudiante>();
    

    //constructor
    public Curso() {
    }
		
    public void agregarNotasParaEstudiantesPorMateria() {
        System.out.println("Ingrese el nombre del profesor/a");
        Scanner sc = new Scanner(System.in);
        nomProfesor = sc.nextLine();
        profesor.setNombre(nomProfesor);
        System.out.println("Ingrese el nombre de la materia");
        nomMateria = sc.nextLine();
        System.out.println("Ingrese el numero de estudiantes");
        sc = new Scanner(System.in);
        int cantEst = sc.nextInt();
		int cantNotas;

		do{
			System.out.print("Indique la cantidad de notas por estudiante: ");
			cantNotas = sc.nextInt();
			if(cantNotas <= 0){
				System.out.print("La cantidad de notas debe ser mayor a cero");
			}
		}while(cantNotas <= 0);
		
		promedioCurso = 0.0;
        mejorNotaCurso = 0.0;
        peorNotaCurso = 7.0;

		for(int i = 1; i <= cantEst; i++){
			sc.nextLine();
			System.out.print("Ingresa nombre del estudiante: ");
            String nomEst = sc.nextLine();
            Estudiante estud = new Estudiante(nomEst);
			

			for(int x = 1; x <= cantNotas; x++){
				System.out.print("Ingresa nota " +x+ " del alumno "+ nomEst +": ");
				Double nota = sc.nextDouble();
				estud.agregarNota(nota);

                promedioCurso += nota;

                if (mejorNotaCurso < nota) {
                    mejorNotaCurso = nota;
                }
                if (peorNotaCurso > nota) {
                    peorNotaCurso = nota;
                }
			}
           
            estud.promedioNotas();
            estudiantes.add(estud);
        }
        promedioCurso /= (cantEst*cantNotas);
        sc.nextLine();
        System.out.println("Presione ENTER para mostrar las notas de los estudiantes");
        sc.nextLine();
        mostrarNotasParaEstudiantePorMateria();
        System.out.println("Presione ENTER para mostrar la información de las notas del curso");
        sc.nextLine();
        mostrarMejorPeorPromedio();
    }

    public void mostrarNotasParaEstudiantePorMateria() {
        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println("*******NOTAS ESTUDIANTES*******");
        System.out.println("");
        System.out.println("MATERIA: " + nomMateria + " por el profesor: " + profesor.getNombre());
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante e = estudiantes.get(i);
            System.out.println("Nombre del estudiante: " + e.getNombre());
            for (int y = 0; y < e.getNotas().size(); y++) {
                System.out.println("\tNota: " + e.getNotas().get(y));
            }
        }
    }

    public void mostrarMejorPeorPromedio() {
        System.out.println("-------------------------------");
        System.out.println("*******INFORMACION NOTAS*******");
        System.out.println("La mejor nota es: " + mejorNotaCurso);
        System.out.println("La peor nota es: " + peorNotaCurso);
        System.out.println("El promedio del curso es: " + promedioCurso);
    }
    



}

