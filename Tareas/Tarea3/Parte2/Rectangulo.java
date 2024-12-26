package Tareas.Tarea3.Parte2;

public class Rectangulo implements Figura {
    protected final double base;
    protected final double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public double perimetro() {
        return 2 * (base + altura);
    }

    @Override
    public String toString() {
        return """
                Rectangulo con:
                - Base: %.2f
                - Altura: %.2f
                - Area: %.2f
                - Perimetro: %.2f
                """.formatted(base, altura, area(), perimetro());
    }
}
