package Tareas.Tarea3.Parte1;

import java.util.HashSet;
import java.util.Set;

public class Propuesto23 extends MDIElement<Propuesto23.Ecuacion> {

    public Propuesto23() {
        super("Propuesto 23", new Argument[]{
                new Argument<>("a", double.class),
                new Argument<>("b", double.class),
                new Argument<>("c", double.class)
        }, Ecuacion.class);
    }

    public static class Ecuacion {
        public double a;
        public double b;
        public double c;
        public Ecuacion(double a, double b, double c) {
            if (a == 0) throw new IllegalArgumentException("El valor a no puede ser 0");

            this.a = a;
            this.b = b;
            this.c = c;
        }

        public Set<Double> soluciones() {
            Set<Double> res = new HashSet<>();

            double sqrt = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
            res.add((-b + sqrt) / (2 * a));
            res.add((-b - sqrt) / (2 * a));

            return res;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Las soluciones son: ");
            for (Double sol : this.soluciones()) {
                stringBuilder.append(sol).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            return stringBuilder.toString();
        }
    }

}
