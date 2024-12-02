package Tarea2.Parte1;

import java.util.Scanner;

public class Propuesto22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrse el nombre, salario por hora y horas trabajadas");
        System.out.println(new Empleado(scanner.nextLine(), Double.parseDouble(scanner.nextLine()), Integer.parseInt(scanner.nextLine())));
    }

    public record Empleado(String nombre, double salarioPorHora, int horasTrabajadas) {
        public static double salarioMensual(Empleado empleado) {
            return empleado.salarioPorHora * empleado.horasTrabajadas;
        }

        @Override
        public String toString() {
            double salario = salarioMensual(this);
            return nombre + (salario <= 450000 ? "" : String.format("\n$%s", salario));
        }
    }
}
