package Tareas.Tarea2.Parte1;

import java.util.Scanner;

public class Propuesto21 {

    private interface Figura {
        double perimetro();
        double area();
        double altura();
        double semiPerimetro();
    }

    private static class Triangulo implements Figura {
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
        public double semiPerimetro() {
            return perimetro() / 2;
        }

        @Override
        public double area() {
            return (altura() * b) / 2;
        }

        @Override
        public double altura() {
            double s = semiPerimetro();
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            return (2 * area) / b;
        }

        @Override
        public String toString() {
            return String.format("""
                Perimetro: %s,
                SemiPerimetro: %s,
                Altura: %s,
                Area: %s
                """, perimetro(), semiPerimetro(), altura(), area());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los lados del triangulo: ");
        Triangulo triangulo = new Triangulo(scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat());
        System.out.println(triangulo);
    }
}
