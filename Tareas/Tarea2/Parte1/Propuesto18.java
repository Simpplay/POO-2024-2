package Tareas.Tarea2.Parte1;

import java.util.Scanner;

public class Propuesto18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el codigo del empleado: ");
        String codigo = scanner.next();
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = scanner.next();
        System.out.println("Ingrese la cantidad de horas trabajadas: ");
        int horas = scanner.nextInt();
        System.out.println("Ingrese el valor de cada hora: ");
        float valor = scanner.nextFloat();
        System.out.println("Ingrese el porcentaje de retencion de la fuente: ");
        float retencion = scanner.nextFloat();
        Empleado empleado = new Empleado(codigo, nombre, horas, valor, retencion);
        System.out.println(empleado);
    }

    private static class Empleado {
        public final String codigo;
        public final String nombre;
        public final int horasTrabajadas;
        public final float valorHorasTrabajadas;
        public final float porcentajeRetencionFuente;
        public Empleado(String codigo, String nombre, int horasTrabajadas, float valorHorasTrabajadas, float porcentajeRetencionFuente) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.horasTrabajadas = horasTrabajadas;
            this.valorHorasTrabajadas = valorHorasTrabajadas;
            this.porcentajeRetencionFuente = porcentajeRetencionFuente;
        }

        public float salarioBruto() {
            return porcentajeRetencionFuente * horasTrabajadas;
        }

        public float salarioNeto() {
            return salarioBruto() - (salarioBruto() * porcentajeRetencionFuente);
        }

        @Override
        public String toString() {
            return String.format(
                    """
                    Codigo: %s,
                    Nombre: %s,
                    Salario bruto: %s,
                    Salario neto: %s
                    """, this.codigo, this.nombre, this.salarioBruto(), this.salarioNeto()
            );
        }
    }

}
