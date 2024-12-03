package Tareas.Tarea2.Parte1;

import java.util.Scanner;

public class Resuelto7 {

    /**
     * Usando POO, aplicando el método estatico {@link Double#compare(double, double)}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar los valores A y B");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        
        int comparision = Double.compare(a, b);
        if (comparision > 0) System.out.println("A es mayor a B");
        else if (comparision < 0) System.out.println("A es menor que B");
        else System.out.println("A es igual a A");
    }
}
