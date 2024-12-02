package Tarea2.Parte1;

import java.util.Scanner;

public class Resuelto10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero de inscripción: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        Estudiante est = new Estudiante(num, nombre);
        System.out.println("Ingrese el patrimonio: ");
        est.patrimonio = sc.nextDouble();
        System.out.println("Ingrese el estrato: ");
        est.estrato = sc.nextInt();
        System.out.println(est);
    }

    public static class Estudiante {
        public final long numero;
        public final String nombre;
        // Sería mejor con getters y setters, pero lo dejo así para ahorrar espacio
        public double patrimonio = 0;
        public int estrato = 1;
        public Estudiante(long numero, String nombre) {
            this.numero = numero;
            this.nombre = nombre;
        }

        public static final double VALOR_BASICO = 50000;

        public double valorMatricula() {
            return VALOR_BASICO + (patrimonio > 2000000 && estrato > 3 ? patrimonio * 0.03 : 0);
        }

        @Override
        public String toString() {
            return String.format("El estudiante con numero de inscripcion %s, y nombre %s, debe pagar $%s", numero, nombre, valorMatricula());
        }
    }
}
