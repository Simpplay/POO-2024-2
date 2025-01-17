package Tareas.Tarea4.Parte1.E2_Inmuebles;

import Tareas.Tarea4.Parte1.E2_Inmuebles.Vivienda.Apartaestudio;
import Tareas.Tarea4.Parte1.E2_Inmuebles.Vivienda.ApartamentoFamiliar;

public class TestInmuebles {

    public static void main(String... args) {
        ApartamentoFamiliar apto1 = new ApartamentoFamiliar(103067,120,
                "Avenida Santander 45-45",3,2,200000);
        System.out.println(apto1);

        System.out.println("-------------------------------------------------");

        Apartaestudio aptestudio1 = new Apartaestudio(12354,50,"Avenida Caracas 30-15",1);
        System.out.println(aptestudio1);
    }

}
