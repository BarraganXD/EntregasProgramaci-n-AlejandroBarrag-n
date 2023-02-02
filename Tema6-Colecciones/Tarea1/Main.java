import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        boolean check;
        String choice = "";
        Scanner sc1 = new Scanner(System.in);


        do { //Bucle general
            do { //Bucle del menú
                try {
                    System.out.println("""

                             Escoge la acción a realizar:
                            1. Listar todos los contactos
                            2. Añadir contacto nuevo
                            3. Actualizar contacto
                            4. Eliminar contacto
                            5. Buscar un contacto
                            6. Salir
                            """);

                    System.out.print("-");
                    choice = sc1.nextLine();
                    if (!choice.matches("[1-6]")) {
                        throw new Exception("Opción incorrecta");
                    } else {
                        check = true;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    check = false;
                }
            } while (!check);


            String nombre;
            String tlf = "";
            switch (choice) {
                case "1":
                    System.out.println("\nAgenda de contactos:\n--------------------");
                    TelefonoMovil.printContacts();
                    System.out.println("--------------------");
                    break;
                case "2":
                    System.out.print("\nIntroduce el nombre: ");
                    nombre = sc1.nextLine();
                    do {
                        try {
                            System.out.print("\nIntroduce el teléfono: ");
                            tlf = sc1.nextLine();
                            if (tlfMatch(tlf)) {
                                check = true;
                            } else {
                                throw new Exception("Formato de teléfono incorrecto");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            check = false;
                        }
                    } while (!check);

                    try {
                        if (!TelefonoMovil.addNewContact(Contacto.createContact(nombre, tlf))) {
                            throw new Exception("El contacto ya existe, no se ha añadido nada");
                        } else {
                            TelefonoMovil.addNewContact(Contacto.createContact(nombre, tlf));
                            System.out.println("\n¡Listo!");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    System.out.print("\nIntroduce el nombre del contacto antiguo: ");
                    nombre = sc1.nextLine();
                    System.out.print("\nIntroduce el nombre del nuevo contacto: ");
                    String newNombre = sc1.nextLine();
                    do {
                        try {
                            System.out.print("\nIntroduce el telefono del nuevo contacto: ");
                            tlf = sc1.nextLine();
                            if (!tlfMatch(tlf)) {
                                throw new Exception("Formato de teléfono incorrecto");
                            } else {
                                check = true;
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            check = false;
                        }
                    } while (!check);

                    try {
                        if (!TelefonoMovil.updateContact(TelefonoMovil.queryContact(nombre), Contacto.createContact(newNombre, tlf))) {
                            throw new Exception("\nError con los contactos, comprueba la agenda");
                        } else {
                            TelefonoMovil.updateContact(TelefonoMovil.queryContact(nombre), Contacto.createContact(newNombre, tlf));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("\n¡Listo!");
                    break;
                case "4":
                    System.out.print("\nNombre del contacto: ");
                    nombre = sc1.nextLine();
                    try {
                        if (!TelefonoMovil.removeContact(TelefonoMovil.queryContact(nombre))) {
                            throw new Exception("\nEl contacto con nombre '" + nombre + "' no existe");
                        } else {
                            TelefonoMovil.removeContact(TelefonoMovil.queryContact(nombre));
                            System.out.println("\n¡Listo!");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    System.out.print("\nNombre del contacto: ");
                    nombre = sc1.nextLine();
                    if (TelefonoMovil.queryContact(nombre) != null) {
                        System.out.println("\n" + TelefonoMovil.queryContact(nombre));
                    } else {
                        System.out.println("\nEl contacto con nombre '"+nombre+"' no existe");
                    }
                    break;
                case "6":
                    check = false;
                    break;
            }
        } while (check);
        System.out.println("¡Hasta la próxima!");
    }

    public static boolean tlfMatch(String tlf) {
        return tlf.matches("[0-9]{9}") || tlf.matches("([0-9]{3}\s){2}[0-9]{3}") || tlf.matches("[0-9]{3}\s([0-9]{2}\s){2}[0-9]{2}");
    }
}
