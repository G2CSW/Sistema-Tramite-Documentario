package com.example.demo.Tramite;

public class Solicitante {
    private String idSolicitante;
    private String nombreCompleto;
    private String correoElectronico;
    private String telefonoContacto;

    public Solicitante() {
    }

    public Solicitante(String idSolicitante, String nombreCompleto,
                       String correoElectronico, String telefonoContacto) {
        this.idSolicitante = idSolicitante;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.telefonoContacto = telefonoContacto;
    }

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}

