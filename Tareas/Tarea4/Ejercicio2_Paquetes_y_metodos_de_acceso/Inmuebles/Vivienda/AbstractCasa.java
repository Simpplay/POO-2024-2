package Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Vivienda;

public abstract class AbstractCasa extends AbstractVivienda {

    protected int pisos;

    public AbstractCasa(int id, int area, String direccion, int habitaciones, int banos, int pisos) {
        super(id, area, direccion, habitaciones, banos);
        this.pisos = pisos;
    }

    public int getPisos() {
        return pisos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPisos: " + getPisos();
    }
}
