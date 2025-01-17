package Tareas.Tarea4.Parte1.E2_Inmuebles.Vivienda;

public class Independiente extends AbstractCasaUrbana {
    public Independiente(int id, int area, String direccion, int habitaciones, int banos, int pisos) {
        super(id, area, direccion, habitaciones, banos, pisos);
    }

    @Override
    public double valorArea() {
        return 3000000;
    }
}
