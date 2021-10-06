
package métodos;

import POJOS.Spa;

/**
 *
 * @author a20marcosgp
 */
public class Consultas {
    public static void consultaSocios(Spa spa) {

        for (int i = 0; i < spa.getSocios().size(); i++) {
            System.out.println(spa.getSocios().get(i).toString());
        }

    }

    public static void consultaActividades(Spa spa) {

        for (int i = 0; i < spa.getActividades().size(); i++) {
            System.out.println(spa.getActividades().get(i).toString());

        }

    }
}
