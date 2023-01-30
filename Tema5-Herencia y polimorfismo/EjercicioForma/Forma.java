package EjercicioForma;

import java.util.Arrays;

public abstract class Forma implements Redimensionable {
    public static void main(String[] arg) {
        Forma T = new Triangulo(3, 5, 7);
        System.out.println("\n" + T);

        Forma R = new Rectangulo(4, 2, 3);
        System.out.println("\n" + R);

        System.out.println("\n//Rectángulo redimensionado");
        R.redimensionar(2);
        System.out.println(R);

        //10 objetos
        Rectangulo R0 = new Rectangulo(4, 2, 2);
        Rectangulo R1 = new Rectangulo(4, 0, 0);
        Rectangulo R2 = new Rectangulo(4, 1, 1);
        Rectangulo R3 = new Rectangulo(4, 3, 3);
        Rectangulo R4 = new Rectangulo(4, 4, 4);
        Rectangulo R5 = new Rectangulo(4, 5, 5);
        Rectangulo R6 = new Rectangulo(4, 6, 6);
        Rectangulo R7 = new Rectangulo(4, 7, 7);
        Rectangulo R8 = new Rectangulo(4, 9, 9);
        Rectangulo R9 = new Rectangulo(4, 8, 8);

        Rectangulo[] arrayF = {R0, R1, R2, R3, R4, R5, R6, R7, R8, R9};

        System.out.println("\nArray desordenado:");
        for (Rectangulo aux : arrayF) {
            System.out.print(aux.getArea() + ", ");
        }

        System.out.println("\n\nArray ordenado:");
        Arrays.sort(arrayF);
        for (Rectangulo aux : arrayF) {
            System.out.print(aux.getArea() + ", ");
        }
    }

    private final int numLados;

    public Forma(int lados) {
        this.numLados = lados;
    }

    public int getLados() {
        return this.numLados;
    }

    @Override
    public String toString() {
        return "Forma{" +
                "numLados=" + numLados +
                '}';
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public static class Rectangulo extends Forma implements Redimensionable, Comparable<Rectangulo>{
        private int ancho;
        private int alto;

        public Rectangulo(int lados, int ancho, int alto) {
            super(lados);
            this.ancho = ancho;
            this.alto = alto;
        }

        @Override
        public double getArea() {
            return ancho * alto;
        }

        @Override
        public double getPerimeter() {
            return ancho * 2 + alto * 2;
        }

        @Override
        public void redimensionar(int x) {
            this.ancho *= 2;
            this.alto *= 2;
        }

        @Override
        public String toString() {
            return "Rectangulo{" +
                    "numLados=" + getLados() +
                    ", ancho=" + ancho +
                    ", alto=" + alto +
                    ", area=" + this.getArea() +
                    ", perimetro=" + this.getPerimeter() +
                    "}";
        }

        @Override
        public int compareTo(Rectangulo o) {
            return Double.compare(this.getArea(), o.getArea());
        }
    }

    public static class Triangulo extends Forma implements Redimensionable{
        private int base;
        private int altura;

        public Triangulo(int lados, int base, int altura) {
            super(lados);
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double getArea() {
            return base * altura;
        }

        @Override
        public double getPerimeter() {
            return base * 3;
        }

        @Override
        public void redimensionar(int x) {
            this.base *= 2;
            this.altura *= 2;
        }

        @Override
        public String toString() {
            return "Triangulo{" +
                    "numLados=" + getLados() +
                    ", base=" + base +
                    ", altura=" + altura +
                    ", area=" + this.getArea() +
                    ", perimetro=" + this.getPerimeter() +
                    "}";
        }

        public Forma[] compareTo(Forma[] ArrayF) {
            return new Forma[0];
        }
    }
}
