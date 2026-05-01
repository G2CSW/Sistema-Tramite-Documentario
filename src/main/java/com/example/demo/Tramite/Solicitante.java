package com.example.demo.Tramite;

public class Solicitante {
    private String dni;
    private String nombreCompleto;
    private String correoElectronico;
    private String telefonoContacto;

    public Solicitante() {
    }

    public Solicitante(String dni, String nombreCompleto,
                       String correoElectronico, String telefonoContacto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.telefonoContacto = telefonoContacto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

