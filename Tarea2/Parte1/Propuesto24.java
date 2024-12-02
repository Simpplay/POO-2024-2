package Tarea2.Parte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Propuesto24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.printf("Ingrese el peso de la esfera %s", i).println();
            Esfera.of(Double.parseDouble(scanner.nextLine()));
        }
        System.out.println("La de mayor peso es: " + Esfera.mayor());
    }

    public static class Esfera implements Comparable<Esfera> {
        private static final List<Esfera> esferas = new ArrayList<>();

        public final double peso;
        private Esfera(double peso) {
            this.peso = peso;
        }

        public static Esfera of(double peso) {
            Esfera esfera = new Esfera(peso);
            esferas.add(esfera);
            return esfera;
        }

        public static Esfera mayor() {
            return esferas.stream().max(Esfera::compareTo).orElse(null);
        }

        @Override
        public int compareTo(Esfera o) {
            return Double.compare(this.peso, o.peso);
        }

        @Override
        public String toString() {
            return String.valueOf(peso);
        }
    }

}
