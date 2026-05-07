package com.example.demo.Documento;

public class Documento {

    private Long idDocumento;
    private String nombreDocumento;
    private boolean activo = true;

    public Documento() {
    }

    public Documento(Long idDocumento, String nombreDocumento) {
        this.idDocumento = idDocumento;
        this.nombreDocumento = nombreDocumento;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}