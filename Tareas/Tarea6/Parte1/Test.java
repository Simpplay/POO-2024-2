package Tareas.Tarea6.Parte1;

public class Test {

    public static void main(String[] args) {
        try {
            Archivo archivo = new Archivo("contactos.txt");
            MainUI mainUI = new MainUI(archivo);
            mainUI.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
