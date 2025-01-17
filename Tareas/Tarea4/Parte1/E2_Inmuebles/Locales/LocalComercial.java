package Tareas.Tarea4.Parte1.E2_Inmuebles.Locales;

public class LocalComercial extends AbstractLocales{
    protected boolean interno;
    protected String centroComercial;

    public LocalComercial(int id, int area, String direccion, boolean interno, String centroComercial) {
        super(id, area, direccion);
        this.interno = interno;
        this.centroComercial = centroComercial;
    }

    public boolean isInterno() {
        return interno;
    }

    public String getCentroComercial() {
        return centroComercial;
    }

    @Override
    public double valorArea() {
        return 3000000;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nInterno: " + (isInterno() ? "Sí" : "No") +
                "\nCentro comercial: " + getCentroComercial();
    }
}
