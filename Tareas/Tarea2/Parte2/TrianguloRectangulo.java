package Tareas.Tarea2.Parte2;

public class TrianguloRectangulo implements Figura {

    private final double base;
    private final double altura;
    private final double hipotenusa;
    public TrianguloRectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.hipotenusa = Math.pow(base*base + altura*altura, 0.5);
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double calcularHipotenusa() {
        return hipotenusa;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public double perimetro() {
        return base + altura + hipotenusa;
    }

    public TipoTriangulo getTipo() {
        for (TipoTriangulo value : TipoTriangulo.values()) {
            if (value.isOfType(this)) return value;
        }
        throw new IllegalStateException();
    }

    public enum TipoTriangulo {
        EQUILATERO {
            @Override
            boolean isOfType(TrianguloRectangulo triangulo) {
                return triangulo.base == triangulo.altura && triangulo.base == triangulo.hipotenusa;
            }
        },
        ISOCELES {
            @Override
            boolean isOfType(TrianguloRectangulo triangulo) {
                return !EQUILATERO.isOfType(triangulo) && !ESCALENO.isOfType(triangulo);
            }
        },
        ESCALENO {
            @Override
            boolean isOfType(TrianguloRectangulo triangulo) {
                return triangulo.base != triangulo.altura && triangulo.base != triangulo.hipotenusa;
            }
        };

        abstract boolean isOfType(TrianguloRectangulo triangulo);
    }
}
