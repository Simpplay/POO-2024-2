package Tarea1;

import java.util.Scanner;

public class Ejercicio4 {

    /*
    *   Ejercicio 4
    *   A la mamá de Juan le preguntan su edad, y contesta: tengo 3 hijos, pregúntele a Juan su
    *   edad. Alberto tiene 2/3 de la edad de Juan, Ana tiene 4/3 de la edad de Juan y mi edad es
    *   la suma de las tres. Hacer un algoritmo que muestre la edad de los cuatro.
    *
    *   Nota: Se pudo haber guardado en una Collection<Persona> y luego iterado para mostrar
    *   las edades, haciendo uso de Persona#nombre.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la edad de Juan: ");
        Persona juan = new Persona("Juan", scanner.nextInt());
        Persona alberto = new Persona("Alberto", juan, 2/3f);
        Persona ana = new Persona("Ana", juan, 4/3f);
        Persona mama = new Persona("Mama", juan.edad + alberto.edad + ana.edad);

        System.out.printf("Las edades son: Juan: %d, Alberto: %d, Ana: %d, Mama: %d\n",
                juan.edad, alberto.edad, ana.edad, mama.edad);
    }

    public static class Persona {
        public final String nombre;
        public final int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public Persona(String nombre, Persona referencia, float rel) {
            this(nombre, (int) (referencia.edad * rel));
        }
    }
}
