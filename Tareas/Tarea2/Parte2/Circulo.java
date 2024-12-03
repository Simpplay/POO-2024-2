package Tareas.Tarea2.Parte2;

public class Circulo implements Figura {
    private final double radius;

    public Circulo(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * radius;
    }
}
