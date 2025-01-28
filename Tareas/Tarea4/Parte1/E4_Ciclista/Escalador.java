package Tareas.Tarea4.Parte1.E4_Ciclista;

public class Escalador extends Ciclista {

    private float aceleracion;
    private float gradoRampa;

    public Escalador(int id, String nombre, float aceleracion, float gradoRampa) {
        super(id, nombre);
        this.aceleracion = aceleracion;
        this.gradoRampa = gradoRampa;
    }

    @Override
    public String imprimirTipo() {
        return "Es un escalador";
    }

    protected float getAceleracion() {
        return aceleracion;
    }

    protected void setAceleracion(float aceleracion) {
        this.aceleracion = aceleracion;
    }

    protected float getGradoRampa() {
        return gradoRampa;
    }

    protected void setGradoRampa(float gradoRampa) {
        this.gradoRampa = gradoRampa;
    }
}
