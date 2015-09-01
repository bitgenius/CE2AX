package com.example.ce2ax;

import java.io.Serializable;

/**
 * Created by FYF on 30/08/2015.
 */
public class Etiqueta implements Serializable
{

    String calificacion;
    String tipo;
    String potencia;
    String calle;
    String observaciones;
    String superficie,em,e,emin,er,ie,ice;

    public Etiqueta()
    {

    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getEmin() {
        return emin;
    }

    public void setEmin(String emin) {
        this.emin = emin;
    }

    public String getEr() {
        return er;
    }

    public void setEr(String er) {
        this.er = er;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    @Override
    public String toString() {
        return (this.calle+"\nClasificación: "+this.calificacion);
    }

}
