package com.example.demo.Tramite;

public class EvaluacionTramite {
    private String tramiteId;
    private Boolean datosCompletos;
    private Boolean datosConsistentes;
    private Boolean cumpleRequisitos;
    private Boolean sustentoValido;

    // Constructor vacío
    public EvaluacionTramite() {
    }

    // Constructor completo
    public EvaluacionTramite(String tramiteId, Boolean datosCompletos,
                             Boolean datosConsistentes, Boolean cumpleRequisitos,
                             Boolean sustentoValido) {
        this.tramiteId = tramiteId;
        this.datosCompletos = datosCompletos;
        this.datosConsistentes = datosConsistentes;
        this.cumpleRequisitos = cumpleRequisitos;
        this.sustentoValido = sustentoValido;
    }

    // Getters y Setters
    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
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
