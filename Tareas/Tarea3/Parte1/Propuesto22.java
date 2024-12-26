package Tareas.Tarea3.Parte1;

public class Propuesto22 extends MDIElement<Propuesto22.Empleado> {
    public Propuesto22() {
        super("Propuesto 22", new Argument[]{
                new Argument<>("Nombre", String.class),
                new Argument<>("Salario por hora", double.class),
                new Argument<>("Horas trabajadas", int.class)
        }, Empleado.class);
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
