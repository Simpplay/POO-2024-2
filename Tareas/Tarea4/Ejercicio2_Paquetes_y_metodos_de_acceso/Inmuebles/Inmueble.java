package Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles;

public abstract class Inmueble {

    protected int id;
    protected int area;
    protected String direccion;

    public Inmueble(int id, int area, String direccion) {
        this.id = id;
        this.area = area;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public int getArea() {
        return area;
    }

    public String getDireccion() {
        return direccion;
    }

    public abstract double valorArea();

    public double precioVenta() {
        return area * valorArea();
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                "\nÁrea: " + getArea() +
                "\nDirección: " + getDireccion() +
                "\nPrecio de venta: " + precioVenta();
    }
}
