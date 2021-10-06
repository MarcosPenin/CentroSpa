package com.marcos.centrospa;

import POJOS.Spa;
import POJOS.Uso;
import POJOS.Actividad;
import POJOS.Socio;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import métodos.AltaSocio;
import métodos.AnadirUso;
import métodos.BajaSocio;
import métodos.CalculoCuota;
import métodos.CambioActividades;
import métodos.Consultas;
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
                    AltaSocio.altaSocios(spaRelax);
                case 2 ->
                    BajaSocio.bajaSocios(spaRelax);
                case 3 ->                   
                    CambioActividades.cambioActividades(spaRelax);
                case 4 ->
                    AnadirUso.añadirUso(spaRelax);
                case 5 ->
                    CalculoCuota.calculoCuota(spaRelax);
                case 6 ->
                    Consultas.consultaSocios(spaRelax);
                case 7 ->
                    Consultas.consultaActividades(spaRelax);
            }
        } while (opcion != 8);
        sc.close();
    }


    static ArrayList<String> opciones() {

        ArrayList<String> opciones = new ArrayList<String>() {
            {
                add("Alta de socios");
                add("Baja de socios");
                add("Añadir una actividad");
                add("Añadir un uso");
                add("Cálculo cuota anual");
                add("Consultar el listado de socios agregados");
                add("Consultar el listado de actividades disponibles");
                add("Finalizar");
            }
        };
        return opciones;
    }

    static {
        Actividad aparatos = new Actividad("Aparatos", 1, "libre", 0);
        Actividad jacuzzi = new Actividad("Jacuzzi", 2, "libre", 0);
        Actividad piscina = new Actividad("Piscina", 3, "libre", 0);

        Actividad yoga = new Actividad("Yoga", 4, "grupo", 2);
        Actividad pilates = new Actividad("Pilates", 5, "grupo", 2);

        Actividad tenis = new Actividad("Tenis", 6, "pista", 4);
        Actividad padel = new Actividad("Pádel", 7, "pista", 4);

        ArrayList<Actividad> actividades = new ArrayList();

        actividades.add(aparatos);
        actividades.add(jacuzzi);
        actividades.add(piscina);
        actividades.add(yoga);
        actividades.add(pilates);
        actividades.add(tenis);
        actividades.add(padel);

        Socio socio1 = new Socio("1", "Juan", 30);
        Socio socio2 = new Socio("2", "Ana", 30);
        Socio socio3 = new Socio("3", "Javier", 30);
        Socio socio4 = new Socio("4", "Claudia", 30);
        Socio socio5 = new Socio("5", "Pepe", 30);
        Socio socio6 = new Socio("6", "María", 30);

        socio1.añadirActividad(aparatos);
        socio2.añadirActividad(jacuzzi);
        socio3.añadirActividad(piscina);
        socio4.añadirActividad(yoga);
        socio5.añadirActividad(tenis);
        socio6.añadirActividad(padel);

        Uso uso1 = new Uso(aparatos, new Date(2000, 11, 1), new Time(18, 0, 0), new Time(19, 0, 0));
        Uso uso2 = new Uso(piscina, new Date(2000, 11, 1), new Time(19, 0, 0), new Time(21, 0, 0));
        Uso uso3 = new Uso(yoga, new Date(2000, 12, 22), new Time(12, 0, 0), new Time(15, 0, 0));
        Uso uso4 = new Uso(pilates, new Date(2000, 11, 11), new Time(18, 0, 0), new Time(20, 0, 0));
        Uso uso5 = new Uso(tenis, new Date(2000, 11, 21), new Time(18, 0, 0), new Time(19, 0, 0));
        Uso uso6 = new Uso(padel, new Date(2000, 9, 9), new Time(11, 0, 0), new Time(12, 0, 0));

        socio1.añadirUso(uso1);
        socio1.añadirUso(uso2);
        socio2.añadirUso(uso3);
        socio2.añadirUso(uso4);
        socio3.añadirUso(uso5);
        socio3.añadirUso(uso6);

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
