package com.example.demo.Tramite;

import com.example.demo.TipoTramite.TipoTramite;
import com.example.demo.Usuario.Usuario;

import java.time.LocalDate;

public class Tramite {
    private String nroTramite;
    private TipoTramite tipoTramite;
    private Usuario usuario;
    private Solicitante solicitante;
    private LocalDate fechaRegistro;
    private EstadoTramite estadoActual;

    // Constructor vacío
    public Tramite() {
    }

    public Tramite(String nroTramite, TipoTramite tipoTramite, Usuario usuario, Solicitante solicitante,
                   LocalDate fechaRegistro, EstadoTramite estadoActual) {
        this.nroTramite = nroTramite;
        this.tipoTramite = tipoTramite;
        this.usuario = usuario;
        this.solicitante = solicitante;
        this.fechaRegistro = fechaRegistro;
        this.estadoActual = estadoActual;
    }

    // Getters y Setters
    public String getNroTramite() {
        return nroTramite;
    }

    public void setNroTramite(String nroTramite) {
        this.nroTramite = nroTramite;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoTramite getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoTramite estadoActual) {
        this.estadoActual = estadoActual;
    }
}
