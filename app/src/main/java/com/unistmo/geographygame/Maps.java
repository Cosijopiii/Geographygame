package com.unistmo.geographygame;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by cosijopii on 13/02/17.
 */

public class Maps {
   private int id;
    private String nombre;
    private String capital;
    private double lat;
    private double log;
    private String continente;

    public Maps(int id, String nombre, String capital, double lat, double log, String continente) {
        this.id = id;
        this.nombre = nombre;
        this.capital = capital;
        this.lat = lat;
        this.log = log;
        this.continente = continente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        return "Maps{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", capital='" + capital + '\'' +
                ", lat=" + lat +
                ", log=" + log +
                ", continente='" + continente + '\'' +
                '}';
    }
}
