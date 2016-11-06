package com.unistmo.geographygame;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by cosijopii on 02/11/16.
 */

public class Pais implements Serializable{

    private String nombrePais;
    private LatLng latLng;
    private int id;

    public Pais(String nombrePais, LatLng latLng, int id) {
        this.nombrePais = nombrePais;
        this.latLng = latLng;
        this.id = id;
    }

    public Pais(Pais pais) {
        this.nombrePais = pais.getNombrePais();
        this.latLng = pais.getLatLng();
        this.id = pais.getId();
    }

    public Pais() {
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nombrePais='" + nombrePais + '\'' +
                ", latLng=" + latLng +
                ", id=" + id +
                '}';
    }

}
