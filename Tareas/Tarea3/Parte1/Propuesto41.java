package Tareas.Tarea3.Parte1;

import java.util.Arrays;
import java.util.List;

public class Propuesto41 extends MDIElement<Propuesto41.GrupoDeNumeros> {
    public Propuesto41() {
        super("Propuesto 41", new Argument[]{
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
            this.valores = Arrays.stream(valores.replaceAll("\\s+", "").split(","))
                    .map(Double::parseDouble)
                    .filter(x -> x >= 0) // El enunciado dice que los valores son positivos
                    .toList();
        }

        public double max() {
            return valores.stream().max(Double::compare).orElseThrow();
        }

        @Override
        public String toString() {
            return """
                    Grupo de Numeros: %s
                    Mayor: %s
                    """.formatted(valores, max());
        }
    }
}
