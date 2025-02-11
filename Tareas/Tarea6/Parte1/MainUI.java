package Tareas.Tarea6.Parte1;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class MainUI extends JFrame {

    private final Archivo archivo;
    private final DefaultTableModel tableModel;
    private final JTable table;

    public MainUI(Archivo archivo) {
        this.archivo = archivo;

        setTitle("Gestor de Contactos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Se crea un DefaultTableModel que permite editar únicamente la columna de teléfono
        tableModel = new DefaultTableModel(new Object[]{"Nombre", "Teléfono"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        table = new JTable(tableModel);

        // Al cambiar el número de teléfono de un contacto, se actualiza el registro
        tableModel.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                editContact();
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);

        // Se crean los botones de actualizar, añadir y eliminar
        JButton updateButton = new JButton("Actualizar");
        JButton addButton = new JButton("Añadir");
        JButton deleteButton = new JButton("Eliminar");

        updateButton.addActionListener(e -> updateContacts());
        addButton.addActionListener(e -> addContact());
        deleteButton.addActionListener(e -> deleteContact());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Lee los contactos del archivo y los muestra en la tabla
        updateContacts();
    }


    /**
     * Añade un contacto al archivo.
     * Si el nombre o el teléfono están vacíos, muestra un mensaje de advertencia.
     * Si el contacto se añade correctamente, actualiza la tabla.
     */
    private void addContact() {
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();

        int option = JOptionPane.showConfirmDialog(this, new Object[]{"Nombre:", nameField, "Teléfono:", phoneField},
                "Añadir Contacto", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();

            if (!name.isEmpty() && !phone.isEmpty()) {
                try {
                    archivo.addRegistry(new Contacto(name, phone));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el contacto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

            updateContacts();
        }
    }

    /**
     * Lee los contactos del archivo y los muestra en la tabla.
     */
    private void updateContacts() {
        try {
            tableModel.setRowCount(0);
            archivo.getAllRegistries().forEach(entry -> tableModel
                    .addRow(new Object[]{entry.contacto().nombre(), entry.contacto().telefono()}));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * En realidad, este método elimina el contacto y lo vuelve a añadir.
     */
    private void editContact() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String name = (String) tableModel.getValueAt(selectedRow, 0);
            String phone = (String) tableModel.getValueAt(selectedRow, 1);
            try {
                if (archivo.deleteRegistry(name)) {
                    archivo.addRegistry(new Contacto(name, phone));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al actualizar el contacto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Elimina un contacto del archivo.
     * Si no se ha seleccionado un contacto, muestra un mensaje de advertencia.
     * Si el contacto se elimina correctamente, actualiza la tabla.
     */
    private void deleteContact() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String name = (String) tableModel.getValueAt(selectedRow, 0);
            int option = JOptionPane.showConfirmDialog(this, "¿Desea eliminar a " + name + "?", "Eliminar Contacto",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    archivo.deleteRegistry(name);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el contacto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            updateContacts();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un contacto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
