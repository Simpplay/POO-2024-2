package Tarea1;

import java.util.Scanner;

public class Ejercicio17 {

    /*
    *   Ejercicio 17
    *   Dado el radio de un círculo. Haga un algoritmo que obtenga el área del círculo y la longitud
        de la circunferencia.
    *
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el radio del circulo: ");
        Circulo circulo = new Circulo(scanner.nextDouble());
        System.out.println("Area: " + circulo.area());
        System.out.println("Longitud: " + circulo.longitud());
    }

    public interface Figura {
        double area();
        double longitud();
    }

    public static class Circulo implements Figura {
        private final double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override public double area() {
            return Math.PI * Math.pow(radio, 2);
        }

        @Override public double longitud() {
            return 2 * Math.PI * radio;
        }
    }
}
