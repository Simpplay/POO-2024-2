package Tareas.Tarea3.Parte2;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;

public abstract class MDIElement<T> {
    private final Argument<?>[] args;
    private final Class<T> targetClass;
    protected final HashMap<String, JTextField> labels = new HashMap<>();

    public final String title;

    /**
     * Crea un nuevo elemento de interfaz de usuario con argumentos y clase objetivo.
     * @param title Titulo de la ventana
     * @param args Argumentos necesarios para crear la instancia de la clase objetivo.
     * @param targetClass Clase objetivo a instanciar.
     */
    public MDIElement(String title, Argument<?>[] args, Class<T> targetClass) {
        this.title = title;
        this.args = args;
        this.targetClass = targetClass;
    }

    public Argument<?>[] getArgs() {
        return args;
    }

    /**
     * Crea un JInternalFrame con el formulario para los argumentos.
     * @param parent Componente padre, usado para enviar mensajes de error.
     * @return El JInternalFrame creado.
     */
    public JInternalFrame getFrame(Component parent) {
        JInternalFrame frame = new JInternalFrame(title, true, true, true, true);
        frame.add(getPanel(parent));
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    /**
     * Crea un panel con los campos de texto para los argumentos.
     * @param parent Componente padre, usado para enviar mensajes de error.
     * @return El panel creado.
     */
    protected JPanel getPanel(Component parent) {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

        // Entrada para cada argumento
        for (Argument<?> arg : this.args) {
            JLabel lbl = new JLabel(arg.name + ":");
            JTextField txt = new JTextField();
            labels.put(arg.name, txt);
            panel.add(lbl);
            panel.add(txt);
        }

        // Botón de enviar
        panel.add(new JLabel()); // Espaciador
        JButton btnSend = new JButton("Enviar");
        btnSend.addActionListener(e -> this.onSend(parent));
        panel.add(btnSend);

        return panel;
    }

    public void onSend(Component parent) {
        T instance = getInstanceViaArgs(parent);
        if (instance == null) {
            return;
        }
        JOptionPane.showMessageDialog(
                parent,
                    instance.toString(),
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);
    }


    /**
     * Basicamente este es el método más importante de esta clase
     * Se encarga de crear una instancia de la clase objetivo a partir de los argumentos
     * almacenados previamente en el HashMap labels.
     * A partir del tipo del argumento, se encuentra el constructor adecuado y se crea la instancia.
     * @param parent Componente padre, usado para enviar mensajes de error.
     * @return La instancia creada, o null si hubo un error.
     */
    public T getInstanceViaArgs(Component parent) {
        try {
            Class<?>[] parameterTypes = Arrays.stream(args)
                    .map(arg -> arg.type)
                    .toArray(Class<?>[]::new);

            Constructor<T> constructor = targetClass.getConstructor(parameterTypes);

            Object[] parameterValues = Arrays.stream(args)
                    .map(arg -> {
                        JTextField textField = labels.get(arg.name);
                        if (textField == null) {
                            throw new IllegalArgumentException("Error en la creación del formulario, no se creó para: " + arg.name);
                        }
                        String text = textField.getText();

                        if (text == null) {
                            throw new IllegalArgumentException("No se puede dejar en blanco: " + arg.name);
                        }
                        return parseValue(text, arg.type);
                    })
                    .toArray();
            return constructor.newInstance(parameterValues);

        } catch (NoSuchMethodException ex) {
            JOptionPane.showMessageDialog(parent, "No hay constructor para la clase objetivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(parent, "Error al crear la instancia: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    /**
     * Convierte un string a el tipo especificado.
     *
     * @throws IllegalArgumentException Si el tipo no es soportado.
     * @param value La cadena a convertir.
     * @param type  El tipo al que se convertirá.
     * @return El valor convertido.
     */
    private Object parseValue(String value, Class<?> type) {
        if (type == String.class) {
            return value;
        } else if (type == int.class || type == Integer.class) {
            return Integer.parseInt(value);
        } else if (type == double.class || type == Double.class) {
            return Double.parseDouble(value);
        } else if (type == boolean.class || type == Boolean.class) {
            return Boolean.parseBoolean(value);
        } else if (type == float.class || type == Float.class) {
            return Float.parseFloat(value);
        } else if (type == long.class || type == Long.class) {
            return Long.parseLong(value);
        } else {
            try {
                return type.cast(value);
            } catch (Exception e) {
                throw new IllegalArgumentException("Unsupported argument type: " + type);
            }
        }
    }

    public record Argument<T>(String name, Class<T> type) { }
}
