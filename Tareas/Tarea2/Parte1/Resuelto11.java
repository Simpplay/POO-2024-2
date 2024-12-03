package Tareas.Tarea2.Parte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resuelto11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Entero> enteros = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            System.out.println("Digite el siguiente número: ");
            enteros.add(new Entero(Integer.parseInt(scanner.nextLine())));
        }
        System.out.printf("El mayor entre %s, es: %s", enteros, enteros.stream().sorted().findFirst().orElse(enteros.getFirst())).println();
    }

    public static class Entero implements Comparable<Entero> {
        public final int valor;
        public Entero(int valor) {
            this.valor = valor;
        }

        @Override
        public int compareTo(Entero o) {
            return -Integer.compare(this.valor, o.valor);
        }

        @Override
        public String toString() {
            return String.valueOf(valor);
        }
    }
}
