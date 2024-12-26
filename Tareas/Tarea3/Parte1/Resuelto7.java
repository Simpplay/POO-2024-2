package Tareas.Tarea3.Parte1;

public class Resuelto7 extends MDIElement<Resuelto7.Comparador> {

    public Resuelto7() {
        super("Resuelto 7", new Argument<?>[] {
            new Argument<>("A", double.class),
            new Argument<>("B", double.class)
        }, Comparador.class);
    }

    public static class Comparador {
        double a, b;

        public Comparador(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public int compare() {
            if (a > b) return 1;
            else if (a < b) return -1;
            return 0;
        }

        @Override
        public String toString() {
            return "%s es %s a %s".formatted(a, switch (compare()) {
                case 1 -> "mayor";
                case -1 -> "menor";
                default -> "igual";
            }, b);
        }
    }
}
