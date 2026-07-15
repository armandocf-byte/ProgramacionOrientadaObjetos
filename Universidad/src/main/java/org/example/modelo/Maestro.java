package org.example.modelo;

public class Maestro extends PersonaUT implements Ensenador, Evaluador{
    private int numEmpleado;
    private int edad;
    private String cedulaProfecional;
    private String puesto;


    private boolean registroMaestro = false;
    private static final String[] PUESTOS_VALIDOS = {"Tutor", "Asesor", "Coordinador"};


    public Maestro() {
        super();

    }



    public Maestro(int numEmpleado, int edad,  String curp, String cedProfecional, String nombre, String puesto) {
        super(nombre, curp);
        setNumEmpleado(numEmpleado);
        setEdad(edad);
        setCedProfecional(cedProfecional);
        setPuesto(puesto);
    }
    @Override
    public String mostrarTipoPersona() {

        return "----- PROFESOR -----";
    }



    public int getNumEmpleado() {

        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        if (numEmpleado == 0){
            System.out.println("El numero de empleado es requerido");
        }else{
            this.numEmpleado= numEmpleado;
        }
    }

    public int getEdad() {

        return edad;
    }

    public void setEdad(int edad) {
        if (edad>17 && edad <109){
            this.edad=edad;
        }else {
            System.out.println("La edad requerida es entre 18 y 99 años");
        }
    }



    public String getCedProfecional() {

        return cedulaProfecional;
    }

    public void setCedProfecional(String cedProfecional) {

        this.cedulaProfecional = cedProfecional;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public boolean validar_puesto(String puesto){
        if (puesto == null) return false;
        for (String validar : Maestro.PUESTOS_VALIDOS) {
            if (puesto.equalsIgnoreCase(validar)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return mostrarTipoPersona() + "\n" +
                super.toString() +
                "numEmpleado: " + numEmpleado + "\n" +
                "edad: " + edad + "\n" +
                "cedProfecional: " + cedulaProfecional + "\n" +
                "puesto: " + puesto + "\n" +
                ensenar() + "\n" +
                evaluar() + "\n" +
                "----------------------------------";
    }

    @Override
    public String ensenar() {
        return "El maestro esta enseñando " ;
    }


    @Override
    public String evaluar() {
        return "El maestro esta evaluando " ;
    }

}