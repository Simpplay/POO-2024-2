package Tareas.Tarea1.Parte1;

public class Ejercicio5 {

    /*
    *   Ejercicio 5
    *   Hacer un seguimiento (prueba de escritorio) del siguiente grupo de instrucciones.
    *
    * --------------------------------------------
    * | SUMA       |       X        |      Y     |
    * --------------------------------------------
    * | 0          |       20       |      40    |
    * | 20         |       40       |      40    |
    * | 20         |      1620      |      40    |
    * | 60.5       |      1620      |      40    |
    * |--------------------------------------------
     */
    public static void main(String[] args) {
        double SUMA = 0;
        double X = 20;
        SUMA = SUMA + X;
        double Y = 40;
        X = X + Math.pow(Y, 2);
        SUMA = SUMA + X / Y;
        System.out.println("EL VALOR DE LA SUMA ES: " + SUMA);
    }
}
