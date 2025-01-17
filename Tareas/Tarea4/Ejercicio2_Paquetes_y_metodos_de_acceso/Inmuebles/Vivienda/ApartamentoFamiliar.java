package Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Vivienda;

public class ApartamentoFamiliar extends AbstractApartamento{

    protected int admin;
    public ApartamentoFamiliar(int id, int area, String direccion, int habitaciones, int banos, int admin) {
        super(id, area, direccion, habitaciones, banos);
        this.admin = admin;
    }

    public int getAdmin() {
        return admin;
    }

    @Override
    public double valorArea() {
        return 2000000;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: Apartamento Familiar" +
                "\nAdministración: " + getAdmin();
    }
}
