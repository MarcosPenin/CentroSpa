package com.marcos.centrospa;

import java.sql.Time;
import java.util.Date;

public class Uso {

    private Actividad actividad;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;
    private float importeTotal;

    public Uso(Actividad actividad, Date fecha, Time horaInicio, Time horaFin) {
        this.actividad = actividad;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     * @return the actividad
     */
    public Actividad getActividad() {
        return actividad;
    }

    /**
     * @param actividad the actividad to set
     */
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horaInicio
     */
    public Time getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public Time getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * @return the importeTotal
     */
    public float getImporteTotal() {
        return importeTotal;
    }

    public float calcularImporte() {

        this.importeTotal = this.actividad.getCuota() * (this.horaFin.toLocalTime().getHour() - this.horaInicio.toLocalTime().getHour());
        return importeTotal;
    }

}
