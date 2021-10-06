
package métodos;

import POJOS.Spa;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.ControlData;
import utilidades.Menu;

/**
 *
 * @author a20marcosgp
 */
public class CambioActividades {
     
    static Scanner sc=new Scanner(System.in);
          static Menu menuActividades = new Menu(actividades());
    public static void cambioActividades(Spa spa) {
        System.out.println("Introduzca el código del socio que desea modificar");
        String codigo = ControlData.lerString(sc);

        boolean flag = false;
        boolean flag2 = false;

        for (int i = 0; i < spa.getSocios().size(); i++) {
            if (codigo.equals(spa.getSocios().get(i).getCodigo())) {
                flag = true;
                System.out.println("¿Qué actividad desea añadir?");
                menuActividades.printMenu();
                byte opcion = ControlData.lerByte(sc);
                menuActividades.rango(opcion);

                for (int j = 0; j < spa.getSocios().get(i).getActividades().size(); j++) {
                    if (opcion == spa.getSocios().get(i).getActividades().get(j).getCodigo()) {
                        System.out.println("Ese socio ya está registrado en esa actividad");
                        flag2 = true;
                    }
                }
                if (!flag2) {
                    spa.getSocios().get(i).añadirActividad(spa.getActividades().get(opcion - 1));

                    System.out.println("La actividad se ha añadido con éxito");
                }
            }

        }
        if (!flag) {
            System.out.println("Lo siento, no se ha encontrado ningún socio con ese código");
        }
    }
    
    
       static ArrayList<String> actividades() {

        ArrayList<String> opciones = new ArrayList<String>() {
            {
                add("Aparatos");
                add("Jacuzzi");
                add("Piscina");
                add("Yoga");
                add("Pilates");
                add("Tenis");
                add("Padel");
            }
        };
        return opciones;
    }

}
