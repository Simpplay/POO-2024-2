package Tareas.Tarea4.Ejercicio1_Herencia.Libros;

public abstract class LibroUNAL extends LibroDeCurso {
    private String facultad;

    public LibroUNAL(String titulo, String autor, String curso, String facultad) {
        super(titulo, autor, curso);
        this.facultad = facultad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nFacultad: " + getFacultad();
    }
}
