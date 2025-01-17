package Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Locales;

public class Oficina extends AbstractLocales{
    protected boolean gobierno;

    public Oficina(int id, int area, String direccion, boolean gobierno) {
        super(id, area, direccion);
        this.gobierno = gobierno;
    }

    public boolean isGobierno() {
        return gobierno;
    }

    @Override
    public double valorArea() {
        return 3500000;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nGobierno: " + (isGobierno() ? "Sí" : "No");
    }
}
