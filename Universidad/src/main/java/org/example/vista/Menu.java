package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.MaestroDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Maestro;
import org.example.modelo.PersonaUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static MenuAlumnos menuAlumnos = new MenuAlumnos ();
    static MenuProfesor menuProfesor= new MenuProfesor();

    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static Alumno alumno = new Alumno();
    static MaestroDAO maestroDAO = new MaestroDAO();
    static Maestro maestro = new Maestro();

    private static void mostrarComunidadUniversitaria() {
        ArrayList<PersonaUT> comunidadUniversitaria = new ArrayList<>();
        comunidadUniversitaria.addAll(alumnoDAO.extraerAlumnos());
        comunidadUniversitaria.addAll(maestroDAO.extraerMaestro());
        for (PersonaUT persona : comunidadUniversitaria) {
            System.out.println(persona);
        }
    }

    public static void menu() throws IOException {
        int salir = 0;
        while (salir != 4) {
            System.out.println("1. Alumnos");
            System.out.println("2. Maestros");
            System.out.println("3. Mostrar comunidad universitaria");
            System.out.println("4. Salir");
            salir = Integer.parseInt(leer.readLine());
            switch (salir) {
                case 1: menuAlumnos.menuAlumnos(); break;
                case 2: menuProfesor.menuMaestros(); break;
                case 3: mostrarComunidadUniversitaria(); break;
                case 4:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }


}