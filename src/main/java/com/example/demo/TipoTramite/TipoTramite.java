package com.example.demo.TipoTramite;

import com.example.demo.Documento.Documento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TipoTramite {

    private String idTipoTramite;
    private String nombre;
    private List<Documento> documentacionMinima = new ArrayList<>();
    private LocalDate fechaCreacion;
    private boolean activo;

    public TipoTramite() {
    }

    public TipoTramite(String idTipoTramite,
                       String nombre,
                       List<Documento> documentacionMinima,
                       LocalDate fechaCreacion) {

        this.idTipoTramite = idTipoTramite;
        this.nombre = nombre;
        this.documentacionMinima = documentacionMinima;
        this.fechaCreacion = fechaCreacion;
        this.activo = true;
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

    public List<Documento> getDocumentacionMinima() {
        return documentacionMinima;
    }

    public void setDocumentacionMinima(List<Documento> documentacionMinima) {
        this.documentacionMinima = documentacionMinima;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}