
package com.marcos.centrospa;

public class Actividad {
    private int codigo;
    private String tipo;
    private float cuota;
    
    public Actividad(int codigo, String tipo, float cuota){        
        this.codigo=codigo;
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

    @Override
    public String toString() {
        return "Actividad{" + "tipo=" + tipo + ", cuota=" + cuota + '}';
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}


