public class Cancion {
    private String titulo;
    private double duracion;

    public String getTitulo() {
        return titulo;
    }

    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
