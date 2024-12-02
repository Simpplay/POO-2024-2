package Tarea2.Parte1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Propuesto23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los valores de a, b, c");
        Ecuacion ecuacion = new Ecuacion(Double.parseDouble(scanner.nextLine()),
                Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));
        System.out.println("Las soluciones son: ");
        for (Double sol : ecuacion.soluciones()) {
            System.out.println(sol.toString());
        }
    }

    public static class Ecuacion {
        public double a;
        public double b;
        public double c;
        public Ecuacion(double a, double b, double c) {
            if (a == 0) throw new IllegalArgumentException("El valor a no puede ser 0");

            this.a = a;
            this.b = b;
            this.c = c;
        }

        public Set<Double> soluciones() {
            Set<Double> res = new HashSet<>();

            double sqrt = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
            res.add((-b + sqrt) / (2 * a));
            res.add((-b - sqrt) / (2 * a));

            return res;
        }
    }

}
