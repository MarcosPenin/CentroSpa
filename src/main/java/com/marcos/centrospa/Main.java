/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcos.centrospa;

import java.util.ArrayList;
import java.util.Scanner;
import utilidades.ControlData;
import utilidades.Menu;

/**
 *
 * @author a20marcosgp
 */
public class Main {

    static Scanner sc = new Scanner(System.in);
    static byte opcion, opcion2, opcion3;
    static Menu miMenu = new Menu(opciones());
    static Spa spaRelax = new Spa("1", "Relax S.L");

    public static void main(String[] args) {

        System.out.println("*********************************************************************************************");
        System.out.println("*******************************BIENVENIDO AL SPA RELAX S.L.*********************************");

        do {
            System.out.println("*********************************************************************************************");
            System.out.println("¿Qué operación desea realizar?");
            miMenu.printMenu();
            opcion = ControlData.lerByte(sc);
            miMenu.rango(opcion);

            switch (opcion) {
                case 1 ->
                    altaSocios();
                case 2 ->
                    cambioActividades();
                case 3 ->
                    calculoCuota();
            }
        } while (opcion != 4);
        sc.close();
    }

    static String altaSocios() {

        System.out.println("Introduzca el código del nuevo socio");
        String codigo = ControlData.lerString(sc);
        System.out.println("Introduzca el nombre del nuevo socio");
        String nombre = ControlData.lerString(sc);
        System.out.println("Introduzca el nombre del nuevo socio");
        float cuotaFija = ControlData.lerFloat(sc);

        boolean flag = false;
        for (int i = 0; i < spaRelax.getSocios().size(); i++) {
            if (codigo == spaRelax.getSocios().get(i).getCodigo()) {
                flag = true;
            }
        }
        if (flag) {
            return "Lo siento, ya hay registrado un socio con ese código";
        } else {
            Socio socio = new Socio(codigo, nombre, cuotaFija);
            spaRelax.getSocios().add(socio);
            return "El socio con el código " + codigo + " se ha agregado a la base de datos";
        }
    }

    static String cambioActividades() {

        String respuesta = "";
        System.out.println("Introduzca el código del socio que desea modificar");
        String codigo = ControlData.lerString(sc);

        for (int i = 0; i < spaRelax.getSocios().size(); i++) {
            if (codigo == spaRelax.getSocios().get(i).getCodigo()) {
                System.out.println("¿Qué actividad desea añadir?");

                //Aquí habría que imprimir un menú con las actividades presentes en el ArrayList de Spa, dejando escoger y añadiendo
                respuesta = "Su actividade se ha añadido con éxito";

            } else {
                respuesta = "Lo siento, no hay registrado ningún socio con ese código";
            }

        }
        return respuesta;
    }

    static String calculoCuota() {

        System.out.println("Introduzca el código del socio que desea consultar");
        String codigo = ControlData.lerString(sc);
        String respuesta="";
        float cuotaTotal = 0;
        boolean flag = false;

        for (int i = 0; i < spaRelax.getSocios().size(); i++) {
            if (codigo == spaRelax.getSocios().get(i).getCodigo()) {
                cuotaTotal = spaRelax.getSocios().get(i).getCuotaFija() + spaRelax.getSocios().get(i).getCuotaExtra();
                flag = true;
            }

            if (flag) {
                respuesta="Lo siento, no existe ningún socio con ese código";
            }else{
                respuesta="La cuota de este socio es de " + cuotaTotal + "€.";
            }
        }
        return respuesta;
    }
    

    static ArrayList<String> opciones() {

        ArrayList<String> opciones = new ArrayList<String>() {
            {
                add("Alta de socios");
                add("Cambio de actividades");
                add("Cálculo cuota anual");
                add("Finalizar");
            }
        };
        return opciones;
    }

}
