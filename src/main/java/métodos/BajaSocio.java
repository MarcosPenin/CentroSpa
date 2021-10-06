
package métodos;

import POJOS.Spa;
import java.util.Scanner;
import utilidades.ControlData;

public class BajaSocio {
    
    
    static Scanner sc=new Scanner(System.in);
    
       public  static void bajaSocios(Spa spa) {
        System.out.println("Introduzca el código del socio que desea eliminar");
        String codigo = ControlData.lerString(sc);
        boolean flag = false;

        for (int i = 0; i < spa.getSocios().size(); i++) {
            if (codigo.equals(spa.getSocios().get(i).getCodigo())) {
                spa.getSocios().remove(i);
                System.out.println("Se ha eliminado el socio con el código " + codigo);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Lo siento, no se ha encontrado ningún socio con ese código");
        }

    }
    
    
    
}
