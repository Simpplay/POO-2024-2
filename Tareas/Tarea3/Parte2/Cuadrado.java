package Tareas.Tarea3.Parte2;

public class Cuadrado extends Rectangulo {
    public Cuadrado(double lado) {
        super(lado, lado);
    }

    @Override
    public String toString() {
        return """
                Cuadrado con:
                - Lado: %.2f
                - Area: %.2f
                - Perimetro: %.2f
                """.formatted(base, area(), perimetro());
    }
}
