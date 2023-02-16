import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main (String[] arg) {
        Map<Integer,Ubicacion> ubicaciones = new HashMap<>();

        Ubicacion clase = new Ubicacion(0, "Estás sentado en la clase de programación");
        Ubicacion montanya = new Ubicacion(1, "Estás en la cima de una montaña");
        Ubicacion playa = new Ubicacion(2, "Estás bañándote en la playa");
        Ubicacion edificio = new Ubicacion(3, "Estás dentro de un edificio muy alto");
        Ubicacion puente = new Ubicacion(4, "Estás de pie en un puente");
        Ubicacion bosque = new Ubicacion(5, "Estás en un bosque");

        ubicaciones.put(0, clase);
        ubicaciones.put(1, montanya);
        ubicaciones.put(2, playa);
        ubicaciones.put(3, edificio);
        ubicaciones.put(4, puente);
        ubicaciones.put(5, bosque);

        montanya.addExit("N", 5);
        montanya.addExit("S", 4);
        montanya.addExit("E", 3);
        montanya.addExit("O", 2);
        playa.addExit("N", 5);
        edificio.addExit("O", 1);
        puente.addExit("N", 1);
        puente.addExit("O", 2);
        bosque.addExit("O", 2);
        bosque.addExit("S", 1);

        for(int x : ubicaciones.keySet()) {
            ubicaciones.get(x).addExit("Q",0);
        }

        boolean salir = false;
        String choice;
        int i = 1;
        do {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("\n" + ubicaciones.get(i).getDescripcion() + "\n");

            System.out.println("Salidas: ");
            for (String y : ubicaciones.get(i).getExits().keySet()) {
                switch (ubicaciones.get(i).getExits().get(y)) {
                    case 0:
                        System.out.println(y + " - Clase de programación");
                        break;
                    case 1:
                        System.out.println(y + " - Montaña");
                        break;
                    case 2:
                        System.out.println(y + " - Playa");
                        break;
                    case 3:
                        System.out.println(y + " - Edificio");
                        break;
                    case 4:
                        System.out.println(y + " - Puente");
                        break;
                    case 5:
                        System.out.println(y + " - Bosque");
                        break;
                }
            }

            System.out.print("\n- ");
            choice = sc1.nextLine().toUpperCase(Locale.ROOT);

            try {
                switch (choice){
                    case "Q":
                        i = 0;
                        break;
                    case "N":
                        i = ubicaciones.get(i).getExits().get("N");
                        break;
                    case "O":
                        i = ubicaciones.get(i).getExits().get("O");
                        break;
                    case "S":
                        i = ubicaciones.get(i).getExits().get("S");
                        break;
                    case "E":
                        i = ubicaciones.get(i).getExits().get("E");
                        break;
                    default:
                        System.out.println("\nEsa dirección no es válida");
                        break;
                }
            } catch(NullPointerException e) {
                System.out.println("\nNo puedes ir hacia esa dirección");
            }

        } while(i != 0);
        System.out.println("\n" + ubicaciones.get(i).getDescripcion());
    }
}
