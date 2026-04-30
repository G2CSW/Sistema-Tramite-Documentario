package com.example.demo.Tramite;

public enum EstadoTramite {
    REGISTRADO,
    EN_EVALUACION,
    APROBADO,
    RECHAZADO,
    ARCHIVADO,
    CANCELADO;

    public boolean puedeEditar() {
        return this == REGISTRADO;
    }

    public boolean puedeDerivar() {
        return this == REGISTRADO;
    }

    public boolean puedeCancelar() {
        return this == REGISTRADO || this == EN_EVALUACION;
    }

    public boolean puedeArchivar() {
        return this == APROBADO || this == RECHAZADO;
    }

    public boolean puedeVer() {
        return true;
    }

    public String getNombre() {
        switch (this) {
            case REGISTRADO: return "Registrado";
            case EN_EVALUACION: return "En evaluación";
            case APROBADO: return "Aprobado";
            case RECHAZADO: return "Rechazado";
            case ARCHIVADO: return "Archivado";
            case CANCELADO: return "Cancelado";
            default: return "";
        }
    }
}
