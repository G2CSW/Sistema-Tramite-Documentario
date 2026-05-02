package com.example.demo.Tramite;

public class EvaluacionTramite {
    private Tramite tramite;
    private Boolean datosCompletos;
    private Boolean datosConsistentes;
    private Boolean cumpleRequisitos;
    private Boolean sustentoValido;

    // Constructor vacío
    public EvaluacionTramite() {
    }

    // Constructor completo
    public EvaluacionTramite(Tramite tramite, Boolean datosCompletos,
                             Boolean datosConsistentes, Boolean cumpleRequisitos,
                             Boolean sustentoValido) {
        this.tramite = tramite;
        this.datosCompletos = datosCompletos;
        this.datosConsistentes = datosConsistentes;
        this.cumpleRequisitos = cumpleRequisitos;
        this.sustentoValido = sustentoValido;
    }

    // Getters y Setters
    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
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
