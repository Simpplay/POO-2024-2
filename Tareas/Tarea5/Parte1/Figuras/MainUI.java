package Tareas.Tarea5.Parte1.Figuras;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.border.TitledBorder;

public class MainUI extends JFrame {
    private final JComboBox<String> comboBox;
    private final Figura[] figuras;
    private final FiguraUI figuraUI;

    public MainUI(Figura[] figuras) {
        super("Figuras");
        this.figuras = figuras;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("Seleccione una figura:");
        topPanel.add(label);

        comboBox = new JComboBox<>();
        for (Figura figura : figuras) comboBox.addItem(figura.nombre());
        comboBox.addActionListener(e -> actualizarFiguraUI());
        topPanel.add(comboBox);

        this.add(topPanel, BorderLayout.NORTH);

        figuraUI = new FiguraUI(figuras[0], this);
        this.add(figuraUI, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private void actualizarFiguraUI() {
        int index = comboBox.getSelectedIndex();
        if (index >= 0) {
            figuraUI.setFigura(figuras[index]);
        }
    }
}

class FiguraUI extends JPanel {
    private Figura figura;
    private JTextField[] textFields;
    private final JTextField volumenTextField;
    private final JTextField superficieTextField;
    private final JPanel variablesPanel;
    private final JFrame parent;

    public FiguraUI(Figura figura, JFrame parent) {
        this.parent = parent;
        this.figura = figura;
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la Figura", TitledBorder.CENTER, TitledBorder.TOP));

        variablesPanel = new JPanel();
        variablesPanel.setLayout(new GridLayout(0, 2, 5, 5));
        this.add(variablesPanel, BorderLayout.CENTER);

        volumenTextField = new JTextField(7);
        volumenTextField.setEditable(false);

        superficieTextField = new JTextField(7);
        superficieTextField.setEditable(false);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.add(new JLabel("Volumen (cm3):"));
        bottomPanel.add(volumenTextField);
        bottomPanel.add(new JLabel("Superficie (cm2):"));
        bottomPanel.add(superficieTextField);
        this.add(bottomPanel, BorderLayout.SOUTH);

        setFigura(figura);
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
        variablesPanel.removeAll();
        List<Figura.Variable> variables = figura.variables();
        textFields = new JTextField[variables.size()];

        for (int i = 0; i < variables.size(); i++) {
            Figura.Variable variable = variables.get(i);
            JLabel label = new JLabel(variable.nombre() + ":");
            variablesPanel.add(label);

            JTextField textField = new JTextField();
            textField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) { actualizarDatos(); }
                @Override
                public void removeUpdate(DocumentEvent e) { actualizarDatos(); }
                @Override
                public void changedUpdate(DocumentEvent e) { actualizarDatos(); }
            });
            variablesPanel.add(textField);
            textFields[i] = textField;
        }

        revalidate();
        repaint();
        this.parent.pack();
    }

    private void actualizarDatos() {
        Map<String, Figura.FulfilledVariable> valores = new HashMap<>();
        List<Figura.Variable> variables = figura.variables();

        for (int i = 0; i < variables.size(); i++) {
            Figura.Variable variable = variables.get(i);
            String texto = textFields[i].getText();
            try {
                valores.put(variable.id(), new Figura.FulfilledVariable(variable, Double.parseDouble(texto)));
            } catch (Exception ignored) {
                volumenTextField.setText("N/A");
                superficieTextField.setText("N/A");
                return;
            }
        }
        double volumen = figura.volumen(valores);
        double superficie = figura.superficie(valores);

        volumenTextField.setText(String.format("%.2f", volumen));
        superficieTextField.setText(String.format("%.2f", superficie));
    }
}


