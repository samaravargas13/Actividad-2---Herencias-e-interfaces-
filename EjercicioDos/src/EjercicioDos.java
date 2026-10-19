interface FiguraPlana {
    double calcularArea();
    double calcularPerimetro();
}

abstract class Figura2D implements FiguraPlana {
    public abstract String imprimeFigura();
}

abstract class FiguraRecta extends Figura2D {
    protected int ancho;
    protected int alto;
}

abstract class FiguraCircular extends Figura2D {
    protected int radio;
}

class TrianguloRect extends FiguraRecta {
    public TrianguloRect(int ancho, int alto) {
        System.out.println("Se imprime una FiguraPlana...");
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return (double) (ancho * alto) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return ancho + alto + Math.sqrt(ancho * ancho + alto * alto);
    }

    @Override
    public String imprimeFigura() {
        return "Se imprime un Triangulo con alto: " + alto + ", ancho: " + ancho + 
               ", area: " + String.format("%.2f", calcularArea()) + 
               ", perimetro: " + String.format("%.2f", calcularPerimetro());
    }
}

class Circulo extends FiguraCircular {
    public Circulo(int radio) {
        System.out.println("Se imprime una FiguraPlana...");
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String imprimeFigura() {
        return "Se imprime un Circulo con radio: " + radio + 
               ", area: " + String.format("%.2f", calcularArea()) + 
               ", perimetro: " + String.format("%.2f", calcularPerimetro());
    }
}

public class EjercicioDos {
    public static void main(String[] args) {
        Figura2D f = new TrianguloRect(3, 4);
        System.out.println(f.imprimeFigura());
        f = new Circulo(3);
        System.out.println(f.imprimeFigura());
    }
}