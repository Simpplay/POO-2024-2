package Tareas.Tarea4.Parte1.E2_Inmuebles.Vivienda;

public class Apartaestudio extends AbstractApartamento {
    public Apartaestudio(int id, int area, String direccion, int banos) {
        super(id, area, direccion, 1, banos);
    }

    @Override
    public double valorArea() {
        return 1500000;
    }
}
