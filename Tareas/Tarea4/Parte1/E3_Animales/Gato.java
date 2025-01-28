package Tareas.Tarea4.Parte1.E3_Animales;

public class Gato extends Felinos {
    @Override
    public String getNombreCientifico() {
        return "Felis silvestris catus";
    }

    @Override
    public String getSonido() {
        return "maullido";
    }

    @Override
    public String getAlimentos() {
        return "ratones";
    }

    @Override
    public String getHabitat() {
        return "domestico";
    }
}
