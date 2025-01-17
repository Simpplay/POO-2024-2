package Tareas.Tarea4.Ejercicio1_Herencia.Libros;

public abstract class Novela  extends Libro {
    protected Genero genero;

    public Novela(String titulo, String autor, Genero genero) {
        super(titulo, autor);
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public enum Genero {
        HISTORIA,
        ROMANTICA,
        POLICIACA,
        REALISTA,
        CIENCIA_FICCION,
        AVENTURAS
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nGénero: " + getGenero();
    }
}
