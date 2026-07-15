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

public class MenuProfesor {
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static Alumno alumno = new Alumno();
    static MaestroDAO maestroDAO = new MaestroDAO();
    static Maestro maestro = new Maestro();

    public static void ingresarMaestro()throws IOException{
        maestro = new Maestro();
        System.out.println("Numero de empleado");
        maestro.setNumEmpleado(Integer.parseInt(leer.readLine()));
        System.out.println("Edad");
        maestro.setEdad(Integer.parseInt(leer.readLine()));
        System.out.println("Nombre");
        maestro.setNombre(leer.readLine());
        System.out.println("Cedula profesional");
        maestro.setCedProfecional(leer.readLine());
        System.out.println("Curp");
        maestro.setCurp(leer.readLine());
        System.out.println("Puesto: (Tutor, Asesor, Coordinador)");
        maestro.setPuesto(leer.readLine());
        maestroDAO.nuevoMaestro(maestro);
    }

    public static void mostrarMaestro(){
        ArrayList<Maestro> maestros = maestroDAO.extraerMaestro();
        System.out.println("-----------------Lista de maestros-----------------");
        for (Maestro maestro : maestros){
            System.out.println(maestro);
        }
    }

    public static void modificarMaestro() throws IOException{
        System.out.println("ingresa el numero de empleado que quieres modificar");
        maestro.setNumEmpleado(Integer.parseInt(leer.readLine()));
        System.out.println("<----Modificaciones---->");
        System.out.println("Nombre");
        maestro.setNombre(leer.readLine());
        System.out.println("edad");
        maestro.setEdad(Integer.parseInt(leer.readLine()));
        System.out.println("Cedula profesional");
        maestro.setCedProfecional(leer.readLine());
        System.out.println("CURP");
        maestro.setCurp(leer.readLine());
        maestro.setCurp(leer.readLine());
        System.out.println("Puesto: (Tutor, Asesor, Coordinador)");
        maestroDAO.updateMae(maestro);
    }

    public static void borrarMaestro() throws IOException{
        System.out.println("Ingresa el numero de empleado del maestro que quieres eliminar");
        maestro.setNumEmpleado(Integer.parseInt(leer.readLine()));
        maestroDAO.deleteMae(maestro);
    }

    public static void buscarMaestro() throws IOException{
        System.out.println("Ingresa el numero de expediente del maestro que quieres buscar");
        maestro.setNumEmpleado(Integer.parseInt(leer.readLine()));
        ArrayList<Maestro> maestros_Lista = maestroDAO.buscarMae(maestro);
        System.out.println("Maestro encontrado:     ");
        for (Maestro maestro : maestros_Lista){
            System.out.println(maestro);
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

    public static void menuMaestros() throws IOException {
        int salir = 0;
        while (salir != 6) {
            System.out.println("1. Ingresar un nuevo maestro");
            System.out.println("2. Mostrar todos los maestros");
            System.out.println("3. Modificar maestro");
            System.out.println("4. Borrar un maestro");
            System.out.println("5. Buscar un maestro");
            System.out.println("6. Salir");
            salir = Integer.parseInt(leer.readLine());
            switch (salir) {
                case 1: ingresarMaestro(); break;
                case 2: mostrarMaestro(); break;
                case 3: modificarMaestro(); break;
                case 4: borrarMaestro(); break;
                case 5: buscarMaestro(); break;
                case 6: break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

}