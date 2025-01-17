package Tareas.Tarea4.Ejercicio1_Herencia.Libros;

public class PruebaLibros {

    public static void main(String[] args) {
        EjerciciosPOO ejerciciosPOO = new EjerciciosPOO();
        System.out.println(ejerciciosPOO);

        CienAnosDeSoledad cienAnosDeSoledad = new CienAnosDeSoledad();
        System.out.println(cienAnosDeSoledad);
    }

    /**
     * Clase que representa un libro de ejercicios de programación orientada a objetos.
     */
    public static class EjerciciosPOO extends LibroUNAL {
        public EjerciciosPOO() {
            super("Ejercicios de Programación Orientada a Objetos con Java y UML",
                    "Leonardo Bermón Angarita",
                    "Programación Orientada a Objetos",
                    "Minas");
        }

        @Override
        float getPrecio() {
            return 50000;
        }
    }

    /**
     * Clase que representa la novela "Cien años de soledad" de Gabriel García Márquez.
     */
    public static class CienAnosDeSoledad extends Novela {
        public CienAnosDeSoledad() {
            super("Cien años de soledad",
                    "Gabriel García Márquez",
                    Genero.REALISTA);
        }

        @Override
        float getPrecio() {
            return 100000;
        }
    }
}
