package Tareas.Tarea4.Parte1.E3_Animales;

public abstract class Animal {

    public abstract String getNombreCientifico();
    public abstract String getSonido();
    public abstract String getAlimentos();
    public abstract String getHabitat();

    @Override
    public String toString() {
        return "Animal{" +
                "nombreCientifico='" + getNombreCientifico() + '\'' +
                ", sonido='" + getSonido() + '\'' +
                ", alimentos='" + getAlimentos() + '\'' +
                ", habitat='" + getHabitat() + '\'' +
                '}';
    }
}
