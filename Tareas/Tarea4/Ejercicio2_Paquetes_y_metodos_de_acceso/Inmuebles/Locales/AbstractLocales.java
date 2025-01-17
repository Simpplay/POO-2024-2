package Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Locales;

import Tareas.Tarea4.Ejercicio2_Paquetes_y_metodos_de_acceso.Inmuebles.Inmueble;

public abstract class AbstractLocales extends Inmueble {
    public AbstractLocales(int id, int area, String direccion) {
        super(id, area, direccion);
    }
}
