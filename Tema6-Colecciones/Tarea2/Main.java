import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        ArrayList<Album> coleccion = new ArrayList<>();

        coleccion.add(new Album("El camino", "The Black Keys"));
        coleccion.add(new Album("Ruby, Ruby", "Gato Barbieri"));
        coleccion.add(new Album("Vamos que nos vamos", "Muchachito bombo infierno"));
        coleccion.add(new Album("Toxicity", "System Of A Down"));
        coleccion.add(new Album("Photographs and memories", "Jim Croce"));

        coleccion.get(0).addSong("Gold On The Ceiling",3.44);
        coleccion.get(0).addSong("Little Black Submarines", 3.24);
        coleccion.get(1).addSong("Latin Reaction", 4.58);
        coleccion.get(1).addSong("Nostalgia", 5.25);
        coleccion.get(2).addSong("Si tu si yo", 3.39);
        coleccion.get(2).addSong("Sin vigilancia", 3.34);
        coleccion.get(3).addSong("Toxicity", 3.38);
        coleccion.get(3).addSong("Chop Suey!", 3.30);
        coleccion.get(4).addSong("Time in a bottle", 2.24);
        coleccion.get(4).addSong("Operator", 3.45);

        LinkedList<Cancion> playList1 = new LinkedList<>();
        coleccion.get(0).addToPlayList(0, playList1);
        coleccion.get(1).addToPlayList(0, playList1);
        coleccion.get(2).addToPlayList(0, playList1);
        coleccion.get(3).addToPlayList(0, playList1);
        coleccion.get(4).addToPlayList(0, playList1);

        coleccion.get(0).addToPlayList("Little Black Submarines", playList1);
        coleccion.get(1).addToPlayList("Nostalgia", playList1);
        coleccion.get(2).addToPlayList("Sin vigilancia", playList1);
        coleccion.get(3).addToPlayList("Chop Suey!", playList1);
        coleccion.get(4).addToPlayList("Operator", playList1);

        play(playList1);
    }

    public static void printPlayList(LinkedList<Cancion> PL) {
        ListIterator<Cancion> IT = PL.listIterator();
        while (IT.hasNext()) {
            System.out.println(IT.nextIndex() + " - " + IT.next());
        }
    }

    public static void showMenu() {
        System.out.println("""
                
                ESCOGE UNA OPCIÓN
                --------------------------------------------------
                0 - Salir de la lista de reproducción
                1 - Reproducir siguiente canción de la lista
                2 - Reproducir la canción previa de la lista
                3 - Repetir la canción actual
                4 - Imprimir la lista de canciones de la playlist
                5 - Volver a imprimir el menú
                6 - Eliminar la canción actual de la lista
                --------------------------------------------------
                """);
    }

    public static void play(LinkedList<Cancion> lista) {
        ListIterator<Cancion> IT = lista.listIterator();
        Scanner sc1 = new Scanner(System.in);
        boolean repeat;
        String lastInput = "1";
        boolean anySong = true;

        showMenu();
        System.out.println("Comienza sonando: " + IT.next() + "\n");
        do {
            String opcion = sc1.nextLine();
            System.out.println("");

            repeat = true;
            switch (opcion) {
                case "0":
                    repeat = false;
                    break;
                case "1":
                    if (anySong) {
                        if (IT.hasNext()) {
                            if (lastInput.equals("1")) {
                                System.out.println("Reproduciendo pista " + IT.nextIndex() + ": " + IT.next());
                            } else {
                                IT.next();
                                System.out.println("Reproduciendo pista " + IT.nextIndex() + ": " + IT.next());
                            }
                        } else {
                            System.out.println("Ya estás en la última pista");
                            repeat(IT, lastInput);
                        }
                        lastInput = "1";
                    } else {
                        System.out.println("No quedan canciones en tu lista");
                    }

                    showMenu();
                    break;
                case "2":
                    if (anySong) {
                        if (IT.hasPrevious()) {
                            if (lastInput.equals("1")) {
                                IT.previous();
                                System.out.println("Reproduciendo pista " + IT.previousIndex() + ": " + IT.previous());
                            } else {
                                System.out.println("Reproduciendo pista " + IT.previousIndex() + ": " + IT.previous());
                            }
                        } else {
                            System.out.println("Ya estás en la primera pista");
                            repeat(IT, lastInput);
                        }
                        lastInput = "2";
                    } else {
                        System.out.println("No quedan canciones en tu lista");
                    }

                    showMenu();
                    break;
                case "3":
                    if (anySong) {
                        repeat(IT, lastInput);
                    } else {
                        System.out.println("No quedan canciones en tu lista");
                    }

                    showMenu();
                    break;
                case "4":
                    if (anySong) {
                        printPlayList(lista);
                    } else {
                        System.out.println("No quedan canciones en tu lista");
                    }

                    showMenu();
                    break;
                case "5":
                    showMenu();
                    break;
                case "6":
                    if (anySong) {
                        IT.remove();
                        if (IT.hasNext()) {
                            System.out.println("Reproduciendo pista " + IT.nextIndex() + ": " + IT.next());
                        } else if (IT.hasPrevious()){
                            System.out.println("Reproduciendo pista " + IT.previousIndex() + ": " + IT.previous());
                        } else {
                            System.out.println("No quedan canciones en la lista");
                            anySong = false;
                        }
                    } else {
                        System.out.println("No quedan canciones en la lista");
                    }

                    showMenu();
                    break;
                default:
                    System.out.println("Opción inválida");
                    showMenu();
                    break;
            }
        } while (repeat);
        System.out.println("¡Hasta la próxima!");
    }

    public static void repeat (ListIterator<Cancion> IT, String lastInput) {
        if (lastInput.equals("1")) {
            System.out.println("Reproduciendo pista " + IT.previousIndex() + ": " + IT.previous());
            IT.next();
        } else {
            System.out.println("Reproduciendo pista " + IT.nextIndex() + ": " + IT.next());
            IT.previous();
        }
    }
}
