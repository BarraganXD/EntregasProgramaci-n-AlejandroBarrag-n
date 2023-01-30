package EjercicioEstudiantes;

import java.util.Arrays;
import java.util.Comparator;

public class Estudiante implements Comparable<Estudiante>{

    public static void main (String[] arg) {
        Estudiante a = new Estudiante("Patri", 12, 170);
        Estudiante b = new Estudiante("Manuel", 43, 173);
        Estudiante c = new Estudiante("Javier", 72, 189);
        Estudiante d = new Estudiante("Alicia", 52, 168);
        Estudiante e = new Estudiante("Alberto", 35, 189);

        Estudiante[] arrayE = {a, b, c, d, e};

        System.out.println("LISTA DESORDENADA:");
        for (Estudiante x : arrayE) {
            System.out.println(x.toString());
        }

        System.out.println("\nLISTA ORDENADA:");
        Arrays.sort(arrayE, Comparator.reverseOrder());
        for (Estudiante x : arrayE) {
            System.out.println(x.toString());
        }
    }

    private String nombre;
    private int edad;
    private int altura;

    public Estudiante(String nombre, int edad, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "EjercicioEstudiantes.Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", edad=" + edad +
                '}';
    }

    @Override
    public int compareTo(Estudiante o) {
        return Double.compare(this.altura, o.altura);
    }
}
