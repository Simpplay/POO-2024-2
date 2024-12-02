package Tarea2.Parte1;

import java.util.*;
import java.util.function.Predicate;

public class Resuelto15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 4; i++) {
            System.out.printf("Ingrese el peso de la esfera %s: ", i).println();
            Esfera.of(scanner.nextDouble());
        }

        Esfera diferente = Esfera.getDifferent();
        System.out.printf("La esfera diferente es: %s\nSu peso es %s que las demás.", diferente, diferente.isGreaterThanElse() ? "mayor" : "menor").println();
    }

    public static class Esfera implements Comparable<Esfera> {

        private static final HashMap<Esfera, Integer> frecuencias = new HashMap<>();

        public final double peso;
        private Esfera(double peso) {
            this.peso = peso;
        }

        public static Esfera of(double peso) {
            Esfera esfera = new Esfera(peso);
            frecuencias.put(esfera, frecuencias.getOrDefault(esfera, 0) + 1);
            return esfera;
        }

        public static Esfera getDifferent() {
            return frecuencias.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findAny().orElse(null);
        }

        public boolean isGreaterThanElse() {
            Esfera other = frecuencias.keySet().stream().filter(Predicate.not(this::equals)).findAny().orElse(null);
            if (other == null) return true;
            return peso > other.peso;
        }

        @Override
        public int compareTo(Esfera o) {
            return Double.compare(this.peso, o.peso);
        }

        @Override
        public String toString() {
            return String.valueOf(peso);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Esfera other) return peso == other.peso;
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + (int) (Double.doubleToLongBits(this.peso));
            return hash;
        }
    }
}
