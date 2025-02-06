package Tareas.Tarea5.Parte1.Notas;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private final String nombre;
    private final List<Double> notas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public void eliminarNota(int index) {
        if (index >= 0 && index < notas.size()) {
            notas.remove(index);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
