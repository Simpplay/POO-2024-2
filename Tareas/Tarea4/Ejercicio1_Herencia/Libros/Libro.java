package Tareas.Tarea4.Ejercicio1_Herencia.Libros;

public abstract class Libro {

    protected String titulo;
    protected String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    abstract float getPrecio();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo() +
                "\nAutor: " + getAutor() +
                "\nPrecio: " + getPrecio();
    }
}
