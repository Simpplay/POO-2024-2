package Tarea1;

import java.util.Scanner;

public class Ejercicio14 {

    /*
    *   Ejercicio 14
    *   Elabore un algoritmo que lea un número y obtenga su cuadrado y su cubo.
    *
    *   Nota: Hecho más complicada para usar POO.
    *   Además, la clase 'Numero' puede ser convertida en Record.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        Numero n = new Numero(numero);
        System.out.println("El cuadrado de " + numero + " es " + n.cuadrado().valor);
        System.out.println("El cubo de " + numero + " es " + n.cubo().valor);
    }

    public static class Numero {
        public final int valor;
        public Numero(int valor) {
            this.valor = valor;
        }

        public Numero cuadrado() {
            return new Numero(valor * valor);
        }

        public Numero cubo() {
            return new Numero(valor * valor * valor);
        }
    }
}
