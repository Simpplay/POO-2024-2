package Tarea2.Parte2;

public class PruebaFiguras {

    /**
     * Método main que crea un círculo, un rectángulo, un cuadrado y
     * un triángulo rectángulo. Para cada uno de estas figuras geométricas,
     * se calcula su área y perímetro.
     */
    public static void main(String[] args) {
        Circulo figura1 = new Circulo(2);
        Rectangulo figura2 = new Rectangulo(1,2);
        Cuadrado figura3 = new Cuadrado(3);
        TrianguloRectangulo figura4 = new TrianguloRectangulo(3,5);
        Rombo figura5 = new Rombo(5);
        Trapecio figura6 = new Trapecio(8, 7, 8, 15);
        System.out.println("El área del círculo es = " + figura1.area());
        System.out.println("El perímetro del círculo es = " + figura1.perimetro());
        System.out.println();
        System.out.println("El área del rectángulo es = " + figura2.area());
        System.out.println("El perímetro del rectángulo es = " + figura2.perimetro());
        System.out.println();
        System.out.println("El área del cuadrado es = " + figura3.area());
        System.out.println("El perímetro del cuadrado es = " + figura3.perimetro());
        System.out.println();
        System.out.println("El área del triángulo es = " + figura4.area());
        System.out.println("El perímetro del triángulo es = " + figura4.perimetro());
        System.out.println("Es un triangulo " + figura4.getTipo().toString());
        System.out.println();
        System.out.println("El área del rombo es = " + figura5.area());
        System.out.println("El perímetro del rombo es = " + figura5.perimetro());
        System.out.println();
        System.out.println("El área del trapecio es = " + figura6.area());
        System.out.println("El perímetro del trapecio es = " + figura6.perimetro());
    }
    
}
