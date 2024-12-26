package Tareas.Tarea3.Parte1;

import java.util.Arrays;
import java.util.List;

public class Propuesto40 extends MDIElement<Propuesto40.GrupoDeNumeros> {
    public Propuesto40() {
        super("Propuesto 40", new Argument[]{
                new Argument<>("Valores separados por coma (ejm: 1, 2, 3, 4)", String.class)
        }, GrupoDeNumeros.class);
    }

    public static class GrupoDeNumeros {
        private final List<Double> valores;

        /**
         * Recibe una cadena de texto con los valores de los enteros separados por comas.
         * <p>Ejm: "1, 2, 3, 4, 5"
         * @param valores Cadena de texto con los valores de los enteros separados por comas.
         */
        public GrupoDeNumeros(String valores) {
            this(Arrays.stream(valores.replaceAll("\\s+", "").split(","))
                    .map(Double::parseDouble)
                    .filter(x -> x >= 0) // El enunciado dice que los valores son positivos
                    .toList());
        }

        public GrupoDeNumeros(List<Double> valores) {
            this.valores = valores;
        }

        public GrupoDeNumeros sqrt() {
            return new GrupoDeNumeros(valores.stream().map(Math::sqrt).toList());
        }

        public GrupoDeNumeros pow2() {
            return new GrupoDeNumeros(valores.stream().map(x -> x * x).toList());
        }

        public GrupoDeNumeros pow3() {
            return new GrupoDeNumeros(valores.stream().map(x -> x * x * x).toList());
        }

        @Override
        public String toString() {
            return """
                    Grupo de Numeros: %s
                    Raiz cuadrada: %s
                    Potencia al cuadrado: %s
                    Potencia al cubo: %s
                    """.formatted(valores, sqrt().valores, pow2().valores, pow3().valores);
        }
    }
}
