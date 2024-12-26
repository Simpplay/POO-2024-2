package Tareas.Tarea3.Parte1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collection;

public class MDIManager extends JFrame {
    public static final Collection<MDIElement<?>> components = Arrays.asList(
            new Propuesto18(),
            new Propuesto19(),

            new Resuelto7(),
            new Resuelto10(),

            new Propuesto22(),
            new Propuesto23(),
            new Propuesto40(),
            new Propuesto41()
    );

    private final JDesktopPane desktopPane;

    public MDIManager() {
        // Configure the main window
        setTitle("Tarea 3 - Parte 1 - Juan José Jiménez");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a JDesktopPane for MDI
        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        // Set up menu bar
        setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Components menu
        JMenu componentsMenu = new JMenu("Ejercicios");
        for (MDIElement<?> component : components) {
            JMenuItem componentItem = new JMenuItem(component.title);
            componentItem.addActionListener(e -> desktopPane.add(component.getFrame(this)));
            componentsMenu.add(componentItem);
        }
        menuBar.add(componentsMenu);

        return menuBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MDIManager mdiManager = new MDIManager();
            mdiManager.setVisible(true);
        });
    }
}