import java.util.InputMismatchException;
import java.util.Scanner;

public class Trece {
    public static void main (String[] QueSignificaStatic) {
        boolean valid;
        double r = 0;
        do{
            valid = true;
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Introduce el radio del círculo: ");
                r = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("\nError: Debe tratarse de un número");
                valid = false;
            }
        } while (!valid);

        Circulo a = new Circulo(r);
        System.out.println("El área de un circulo r="+a.getRadio()+" es "+a.getArea()+"\n");

        double r2 = 0;
        double h = 0;
        do {
            valid = true;
            try {
                Scanner sc2 = new Scanner(System.in);
                System.out.print("Introduce el radio y la altura del cilindro: ");
                r2 = sc2.nextDouble();
                h = sc2.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("\nError: Ambos valores deben ser números");
                valid = false;
            }
        } while (!valid);
        Cilindro s = new Cilindro(r2, h);
        System.out.println("El volúmen de un cilindro r="+s.getRadio()+" y h="+s.getAltura()+" es "+s.getVolumen());
    }

    public static class Circulo {
        public double radio;

        public Circulo(double radio) {
            this.radio = Math.max(radio, 0);
        }

        public double getRadio() {
            return this.radio;
        }

        public double getArea() {
            return Math.pow(radio, 2) * Math.PI;
        }
    }

    public static class Cilindro extends Circulo {
        public double altura;
        
        public Cilindro(double radio, double altura) {
            super(radio);
            this.altura = Math.max(altura, 0);
        }

        public double getAltura() {
            return this.altura;
        }

        public double getVolumen() {
            return getArea() * getAltura();
        }
    }
}
