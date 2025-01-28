package Tareas.Tarea4.Parte1.E4_Ciclista;

public class Velocista extends Ciclista {
    private double potencia;
    private double velocidad;

    public Velocista(int id, String nombre, double potencia, double velocidad) {
        super(id, nombre);
        this.potencia = potencia;
        this.velocidad = velocidad;
    }

    @Override
    public String imprimirTipo() {
        return "Es un velocista";
    }

    protected double getPotencia() {
        return potencia;
    }

    protected void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    protected double getVelocidad() {
        return velocidad;
    }

    protected void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
}
