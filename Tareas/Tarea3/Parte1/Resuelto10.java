package Tareas.Tarea3.Parte1;

public class Resuelto10 extends MDIElement<Resuelto10.Estudiante> {
    public Resuelto10() {
        super("Resuelto 10", new Argument[]{
                new Argument<>("Numero", long.class),
                new Argument<>("Nombre", String.class),
                new Argument<>("Patrimonio", double.class),
                new Argument<>("Estrato", int.class)
        }, Estudiante.class);
    }

    public static class Estudiante {
        public final long numero;
        public final String nombre;
        public double patrimonio;
        public int estrato;
        public Estudiante(long numero, String nombre, double patrimonio, int estrato) {
            this.numero = numero;
            this.nombre = nombre;
            this.patrimonio = patrimonio;
            this.estrato = estrato;
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
