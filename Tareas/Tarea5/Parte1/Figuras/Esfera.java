package Tareas.Tarea5.Parte1.Figuras;

import java.util.List;
import java.util.Map;

public class Esfera extends Figura {
    private static final Variable RADIO = new Variable("Radio (cm)", "radio");

    @Override
    public String nombre() {
        return "Esfera";
    }

    @Override
    public double volumen(Map<String, FulfilledVariable> valores) {
        double radio = getVariableValue("radio", valores).orElse(0.0);
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public double superficie(Map<String, FulfilledVariable> valores) {
        double radio = getVariableValue("radio", valores).orElse(0.0);
        return 4 * Math.PI * Math.pow(radio, 2);
    }

    @Override
    public List<Variable> variables() {
        return List.of(RADIO);
    }


}
