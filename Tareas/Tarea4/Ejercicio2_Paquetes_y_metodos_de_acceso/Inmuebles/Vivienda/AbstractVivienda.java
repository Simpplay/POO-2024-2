package Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Vivienda;

import Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Inmueble;

public abstract class AbstractVivienda extends Inmueble {

    protected int habitaciones;
    protected int banos;

    public AbstractVivienda(int id, int area, String direccion, int habitaciones, int banos) {
        super(id, area, direccion);
        this.habitaciones = habitaciones;
        this.banos = banos;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public int getBanos() {
        return banos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nHabitaciones: " + getHabitaciones() +
                "\nBaños: " + getBanos();
    }
}
