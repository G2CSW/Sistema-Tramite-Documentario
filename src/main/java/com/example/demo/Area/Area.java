package com.example.demo.Area;

public class Area {
    private String idArea;
    private String nombreArea;

    // Constructor vacío
    public Area() {
    }

    // Constructor con parámetros
    public Area(String idArea, String nombreArea) {
        this.idArea = idArea;
        this.nombreArea = nombreArea;
    }

    // Getter y Setter de idArea
    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    // Getter y Setter de nombreArea
    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
}
