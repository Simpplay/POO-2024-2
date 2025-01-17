package Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Vivienda;

public class Apartaestudio extends AbstractApartamento {
    public Apartaestudio(int id, int area, String direccion, int banos) {
        super(id, area, direccion, 1, banos);
    }

    @Override
    public double valorArea() {
        return 1500000;
    }
}
