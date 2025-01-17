package Tareas.Tarea4.Ejercicio1_Herencia.Libros;

public abstract class LibroDeCurso extends Libro {
    private String curso;

    public LibroDeCurso(String titulo, String autor, String curso) {
        super(titulo, autor);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCurso: " + getCurso();
    }
}
