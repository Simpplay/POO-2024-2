package Tareas.Tarea5.Parte1.Notas;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan"));
        estudiantes.add(new Estudiante("Pedro"));
        estudiantes.add(new Estudiante("María"));

        MainUI mainUI = new MainUI(estudiantes);
    }
}
