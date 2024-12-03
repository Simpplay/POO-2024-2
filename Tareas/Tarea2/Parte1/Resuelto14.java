package Tareas.Tarea2.Parte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resuelto14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.printf("Ingrese las ventas del departamento: %s", i).println();
            Departamento.crearDepartamento(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println("Ingrese el salario de los vendedores: ");
        Departamento.SALARIO_BASE = Double.parseDouble(scanner.nextLine());

        for (int i = 0; i < Departamento.departamentos.size(); i++) {
            Departamento departamento = Departamento.departamentos.get(i);
            System.out.printf("El salario del departamento %s, es: $%s", i + 1, departamento.getSalario()).println();
        }
    }

    public static class Departamento {
        public static double SALARIO_BASE = 0;
        public static final List<Departamento> departamentos = new ArrayList<>();

        public final int ventas;
        private Departamento(int ventas) {
            this.ventas = ventas;
        }

        public static Departamento crearDepartamento(int ventas) {
            Departamento departamento = new Departamento(ventas);
            departamentos.add(departamento);
            return departamento;
        }

        public static int ventasTotales() {
            return departamentos.stream().map(dep -> dep.ventas).reduce(0, Integer::sum);
        }

        public double getSalario() {
            return SALARIO_BASE + ((double) ventas / ventasTotales() > 0.33 ? SALARIO_BASE * 0.2 : 0);
        }
    }

}
