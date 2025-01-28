package Tareas.Tarea4.Parte1.E5_ListaPersonasInterfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MainWindow extends JFrame implements ActionListener {

    private final Map<UUID, Persona> personas = new HashMap<>();
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> listView;
    private JTextField txtNombre, txtApellido, txtDireccion, txtTelefono;

    public MainWindow() {
        super("Lista de personas");
        this.setSize(270, 350);
        this.fillContent(this.getContentPane());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    protected void fillContent(Container container) {
        container.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 10, 80, 25);
        container.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 10, 150, 25);
        container.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 40, 80, 25);
        container.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(100, 40, 150, 25);
        container.add(txtApellido);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(10, 70, 80, 25);
        container.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(100, 70, 150, 25);
        container.add(txtDireccion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(10, 100, 80, 25);
        container.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(100, 100, 150, 25);
        container.add(txtTelefono);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(10, 130, 100, 30);
        btnAgregar.addActionListener(this);
        container.add(btnAgregar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(120, 130, 100, 30);
        btnEliminar.addActionListener(this);
        container.add(btnEliminar);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(10, 170, 210, 30);
        btnModificar.addActionListener(this);
        container.add(btnModificar);

        listView = new JList<>(listModel);
        listView.setBounds(10, 210, 230, 100);
        container.add(listView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Agregar" -> {

                BuildPersona();
            }
            case "Eliminar" -> {
                int selectedIndex = listView.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedPerson = listView.getSelectedValue();
                    personas.entrySet().removeIf(entry -> entry.getValue().toString().equals(selectedPerson));
                    listModel.remove(selectedIndex);
                }

            }
            case "Modificar" -> {
                int selectedIndex = listView.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedPerson = listView.getSelectedValue();
                    UUID selectedId = null;

                    for (Map.Entry<UUID, Persona> entry : personas.entrySet()) {
                        if (entry.getValue().toString().equals(selectedPerson)) {
                            selectedId = entry.getKey();
                            break;
                        }
                    }

                    if (selectedId != null) {
                        Persona persona = personas.get(selectedId);

                        txtNombre.setText(persona.getNombre());
                        txtApellido.setText(persona.getApellido());
                        txtDireccion.setText(persona.getDireccion());
                        txtTelefono.setText(persona.getTelefono());

                        JButton btnActualizar = new JButton("Actualizar");
                        btnActualizar.setBounds(10, 130, 100, 30);
                        btnActualizar.addActionListener(e1 -> {
                            BuildPersona();
                        });
                        this.getContentPane().add(btnActualizar);
                    }
                }
            }
        }
    }

    private void BuildPersona() {
        Persona.Builder builder = new Persona.Builder();
        builder.setNombre(txtNombre.getText())
                .setApellido(txtApellido.getText())
                .setDireccion(txtDireccion.getText())
                .setTelefono(txtTelefono.getText());
        Persona p = builder.build();

        if (p != null) {
            UUID id = UUID.randomUUID();
            personas.put(id, p);
            listModel.addElement(p.toString());
            clearTextFields();
        }
    }

    private void clearTextFields() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }
}
