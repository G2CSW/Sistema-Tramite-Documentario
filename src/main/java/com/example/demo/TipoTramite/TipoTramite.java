package com.example.demo.TipoTramite;

import java.time.LocalDate;

public class TipoTramite {

    private String idTipoTramite;
    private String nombre;
    private String documentacionMinima;
    private LocalDate fechaCreacion;

    public TipoTramite() {
    }

    public TipoTramite(String idTipoTramite, String nombre,
                       String documentacionMinima, LocalDate fechaCreacion) {
        this.idTipoTramite = idTipoTramite;
        this.nombre = nombre;
        this.documentacionMinima = documentacionMinima;
        this.fechaCreacion = fechaCreacion;
    }

    public String getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(String idTipoTramite) {
        this.idTipoTramite = idTipoTramite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentacionMinima() {
        return documentacionMinima;
    }

    public void setDocumentacionMinima(String documentacionMinima) {
        this.documentacionMinima = documentacionMinima;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
