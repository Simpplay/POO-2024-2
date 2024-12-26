package Tareas.Tarea3.Parte2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collection;

public class MDIManager extends JFrame {

    private static final class MDIFigure<E extends Figura> extends MDIElement<E> {
        public MDIFigure(String title, Argument<?>[] args, Class<E> targetClass) {
            super(title, args, targetClass);
        }
    }

    public static final Collection<MDIElement<?>> components = Arrays.asList(
            new MDIFigure<>("Circulo", new MDIElement.Argument<?>[] {
                    new MDIElement.Argument<>("Radio", double.class)
            }, Circulo.class),
            new MDIFigure<>("Cuadrado", new MDIElement.Argument<?>[] {
                    new MDIElement.Argument<>("Lado", double.class)
            }, Cuadrado.class),
            new MDIFigure<>("Rectangulo", new MDIElement.Argument<?>[] {
                    new MDIElement.Argument<>("Base", double.class),
                    new MDIElement.Argument<>("Altura", double.class)
            }, Rectangulo.class),
            new MDIFigure<>("Triangulo Rectangulo", new MDIElement.Argument<?>[] {
                    new MDIElement.Argument<>("Base", double.class),
                    new MDIElement.Argument<>("Altura", double.class)
            }, TrianguloRectangulo.class),
            new MDIFigure<>("Rombo", new MDIElement.Argument<?>[] {
                    new MDIElement.Argument<>("Lado", double.class)
            }, Rombo.class),
            new MDIFigure<>("Trapecio", new MDIElement.Argument<?>[] {
                    new MDIElement.Argument<>("A", double.class),
                    new MDIElement.Argument<>("B", double.class),
                    new MDIElement.Argument<>("C", double.class),
                    new MDIElement.Argument<>("D", double.class)
            }, Trapecio.class)
    );

    private final JDesktopPane desktopPane;

    public MDIManager() {
        // Configure the main window
        setTitle("Tarea 3 - Parte 2 - Juan José Jiménez");
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
        JMenu componentsMenu = new JMenu("Figuras");
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