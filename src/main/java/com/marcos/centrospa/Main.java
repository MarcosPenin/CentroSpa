package com.marcos.centrospa;

import java.util.ArrayList;
import java.util.Scanner;
import utilidades.ControlData;
import utilidades.Menu;

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
                case 4 ->
                    consultaSocios();
                case 5 ->
                    consultaActividades();
            }
        } while (opcion != 6);
        sc.close();
    }

    static void altaSocios() {

        System.out.println("Introduzca el código del nuevo socio");
        String codigo = ControlData.lerString(sc);
        System.out.println("Introduzca el nombre del nuevo socio");
        String nombre = ControlData.lerString(sc);
        System.out.println("Introduzca la cuota fija del nuevo socio");
        float cuotaFija = ControlData.lerFloat(sc);

        if (spaRelax.getSocios().isEmpty()) {
            Socio socio = new Socio(codigo, nombre, cuotaFija);
            ArrayList<Socio> socios = new ArrayList();
            socios.add(socio);
            spaRelax.setSocios(socios);
            System.out.println("El socio se ha agregado a la base de datos");
        } else {

            boolean flag = false;
            for (int i = 0; i <= spaRelax.getSocios().size(); i++) {
                if (codigo.equals(spaRelax.getSocios().get(i).getCodigo())) {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("Lo siento, ya hay registrado un socio con ese código");
            } else {
                Socio socio = new Socio(codigo, nombre, cuotaFija);
                spaRelax.getSocios().add(socio);
                System.out.println("El socio se ha agregado a la base de datos");
            }
        }
    }

    static void cambioActividades() {
        System.out.println("Introduzca el código del socio que desea modificar");
        String codigo = ControlData.lerString(sc);

        for (int i = 0; i <= spaRelax.getSocios().size(); i++) {
            if (codigo == spaRelax.getSocios().get(i).getCodigo()) {
                System.out.println("¿Qué actividad desea añadir?");

                //Aquí habría que imprimir un menú con las actividades presentes en el ArrayList de Spa, dejando escoger y añadiendo
                System.out.println("Su actividade se ha añadido con éxito");
            } else {
                System.out.println("Lo siento, no hay registrado ningún socio con ese código");;
            }
        }
    }

    static void calculoCuota() {

        System.out.println("Introduzca el código del socio que desea consultar");
        String codigo = ControlData.lerString(sc);

        float cuotaTotal = 0;
        boolean flag = false;

        for (int i = 0; i < spaRelax.getSocios().size(); i++) {
            if (codigo.equals(spaRelax.getSocios().get(i).getCodigo())) {
                cuotaTotal = spaRelax.getSocios().get(i).getCuotaFija() + spaRelax.getSocios().get(i).getCuotaExtra();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Lo siento, no existe ningún socio con ese código");
        } else {
            System.out.println("La cuota de este socio es de " + cuotaTotal + "€.");
        }
    }

    static void consultaSocios() {
    }

    static void consultaActividades() {
    }

    static ArrayList<String> opciones() {

        ArrayList<String> opciones = new ArrayList<String>() {
            {
                add("Alta de socios");
                add("Cambio de actividades");
                add("Cálculo cuota anual");
                add("Consultar el listado de socios agregados");
                add("Consultar el listado de actividades disponibles");
                add("Finalizar");
            }
        };
        return opciones;
    }

    static {
        Actividad aparatos = new Actividad("1", 0);
        Actividad jacuzzi = new Actividad("1", 0);
        Actividad piscina = new Actividad("1", 0);

        Actividad yoga = new Actividad("2", 2);
        Actividad pilates = new Actividad("2", 2);

        Actividad tenis = new Actividad("3", 3);
        Actividad padel = new Actividad("3", 3);

        ArrayList<Actividad> actividades = new ArrayList();

        actividades.add(aparatos);
        actividades.add(jacuzzi);
        actividades.add(piscina);
        actividades.add(yoga);
        actividades.add(pilates);
        actividades.add(tenis);
        actividades.add(yoga);

        Socio socio1 = new Socio("1", "Juan", 30);
        Socio socio2 = new Socio("2", "Ana", 30);
        Socio socio3 = new Socio("3", "Javier", 30);
        Socio socio4 = new Socio("4", "Claudia", 30);
        Socio socio5 = new Socio("5", "Pepe", 30);
        Socio socio6 = new Socio("6", "María", 30);

        ArrayList<Socio> socios = new ArrayList();

        socios.add(socio1);
        socios.add(socio2);
        socios.add(socio3);
        socios.add(socio4);
        socios.add(socio5);
        socios.add(socio6);

        spaRelax.setActividades(actividades);
        spaRelax.setSocios(socios);
    }

}
