package com.example.demo.TipoTramite;

import java.time.LocalDate;

public class TipoTramite {

    private String idTipoTramite;
    private String nombre;
    private String documentacionMinima;
    private LocalDate fechaCreacion;
    private boolean activo;

    public TipoTramite() {
    }

    public TipoTramite(String idTipoTramite, String nombre,
                       String documentacionMinima, LocalDate fechaCreacion) {
        this.idTipoTramite = idTipoTramite;
        this.nombre = nombre;
        this.documentacionMinima = documentacionMinima;
        this.fechaCreacion = fechaCreacion;
        this.activo = true;
    }

    public String getIdTipoTramite() {
        return this.idTipoTramite;
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
        return this.documentacionMinima;
    }

    public void setDocumentacionMinima(String documentacionMinima) {
        this.documentacionMinima = documentacionMinima;
    }

    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isActivo(){ return this.activo; }

    public void setActivo(boolean activo){ this.activo = activo; }
}
