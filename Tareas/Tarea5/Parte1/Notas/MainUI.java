package Tareas.Tarea5.Parte1.Notas;

import javax.swing.*;

import java.awt.*;
import java.util.List;

public class MainUI extends JFrame {

    private final JComboBox<Estudiante> estudianteComboBox;
    private EstudianteUI activeEstudianteUI;
    private final JPanel mainPanel;

    public MainUI(List<Estudiante> estudiantes) {
        super("Calculadora de Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        estudianteComboBox = new JComboBox<>(estudiantes.toArray(new Estudiante[0]));
        estudianteComboBox.addActionListener(e -> actualizarEstudianteUI());
        add(estudianteComboBox, BorderLayout.NORTH);

        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        actualizarEstudianteUI();
        setVisible(true);
    }

    private void actualizarEstudianteUI() {
        Estudiante estudiante = (Estudiante) estudianteComboBox.getSelectedItem();
        if (estudiante == null) return;

        if (activeEstudianteUI != null) {
            mainPanel.remove(activeEstudianteUI);
        }

        activeEstudianteUI = new EstudianteUI(estudiante);
        mainPanel.add(activeEstudianteUI, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}

class EstudianteUI extends JPanel {
    private final Estudiante estudiante;
    private final JTextField promedioTextField;
    private final JTextField maxNoteTextField;
    private final JTextField minNoteTextField;
    private final JTextField desvEstTextField;
    private final JPanel notasPanel;

    public EstudianteUI(Estudiante estudiante) {
        this.estudiante = estudiante;
        setLayout(new BorderLayout());

        JLabel nombreLabel = new JLabel("Estudiante: " + estudiante.getNombre());
        add(nombreLabel, BorderLayout.NORTH);

        notasPanel = new JPanel();
        notasPanel.setLayout(new BoxLayout(notasPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(notasPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        JButton agregarNotaButton = new JButton("Agregar Nota");
        agregarNotaButton.addActionListener(e -> agregarNota());
        bottomPanel.add(agregarNotaButton);

        promedioTextField = new JTextField(5);
        promedioTextField.setEditable(false);
        bottomPanel.add(new JLabel("Promedio: "));
        bottomPanel.add(promedioTextField);

        maxNoteTextField = new JTextField(5);
        maxNoteTextField.setEditable(false);
        bottomPanel.add(new JLabel("Nota Máxima: "));
        bottomPanel.add(maxNoteTextField);

        minNoteTextField = new JTextField(5);
        minNoteTextField.setEditable(false);
        bottomPanel.add(new JLabel("Nota Mínima: "));
        bottomPanel.add(minNoteTextField);

        desvEstTextField = new JTextField(5);
        desvEstTextField.setEditable(false);
        bottomPanel.add(new JLabel("Desviación Estándar: "));
        bottomPanel.add(desvEstTextField);

        add(bottomPanel, BorderLayout.SOUTH);
        actualizarNotas();
    }

    private void agregarNota() {
        String input = JOptionPane.showInputDialog(this, "Ingrese nueva nota:", "Agregar Nota", JOptionPane.PLAIN_MESSAGE);
        try {
            double nota = Double.parseDouble(input);
            estudiante.agregarNota(nota);
            actualizarNotas();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void actualizarNotas() {
        notasPanel.removeAll();
        for (int i = 0; i < estudiante.getNotas().size(); i++) {
            notasPanel.add(new NotaUI(this, estudiante, i));
        }
        calcularPromedio();
        calcularNotaMaxima();
        calcularNotaMinima();
        calcularDesviacionEstandar();

        notasPanel.revalidate();
        notasPanel.repaint();
    }

    private void calcularPromedio() {
        List<Double> notas = estudiante.getNotas();
        double promedio = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        promedioTextField.setText(String.format("%.2f", promedio));
    }

    private void calcularNotaMaxima() {
        List<Double> notas = estudiante.getNotas();
        double max = notas.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
        maxNoteTextField.setText(String.format("%.2f", max));
    }

    private void calcularNotaMinima() {
        List<Double> notas = estudiante.getNotas();
        double min = notas.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
        minNoteTextField.setText(String.format("%.2f", min));
    }

    private void calcularDesviacionEstandar() {
        List<Double> notas = estudiante.getNotas();
        double promedio = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double sum = notas.stream().mapToDouble(n -> Math.pow(n - promedio, 2)).sum();
        double desvEst = Math.sqrt(sum / notas.size());
        desvEstTextField.setText(String.format("%.2f", desvEst));
    }
}

class NotaUI extends JPanel {
    public NotaUI(EstudianteUI estudianteUI, Estudiante estudiante, int index) {
        setLayout(new FlowLayout());

        double nota = estudiante.getNotas().get(index);
        JLabel notaLabel = new JLabel(String.format("Nota %d: %.2f", index + 1, nota));
        add(notaLabel);

        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(e -> {
            estudiante.eliminarNota(index);
            estudianteUI.actualizarNotas();
        });
        add(eliminarButton);
    }
}