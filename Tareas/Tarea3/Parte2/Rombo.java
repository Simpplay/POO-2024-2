package Tareas.Tarea3.Parte2;

public class Rombo extends Cuadrado {
    public Rombo(double lado) {
        super(lado);
    }

    @Override
    public String toString() {
        return """
                Rombo con:
                - Lado: %.2f
                - Area: %.2f
                - Perimetro: %.2f
                """.formatted(altura, area(), perimetro());
    }
}
