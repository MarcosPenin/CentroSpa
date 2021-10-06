/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métodos;

import POJOS.Spa;
import POJOS.Uso;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static métodos.CambioActividades.actividades;
import utilidades.ControlData;
import utilidades.Menu;

/**
 *
 * @author a20marcosgp
 */
public class AnadirUso {
     static Scanner sc=new Scanner(System.in);
          static Menu menuActividades = new Menu(actividades());
    static void añadirUso(Spa spa) {

        System.out.println("Introduzca el código del socio al que desea añadirle un uso ");
        String codigo = ControlData.lerString(sc);
        boolean flag = false;
        boolean flag2 = false;

        for (int i = 0; i < spa.getSocios().size(); i++) {
            if (codigo.equals(spa.getSocios().get(i).getCodigo())) {
                System.out.println("¿De qué actividad deseas añadir un uso?");
                menuActividades.printMenu();
                byte opcion = ControlData.lerByte(sc);
                menuActividades.rango(opcion);
                for (int j = 0; j < spa.getSocios().get(i).getActividades().size(); j++) {
                    flag = true;
                    if (opcion == spa.getSocios().get(i).getActividades().get(j).getCodigo()) {
                        flag2 = true;
                        System.out.println("Introduzca el año");
                        int ano = sc.nextInt();
                        System.out.println("Introduzca el mes");
                        int mes = sc.nextInt();
                        System.out.println("Introduzca el día");
                        int dia = sc.nextInt();

                        Date fecha = new Date(ano, mes, dia);

                        System.out.println("Introduzca la hora de inicio");
                        int horaInicio = sc.nextInt();
                        Time inicio = new Time(horaInicio, 0, 0);
                        System.out.println("Introduzca la hora de fin");
                        int horaFin = sc.nextInt();
                        Time fin = new Time(horaFin, 0, 0);

                        Uso elUso = new Uso(spa.getActividades().get(opcion - 1), fecha, inicio, fin);

                        spa.getSocios().get(i).añadirUso(elUso);

                    }
                }
                if (!flag2) {
                    System.out.println("Lo siento, para añadir usos primero debe registrar al socio en la actividad");
                }
            }
        }
        if (!flag) {
            System.out.println("Lo siento, no se ha encontrado ningún socio con ese código.");
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
