/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métodos;

import POJOS.Socio;
import POJOS.Spa;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.ControlData;

/**
 *
 * @author a20marcosgp
 */
public class AltaSocio {
    
    static Scanner sc=new Scanner(System.in);
    
    
    public static void altaSocios(Spa spa) {

        System.out.println("Introduzca el código del nuevo socio");
        String codigo = ControlData.lerString(sc);
        System.out.println("Introduzca el nombre del nuevo socio");
        String nombre = ControlData.lerString(sc);
        System.out.println("Introduzca la cuota fija del nuevo socio");
        float cuotaFija = ControlData.lerFloat(sc);

        if (spa.getSocios().isEmpty()) {
            Socio socio = new Socio(codigo, nombre, cuotaFija);
            ArrayList<Socio> socios = new ArrayList();
            socios.add(socio);
            spa.setSocios(socios);
            System.out.println("El socio se ha agregado a la base de datos");
        } else {

            boolean flag = false;
            for (int i = 0; i < spa.getSocios().size(); i++) {
                if (codigo.equals(spa.getSocios().get(i).getCodigo())) {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("Lo siento, ya hay registrado un socio con ese código");
            } else {
                Socio socio = new Socio(codigo, nombre, cuotaFija);
                spa.getSocios().add(socio);
                System.out.println("El socio se ha agregado a la base de datos");
            }
        }
    }
}
