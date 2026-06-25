package com.example.demo.Tramite;

import com.example.demo.Solicitante.Solicitante;
import com.example.demo.TipoTramite.TipoTramite;

import java.time.LocalDate;

public class Tramite {
    private Long nroTramite;
    private TipoTramite tipoTramite;
    private Solicitante solicitante;
    private LocalDate fechaRegistro;
    private EstadoTramite estadoActual;

    // Campos relacionados a la evaluacion
    private Boolean datosCompletos;
    private Boolean datosConsistentes;
    private Boolean cumpleRequisitos;
    private Boolean sustentoValido;

    public Tramite() {
    }

    public Tramite(Long nroTramite, TipoTramite tipoTramite, Solicitante solicitante,
                   LocalDate fechaRegistro, EstadoTramite estadoActual,
                   Boolean datosCompletos, Boolean datosConsistentes,
                   Boolean cumpleRequisitos, Boolean sustentoValido) {
        this.nroTramite = nroTramite;
        this.tipoTramite = tipoTramite;
        this.solicitante = solicitante;
        this.fechaRegistro = fechaRegistro;
        this.estadoActual = estadoActual;
        this.datosCompletos = datosCompletos;
        this.datosConsistentes = datosConsistentes;
        this.cumpleRequisitos = cumpleRequisitos;
        this.sustentoValido = sustentoValido;
    }

    public Long getNroTramite() {
        return nroTramite;
    }

    public void setNroTramite(Long nroTramite) {
        this.nroTramite = nroTramite;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
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

    public Boolean getDatosCompletos() {
        return datosCompletos;
    }

    public void setDatosCompletos(Boolean datosCompletos) {
        this.datosCompletos = datosCompletos;
    }

    public Boolean getDatosConsistentes() {
        return datosConsistentes;
    }

    public void setDatosConsistentes(Boolean datosConsistentes) {
        this.datosConsistentes = datosConsistentes;
    }

    public Boolean getCumpleRequisitos() {
        return cumpleRequisitos;
    }

    public void setCumpleRequisitos(Boolean cumpleRequisitos) {
        this.cumpleRequisitos = cumpleRequisitos;
    }

    public Boolean getSustentoValido() {
        return sustentoValido;
    }

    public void setSustentoValido(Boolean sustentoValido) {
        this.sustentoValido = sustentoValido;
    }
}
