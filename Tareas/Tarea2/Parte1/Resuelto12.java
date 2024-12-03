package Tareas.Tarea2.Parte1;

import java.util.Scanner;

public class Resuelto12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el numero de horas trabajadas: ");
        int horasTrabajadas = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el valor de cada hora: ");
        double cadHora = Double.parseDouble(scanner.nextLine());

        System.out.printf("El trabajador %s, devengó: $%s", nombre, TrabajadorUtils.salario(horasTrabajadas, cadHora)).println();
    }

    public static class TrabajadorUtils {

        public static final int HORAS_NORMALES = 40;
        public static final int HORAS_DOBLE = 8;

        public static double salario(int horas, double valorPorHora) {
            double normales = Math.min(HORAS_NORMALES, horas);
            double triples = Math.max(0, horas - (HORAS_NORMALES + HORAS_DOBLE));
            double dobles = Math.max(0, horas - triples - HORAS_NORMALES);
            return (normales * valorPorHora) + (dobles * valorPorHora * 2) + (triples * valorPorHora * 3);
        }
    }

}
