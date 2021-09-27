
package com.marcos.centrospa;

import java.util.ArrayList;

public class Spa {
    
    private String CIF;
    private String nombre;
    private ArrayList<> Actividades;
    private ArrayList<> Socios;

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
     * @return the Actividades
     */
    public ArrayList<> getActividades() {
        return Actividades;
    }

    /**
     * @param Actividades the Actividades to set
     */
    public void setActividades(ArrayList<> Actividades) {
        this.Actividades = Actividades;
    }

    /**
     * @return the Socios
     */
    public ArrayList<> getSocios() {
        return Socios;
    }

    /**
     * @param Socios the Socios to set
     */
    public void setSocios(ArrayList<> Socios) {
        this.Socios = Socios;
    }
    
    
    
}
