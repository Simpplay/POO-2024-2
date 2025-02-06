package Tareas.Tarea5.Parte1.Figuras;

import java.util.List;
import java.util.Map;

public class Piramide extends Figura {
    private final Variable BASE = new Variable("Base (cm)", "base");
    private final Variable ALTURA = new Variable("Altura (cm)", "altura");
    private final Variable APOTEMA = new Variable("Apotema (cm)", "apotema");

    @Override
    public String nombre() {
        return "Piramide";
    }

    @Override
    public double volumen(Map<String, FulfilledVariable> valores) {
        double base = getVariableValue("base", valores).orElse(0.0);
        double altura = getVariableValue("altura", valores).orElse(0.0);

        return (base * base * altura) / 3;
    }

    @Override
    public double superficie(Map<String, FulfilledVariable> valores) {
        double base = getVariableValue("base", valores).orElse(0.0);
        double apotema = getVariableValue("apotema", valores).orElse(0.0);

        return base * (base + 2 * apotema);
    }

    @Override
    public List<Variable> variables() {
        return List.of(BASE, ALTURA, APOTEMA);
    }
}
