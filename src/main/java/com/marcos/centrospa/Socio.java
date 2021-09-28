package com.marcos.centrospa;

import java.util.ArrayList;

public class Socio {

    private String codigo;
    private String nombre;
    private float cuotaFija;
    private float cuotaExtra;
    private ArrayList<Actividad> actividades;
    private ArrayList<Uso> usos;

    public Socio(String codigo, String nombre, float cuotaFija) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuotaFija = cuotaFija;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the cuotaFija
     */
    public float getCuotaFija() {
        return cuotaFija;
    }

    /**
     * @param cuotaFija the cuotaFija to set
     */
    public void setCuotaFija(float cuotaFija) {
        this.cuotaFija = cuotaFija;
    }

    /**
     * @return the usos
     */
    public ArrayList<Uso> getUsos() {
        return usos;
    }

    /**
     * @param usos the usos to set
     */
    public void setUsos(ArrayList<Uso> usos) {
        this.usos = usos;
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
     * @return the cuotaExtra
     */
    public float getCuotaExtra() {
        return cuotaExtra;
    }

    public float calcularCuotaExtra(){
        float cuotaExtra=0;
        for(int i=0;i<=this.getUsos().size();i++){
            cuotaExtra+=this.getUsos().get(i).calcularImporte();
        }
        return cuotaExtra;        
        
    }


}
