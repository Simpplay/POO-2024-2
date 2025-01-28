package Tareas.Tarea4.Parte1.E4_Ciclista;

public abstract class Ciclista {

    private int id;
    private String nombre;
    private double tiempo;

    public Ciclista(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo = 0;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected double getTiempo() {
        return tiempo;
    }

    protected void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public abstract String imprimirTipo();
}
