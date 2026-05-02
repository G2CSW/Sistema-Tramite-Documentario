package com.example.demo.Tramite;

import com.example.demo.Usuario.Usuario;

import java.time.LocalDateTime;

public class Trazabilidad {

    private String idTrazabilidad;
    private Tramite tramite;
    private Usuario usuario;
    private EstadoTramite estadoCambio;
    private String comentario;
    private LocalDateTime fechaHora;

    public Trazabilidad() {
    }

    public Trazabilidad(String idTrazabilidad, Tramite tramite, Usuario usuario,
                        EstadoTramite estadoCambio, String comentario, LocalDateTime fechaHora) {
        this.idTrazabilidad = idTrazabilidad;
        this.tramite = tramite;
        this.usuario = usuario;
        this.estadoCambio = estadoCambio;
        this.comentario = comentario;
        this.fechaHora = fechaHora;
    }

    public String getIdTrazabilidad() {
        return idTrazabilidad;
    }

    public void setIdTrazabilidad(String idTrazabilidad) {
        this.idTrazabilidad = idTrazabilidad;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoTramite getEstadoCambio() {
        return estadoCambio;
    }

    public void setEstadoCambio(EstadoTramite estadoCambio) {
        this.estadoCambio = estadoCambio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getFechaHoraFormateada() {
        return fechaHora.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}