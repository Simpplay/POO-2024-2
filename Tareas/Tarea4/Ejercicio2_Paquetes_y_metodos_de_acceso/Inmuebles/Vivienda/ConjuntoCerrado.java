package Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Vivienda;

public class ConjuntoCerrado extends AbstractCasaUrbana {
    protected int admin;
    protected boolean comunes;

    public ConjuntoCerrado(int id, int area, String direccion, int habitaciones, int banos,
                           int pisos, int admin, boolean comunes) {
        super(id, area, direccion, habitaciones, banos, pisos);
        this.admin = admin;
        this.comunes = comunes;
    }

    public int getAdmin() {
        return admin;
    }

    public boolean isComunes() {
        return comunes;
    }

    @Override
    public double valorArea() {
        return 2500000;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nAdministración: " + getAdmin() +
                "\nZonas comunes: " + (isComunes() ? "Sí" : "No");
    }
}
