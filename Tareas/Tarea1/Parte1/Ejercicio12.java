package Tareas.Tarea1.Parte1;

public class Ejercicio12 {

    /*
    *   Ejercicio 12
    *   Un empleado trabaja 48 horas en la semana a razón de $5.000 hora. El porcentaje de
    *   retención en la fuente es del 12,5% del salario bruto. Se desea saber cuál es el salario bruto,
    *   la retención en la fuente y el salario neto del trabajador.
     */

    public static void main(String[] args) {
        Empleado empleado = new Empleado(48, 5000);
        System.out.printf("Salario bruto: %.2f\nRetención: %.2f\nSalario neto: %.2f\n",
                empleado.salarioBruto, empleado.retencion, empleado.salarioNeto);
    }

    public static class Empleado {

        public static final float RET_PERCENT = 0.125f;

        public final float salarioBruto;
        public final float retencion;
        public final float salarioNeto;

        public Empleado(int horas, int valorHora) {
            this.salarioBruto = horas * valorHora;
            this.retencion = salarioBruto * RET_PERCENT;
            this.salarioNeto = salarioBruto - retencion;
        }
    }
}
