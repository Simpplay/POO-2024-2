package Tareas.Tarea4.Parte1.E4_Ciclista;

public class PruebaCiclista {

    public static void main(String... args) {
        Equipo equipo1 = new Equipo("Sky","Estados Unidos");
        Velocista velocista1 = new Velocista(123979, "Geraint Thomas",
                320, 25);
        Escalador escalador1 = new Escalador(123980, "Egan Bernal",
                25, 10);
        Contrarrelojista contrarrelojista1 = new Contrarrelojista(123981,
                "Jonathan Castroviejo", 120);
        equipo1.addCiclista(velocista1);
        equipo1.addCiclista(escalador1);
        equipo1.addCiclista(contrarrelojista1);
        velocista1.setTiempo(365);
        escalador1.setTiempo(385);
        contrarrelojista1.setTiempo(370);
        equipo1.calcularTotalTiempo();
        equipo1.imprimir();
        equipo1.listarEquipo();
    }
    
}
