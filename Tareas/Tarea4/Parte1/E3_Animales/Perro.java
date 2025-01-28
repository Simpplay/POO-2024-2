package Tareas.Tarea4.Parte1.E3_Animales;

public class Perro extends Canidos {
    @Override
    public String getNombreCientifico() {
        return "Canis lupus familiaris";
    }

    @Override
    public String getSonido() {
        return "ladrido";
    }

    @Override
    public String getAlimentos() {
        return "carnivora";
    }

    @Override
    public String getHabitat() {
        return "domestico";
    }
}
