package Tareas.Tarea3.Parte2;

public class Trapecio implements Figura {

    private final double a;
    private final double b;
    private final double c;
    private final double d;

    private final TrianguloRectangulo trianguloInterno;
    public Trapecio(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        double n = ((d - b) / 2);
        this.trianguloInterno = new TrianguloRectangulo(n, Math.sqrt((a * a) - (n * n)));
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public TrianguloRectangulo getTrianguloInterno() {
        return trianguloInterno;
    }

    @Override
    public double area() {
        return (trianguloInterno.getAltura() / 2) * (b + d);
    }

    @Override
    public double perimetro() {
        return a + b + c + d;
    }

    @Override
    public String toString() {
        return """
                Trapecio con:
                A = %.2f
                B = %.2f
                C = %.2f
                D = %.2f
                Área = %.2f
                Perímetro = %.2f
                """.formatted(a, b, c, d, area(), perimetro());
    }
}
