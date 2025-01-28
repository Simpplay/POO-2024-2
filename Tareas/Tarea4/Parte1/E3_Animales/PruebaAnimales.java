package Tareas.Tarea4.Parte1.E3_Animales;

public class PruebaAnimales {

    public static void main(String... args) {
        Animal[] animales = {
            new Leon(),
            new Lobo(),
            new Gato(),
            new Perro()
        };

        for (Animal animal : animales) {
            System.out.println(animal);
        }
    }
}
