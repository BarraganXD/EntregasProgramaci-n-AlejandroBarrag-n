import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public String getNombre() {
        return nombre;
    }

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        canciones = new ArrayList<>();
    }

    public boolean addSong(String t, double d) {
        canciones.add(new Cancion(t, d));
        return findSong(t) != null;
    }

    private Cancion findSong(String t) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equalsIgnoreCase(t)) {
                return cancion;
            }
        }
        return null;
    }

    public boolean addToPlayList(int numeroPista, LinkedList<Cancion> LL) {
        LL.add(findSong(canciones.get(numeroPista).getTitulo()));
        return true;
    }

    public boolean addToPlayList(String t, LinkedList<Cancion> LL) {
        if (findSong(t) != null) {
            LL.add(findSong(t));
            return true;
        } else {
            return false;
        }
    }
}
