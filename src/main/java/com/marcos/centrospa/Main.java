package com.marcos.centrospa;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import utilidades.ControlData;
import utilidades.Menu;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static byte opcion, opcion2, opcion3;
    static Menu miMenu = new Menu(opciones());
    static Menu menuActividades = new Menu(actividades());
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
                    bajaSocios();
                case 3 ->
                    cambioActividades();
                case 4 ->
                    añadirUso();
                case 5 ->
                    calculoCuota();
                case 6 ->
                    consultaSocios();
                case 7 ->
                    consultaActividades();
            }
        } while (opcion != 8);
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
            for (int i = 0; i < spaRelax.getSocios().size(); i++) {
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

    static void bajaSocios() {
        System.out.println("Introduzca el código del socio que desea eliminar");
        String codigo = ControlData.lerString(sc);
        boolean flag = false;

        for (int i = 0; i < spaRelax.getSocios().size(); i++) {
            if (codigo.equals(spaRelax.getSocios().get(i).getCodigo())) {
                spaRelax.getSocios().remove(i);
                System.out.println("Se ha eliminado el socio con el código " + codigo);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Lo siento, no se ha encontrado ningún socio con ese código");
        }

    }

    static void cambioActividades() {
        System.out.println("Introduzca el código del socio que desea modificar");
        String codigo = ControlData.lerString(sc);

        for (int i = 0; i <= spaRelax.getSocios().size(); i++) {
            if (codigo.equals(spaRelax.getSocios().get(i).getCodigo())) {
                System.out.println("¿Qué actividad desea añadir?");
                menuActividades.printMenu();
                opcion = ControlData.lerByte(sc);
                menuActividades.rango(opcion);
                spaRelax.getSocios().get(i).añadirActividad(spaRelax.getActividades().get(opcion - 1));
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

    
    
    
    //ESTABA CON ESTO
    
    static void añadirUso() {

        System.out.println("Introduzca el código del socio al que desea añadirle un uso ");
        String codigo = ControlData.lerString(sc);
        boolean flag = false;

        for (int i = 0; i < spaRelax.getSocios().size(); i++) {
            if (codigo.equals(spaRelax.getSocios().get(i).getCodigo())) {
                System.out.println("¿De qué actividad deseas añadir un uso?");
                menuActividades.printMenu();
                opcion = ControlData.lerByte(sc);
                menuActividades.rango(opcion);
                for(int j=0;j<spaRelax.getSocios().get(i).getActividades().size();i++){
                    if(opcion == spaRelax.getSocios().get(i).getActividades().get(j).getCodigo()){
                        System.out.println("Introduzca el año");
                        System.out.println("Introduzca el mes");
                        System.out.println("Introduzca el día");
                        
                        
                        
                        System.out.println("Introduzca la hora de inicio");
                        System.out.println("Introduzca la hora de fin");
                        
                        
                        flag=true;
                        
                        
                        
                    }
                    
                }
                    
            }
        }
        if(!flag){
            System.out.println("Lo siento, para añadir usos primero debe registrar al socio en la actividad");
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

    static {
        Actividad aparatos = new Actividad(1,"libre", 0);
        Actividad jacuzzi = new Actividad(2,"libre", 0);
        Actividad piscina = new Actividad(3,"libre", 0);

        Actividad yoga = new Actividad(4,"grupo", 2);
        Actividad pilates = new Actividad(5,"grupo", 2);

        Actividad tenis = new Actividad(6,"pista", 4);
        Actividad padel = new Actividad(7,"pista", 4);

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
