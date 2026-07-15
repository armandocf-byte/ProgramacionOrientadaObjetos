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

public class MenuAlumnos {
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static Alumno alumno = new Alumno();
    static MaestroDAO maestroDAO = new MaestroDAO();
    static Maestro maestro = new Maestro();

    public static void inscribir() throws IOException{
        System.out.println("Numero de expediente: ");
        alumno.setNumeroExpediente(Integer.parseInt(leer.readLine()));
        System.out.println("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.println("Edad: ");
        alumno.setEdad(Integer.parseInt(leer.readLine()));
        System.out.println("Carrera: (TI, Qui, Mec, Mkt)");
        alumno.setCarrera(leer.readLine());
        System.out.println("Cuatrimestre");
        alumno.setCuatrimestre(Integer.parseInt(leer.readLine()));
        System.out.println("Curp");
        alumno.setCurp(leer.readLine());
        alumnoDAO.nuevoAlumno(alumno);
    }

    public static void mostrar(){
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumnos();
        System.out.println("-----------------Lista de alumnos inscritos-----------------");
        for (Alumno alumno: alumnos){
            System.out.println(alumno);
        }
    }

    public static void modificar() throws IOException{
        System.out.println("Modificar alumno por numero de expediente");
        System.out.println("Numero de expediente: ");
        alumno.setNumeroExpediente(Integer.parseInt(leer.readLine()));
        System.out.println("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.println("Edad: ");
        alumno.setEdad(Integer.parseInt(leer.readLine()));
        System.out.println("Carrera: (TI, Qui, Mec, Mkt) ");
        alumno.setCarrera(leer.readLine());
        System.out.println("Cuatrimestre: ");
        alumno.setCuatrimestre(Integer.parseInt(leer.readLine()));
        System.out.println("Curp");
        maestro.setCurp(leer.readLine());
        alumnoDAO.actualizarAlumno(alumno);
    }

    public static void borrar() throws IOException{
        System.out.println("Borrar alumno por numero de expediente");
        System.out.println("Numero de expediente: ");
        alumno.setNumeroExpediente(Integer.parseInt(leer.readLine()));
        alumnoDAO.borrarAlumno(alumno);
    }

    public static void buscar() throws IOException {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        System.out.println("-------Buscar alumno-------");
        Alumno alumnoBuscar = new Alumno();
        System.out.print("Número de expediente del alumno: ");
        alumnoBuscar.setNumeroExpediente(Integer.parseInt(leer.readLine()));
        boolean encontrado = alumnoDAO.buscarAlumno(alumnoBuscar);
        if (encontrado) {
            System.out.println("\n[Alumno encontrado: ]");
            System.out.println(alumnoBuscar);
        } else {
            System.out.println("No se encontró ningún alumno con ese número de expediente.");
        }
    }


    private static void mostrarComunidadUniversitaria() {
        ArrayList<PersonaUT> comunidadUniversitaria = new ArrayList<>();
        comunidadUniversitaria.addAll(alumnoDAO.extraerAlumnos());
        comunidadUniversitaria.addAll(maestroDAO.extraerMaestro());
        for (PersonaUT persona : comunidadUniversitaria) {
            System.out.println(persona);
        }
    }
    public static void menuAlumnos()throws IOException {
        int salir =0;
        while (salir!=6){
            System.out.println("1. Inscribir nuevo alumno");
            System.out.println("2. Mostrar todos los alumnos");
            System.out.println("3. Modificar un alumno");
            System.out.println("4. Borrar un alumno");
            System.out.println("5. Buscar un alumno");
            System.out.println("6. Salir");
            salir = Integer.parseInt(leer.readLine());
            switch (salir){
                case 1: inscribir();break;
                case 2: mostrar();break;
                case 3: modificar();break;
                case 4: borrar();break;
                case 5: buscar();break;
                case 6: break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

}