package Tareas.Tarea5.Parte1.Figuras;

import java.util.List;
import java.util.Map;

public class Cilindro extends Figura {

    private final Variable RADIO = new Variable("Radio (cm)", "radio");
    private final Variable ALTURA = new Variable("Altura (cm)", "altura");

    @Override
    public String nombre() {
        return "Cilindro";
    }

    @Override
    public double volumen(Map<String, FulfilledVariable> valores) {
        double radio = getVariableValue("radio", valores).orElse(0.0);
        double altura = getVariableValue("altura", valores).orElse(0.0);

        return Math.PI * Math.pow(radio, 2) * altura;
    }

    @Override
    public double superficie(Map<String, FulfilledVariable> valores) {
        double radio = getVariableValue("radio", valores).orElse(0.0);
        double altura = getVariableValue("altura", valores).orElse(0.0);

        return 2 * Math.PI * radio * (radio + altura);
    }

    @Override
    public List<Variable> variables() {
        return List.of(RADIO, ALTURA);
    }
}
