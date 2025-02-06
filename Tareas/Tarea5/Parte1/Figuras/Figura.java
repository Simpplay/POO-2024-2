package Tareas.Tarea5.Parte1.Figuras;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class Figura {
    public abstract String nombre();
    public abstract double volumen(Map<String, FulfilledVariable> valores);
    public abstract double superficie(Map<String, FulfilledVariable> valores);
    public abstract List<Variable> variables();

    public record Variable(String nombre, String id) { }
    public record FulfilledVariable(Variable variable, double valor) { }

    public static Optional<Double> getVariableValue(String id, Map<String, FulfilledVariable> variables) {
        return Optional.ofNullable(variables.get(id)).map(FulfilledVariable::valor);
    }

    public static Map<String, FulfilledVariable> toVariableMap(List<FulfilledVariable> variables) {
        return variables.stream().collect(Collectors.toMap(v -> v.variable().id(), v -> v));
    }
}
