package Tarea2.Parte1;

import java.util.Scanner;

public class Propuesto19 {

    private interface Figura {
        double perimetro();
        double altura();
        double area();
    }

    private abstract static class Triangulo implements Figura {
        protected final float a;
        protected final float b;
        protected final float c;
        public Triangulo(float a, float b, float c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double perimetro() {
            return a + b + c;
        }

        @Override
        public double altura() {
            return Math.sqrt(((4 * Math.pow(c, 2)) - Math.pow(b, 2)) / 4);
        }

        @Override
        public double area() {
            return (altura() * b) / 2;
        }

        @Override
        public String toString() {
            return String.format("""
                    Perimetro: %s,
                    Altura: %s,
                    Area: %s
                    """, perimetro(), altura(), area());
        }
    }

    public static class TrianguloEquilatero extends Triangulo {
        public TrianguloEquilatero(float a) {
            super(a, a, a);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor del lado: ");
        Triangulo triangulo = new TrianguloEquilatero(scanner.nextFloat());
        System.out.println(triangulo);
    }
}
