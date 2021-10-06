
package métodos;

import POJOS.Spa;
import java.util.Scanner;
import utilidades.ControlData;

/**
 *
 * @author a20marcosgp
 */
public class CalculoCuota {
    
    static Scanner sc=new Scanner(System.in);
    
    
   public static void calculoCuota(Spa spa) {

        System.out.println("Introduzca el código del socio que desea consultar");
        String codigo = ControlData.lerString(sc);

        float cuotaTotal = 0;
        boolean flag = false;

        for (int i = 0; i < spa.getSocios().size(); i++) {
            if (codigo.equals(spa.getSocios().get(i).getCodigo())) {
                cuotaTotal = spa.getSocios().get(i).getCuotaFija() + spa.getSocios().get(i).calcularCuotaExtra();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Lo siento, no existe ningún socio con ese código");
        } else {
            System.out.println("La cuota de este socio es de " + cuotaTotal + "€.");
        }
    }

    
    
}
