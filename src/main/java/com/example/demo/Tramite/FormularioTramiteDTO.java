// FormularioTramiteDTO.java

package com.example.demo.Tramite;

import com.example.demo.TipoTramite.TipoTramite;

import java.util.List;

public class FormularioTramiteDTO {

    private Tramite tramite;

    private Solicitante solicitante;

    private TipoTramite tipoSeleccionado;

    private List<TipoTramite> tipoTramites;

    private String tipoId;

    private String idSolicitante;

    private boolean existeSolicitante;

    private String numeroTramite;

    public FormularioTramiteDTO() {
    }

    public FormularioTramiteDTO(
            Tramite tramite,
            Solicitante solicitante,
            TipoTramite tipoSeleccionado,
            List<TipoTramite> tipoTramites,
            String tipoId,
            String idSolicitante,
            boolean existeSolicitante,
            String numeroTramite) {

        this.tramite = tramite;
        this.solicitante = solicitante;
        this.tipoSeleccionado = tipoSeleccionado;
        this.tipoTramites = tipoTramites;
        this.tipoId = tipoId;
        this.idSolicitante = idSolicitante;
        this.existeSolicitante = existeSolicitante;
        this.numeroTramite = numeroTramite;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public TipoTramite getTipoSeleccionado() {
        return tipoSeleccionado;
    }

    public void setTipoSeleccionado(TipoTramite tipoSeleccionado) {
        this.tipoSeleccionado = tipoSeleccionado;
    }

    public List<TipoTramite> getTipoTramites() {
        return tipoTramites;
    }

    public void setTipoTramites(List<TipoTramite> tipoTramites) {
        this.tipoTramites = tipoTramites;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public boolean isExisteSolicitante() {
        return existeSolicitante;
    }

    public void setExisteSolicitante(boolean existeSolicitante) {
        this.existeSolicitante = existeSolicitante;
    }

    public String getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(String numeroTramite) {
        this.numeroTramite = numeroTramite;
    }
}