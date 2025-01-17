package Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Vivienda;

public class CasaRural extends AbstractCasa {

    protected float distancia;
    protected float altitud;

    public CasaRural(int id, int area, String direccion, int habitaciones, int banos,
                     int pisos, float distancia, float altitud) {
        super(id, area, direccion, habitaciones, banos, pisos);

        this.distancia = distancia;
        this.altitud = altitud;
    }

    public float getDistancia() {
        return distancia;
    }

    public float getAltitud() {
        return altitud;
    }

    @Override
    public double valorArea() {
        return 1500000;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDistancia: " + getDistancia() +
                "\nAltitud: " + getAltitud();
    }
}
