package Tareas.Tarea5.Parte1.Figuras;

public class Test {

    public static void main(String[] args) {
        Figura[] figuras = new Figura[] {
            new Esfera(), new Cilindro(), new Piramide()
        };

        MainUI mainUI = new MainUI(figuras);
    }

}
