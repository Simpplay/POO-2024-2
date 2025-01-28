package Tareas.Tarea4.Parte1.E4_Ciclista;

import java.util.HashMap;
import java.util.Map;

public class Equipo {

    private String nombre;
    private String pais;
    private double tiempoTotal;
    private final Map<Integer, Ciclista> ciclistas = new HashMap<>();

    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected String getPais() {
        return pais;
    }

    protected void setPais(String pais) {
        this.pais = pais;
    }

    protected double getTiempoTotal() {
        return tiempoTotal;
    }

    protected void setTiempoTotal(double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public void addCiclista(Ciclista ciclista) {
        this.ciclistas.put(ciclista.getId(), ciclista);
    }

    public void calcularTotalTiempo() {
        this.tiempoTotal =
                this.ciclistas.values().stream().mapToDouble(Ciclista::getTiempo).sum();
    }

    public void imprimir() {
        System.out.println("Nombre del equipo: " + this.nombre);
        System.out.println("Pais del equipo: " + this.pais);
        System.out.println("Tiempo total del equipo: " + this.tiempoTotal);
    }

    protected String getCiclistaString(Ciclista ciclista) {
        return "Nombre del ciclista: " + ciclista.getNombre() + "\n" +
                "ID del ciclista: " + ciclista.getId() + "\n" +
                "Tiempo del ciclista: " + ciclista.getTiempo() + "\n" +
                ciclista.imprimirTipo();
    }

    public void listarEquipo() {
        this.ciclistas.values().forEach(ciclista -> System.out.println(getCiclistaString(ciclista)));
    }

    public void imprimirCiclista(int id) {
        Ciclista ciclista = this.ciclistas.getOrDefault(id, null);
        if (ciclista != null) System.out.println(getCiclistaString(ciclista));
        else System.out.println("No se encontró el ciclista");
    }
}
