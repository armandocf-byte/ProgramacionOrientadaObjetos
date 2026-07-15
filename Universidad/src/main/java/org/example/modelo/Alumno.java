package org.example.modelo;

import java.util.Locale;

public class Alumno extends PersonaUT implements Ensenable, Evaluable {
    private int numeroExpediente;
    private int edad;
    private String carrera;
    private int cuatrimestre;


    private boolean resgistroCorrecto = false;
    private static final String[] CARRERAS_VALIDAS = {"TI", "Qui", "Mec", "Mkt"};

    public Alumno() {
        super();
    }

    public Alumno(int numeroExpediente, String nombre, String curp, int edad, String carrera, int cuatrimestre) {
        super(nombre, curp);
        setNumeroExpediente(numeroExpediente);
        setEdad(edad);
        setCarrera(carrera);
        setCuatrimestre(cuatrimestre);

    }


    public int getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(int numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 15 && edad < 110) {
            this.edad = edad;
        } else {
            System.out.println("La edad debe de estar entre 15 y 110 años de edad");
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if (validarCarreras(carrera)) {
            this.carrera = carrera;
        } else {
            System.out.println("Carrera inválida");
        }
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        if (cuatrimestre > 0 && cuatrimestre < 12) {
            this.cuatrimestre = cuatrimestre;
        } else {
            System.out.println("El cuatrimestre debe de ser entre 1 y 11");
        }
    }

    public boolean validarCarreras(String carrera) {
        if (carrera == null) return false;
        for (String validar : Alumno.CARRERAS_VALIDAS) {
            if (carrera.equalsIgnoreCase(validar)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String mostrarTipoPersona() {
        return "----- ALUMNO -----";
    }

    @Override
    public String toString() {
        return mostrarTipoPersona() + "\n" +
                super.toString() +
                "Número de Expediente: " + numeroExpediente + '\n' +
                "Edad: " + edad + '\n' +
                "Carrera: " + carrera + '\n' +
                "Cuatrimestre: " + cuatrimestre + '\n' +
                aprender() + "\n" +
                recibirEvaluacion() + "\n" +
                "--------------------------------------";
    }

    @Override
    public String aprender() {
        return "El alumno esta aprendiendo";
    }

    @Override
    public String recibirEvaluacion() {
        return "El alumno esta siendo evaluado" ;
    }
}