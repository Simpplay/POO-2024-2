package Tarea2.Parte1;

import java.util.Scanner;

public class Resuelto13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Valor de compra: ");
        double valor = Double.parseDouble(scanner.nextLine());
        System.out.println("Color de bolita: ");
        String color = scanner.nextLine();
        Bolitas bolita = Bolitas.valueOf(color);

        System.out.printf("El cliente debe pagar: $%s", bolita.aplicarDescuento(valor)).println();
    }

    private enum Bolitas {
        BLANCA(0),
        VERDE(0.1),
        AMARILLA(0.25),
        AZUL(0.5),
        ROJA(1);

        private final double descuento;
        Bolitas(double descuento) {
            this.descuento = descuento;
        }

        public double aplicarDescuento(double valor) {
            return valor - (valor * descuento);
        }
    }


}
