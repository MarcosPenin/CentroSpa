
package com.marcos.centrospa;

public class Actividad {
    private String tipo;
    private float cuota;
    
    public Actividad(String tipo, float cuota){
        this.tipo=tipo;
        this.cuota=cuota;       
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cuota
     */
    public float getCuota() {
        return cuota;
    }

    /**
     * @param cuota the cuota to set
     */
    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

}
