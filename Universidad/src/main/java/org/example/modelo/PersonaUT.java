package org.example.modelo;

public abstract class PersonaUT {
    private String nombre;
    private String curp;
    public PersonaUT(){}

    public PersonaUT(String nombre, String curp) {
        setNombre(nombre);
        setCurp(curp);
    }

    public String getNombre() {
        if (this.nombre == null) {
            return "SIN NOMBRE";
        }
        return this.nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty() || nombre.isBlank()){
            System.out.println("Error el nombre es requerido");
        } else {
            this.nombre = nombre;
        }

    }

    public String getCurp() {
        if (this.curp == null) {
            return "SIN CURP";
        }
        return this.curp.toUpperCase();
    }

    public void setCurp(String curp) {
        if(curp.isBlank() || curp.isEmpty()){
            System.out.println("La CURP es requerida");

        }else {
            this.curp = curp;
        }
    }

    public abstract String mostrarTipoPersona();

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\n" +
                "CURP: " + getCurp() + "\n";
    }
}