
package com.marcos.centrospa;

import java.util.ArrayList;

public class Spa {
    
    private String CIF;
    private String nombre;
    private ArrayList<Actividad> actividades=new ArrayList();
    private ArrayList<Socio> socios=new ArrayList();

    public Spa(String CIF, String nombre){
        this.CIF=CIF;
        this.nombre=nombre;
    }
    
    /**
     * @return the CIF
     */
    public String getCIF() {
        return CIF;
    }

    /**
     * @param CIF the CIF to set
     */
    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the actividades
     */
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    /**
     * @return the socios
     */
    public ArrayList<Socio> getSocios() {
        return socios;
    }

    /**
     * @param socios the socios to set
     */
    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }
    
    
}

   