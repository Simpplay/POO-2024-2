package Tareas.Tarea3.Parte1;

public class Propuesto18 extends MDIElement<Propuesto18.Empleado> {
    public Propuesto18() {
        super("Propuesto 18", new Argument<?>[]{
                new Argument<>("Codigo", String.class),
                new Argument<>("Nombre", String.class),
                new Argument<>("Horas trabajadas", int.class),
                new Argument<>("Valor hora", float.class),
                new Argument<>("Retencion (%)", float.class)
        }, Empleado.class);
    }

    public record Empleado(String codigo, String nombre, int horasTrabajadas, float valorHorasTrabajadas,
                           float porcentajeRetencionFuente) {

        public float salarioBruto() {
                return horasTrabajadas * valorHorasTrabajadas;
            }

            public float salarioNeto() {
                return salarioBruto() * (1 - porcentajeRetencionFuente);
            }

            @Override
            public String toString() {
                return String.format(
                        """
                                Código: %s
                                Nombre: %s
                                Salario bruto: %.2f
                                Salario neto: %.2f
                                """,
                        codigo, nombre, salarioBruto(), salarioNeto()
                );
            }
        }
}