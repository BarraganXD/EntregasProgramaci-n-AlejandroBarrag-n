import java.sql.SQLOutput;
import java.util.ArrayList;

public class TelefonoMovil {
    private static ArrayList<Contacto> myContacts = new ArrayList<Contacto>();

    private static int findContact (Contacto obj) {
        return myContacts.indexOf(obj);
    }

    private static int findContact (String objNombre) {
        for (int i = 0; i < myContacts.size() ;i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(objNombre)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean addNewContact (Contacto obj) {
        if (findContact(obj.getName()) != -1) {
            return false;
        } else {
            myContacts.add(obj);
            return true;
        }
    }

    public static boolean updateContact (Contacto antiguo, Contacto nuevo) {
        if (findContact(antiguo) != -1 && findContact(nuevo) == -1) {
            myContacts.set(findContact(antiguo), nuevo);
            return true;
        } else {
            return false;
        }
    }

    public static boolean removeContact (Contacto obj) {
        if (findContact(obj) != 1 && obj != null) {
            myContacts.remove(obj);
            return true;
        } else {
            return false;
        }
    }

    public static Contacto queryContact (String name) {
        if (findContact(name) != -1) {
            return myContacts.get(findContact(name));
        } else {
            return null;
        }
    }

    public static void printContacts () {
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(i+1 + ". " + myContacts.get(i).getName() + " » " + myContacts.get(i).getPhoneNumber());
        }
    }
}
