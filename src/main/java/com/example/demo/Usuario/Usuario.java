package com.example.demo.Usuario;

import com.example.demo.Area.Area;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String correoElectronico;
    private String password;
    private Area area;
    private boolean activo;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nombre, String correoElectronico,
                   String password, Area area, boolean activo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.area = area;
        this.activo = activo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public boolean getEstado() {
        return activo;
    }

    public void setEstado(boolean activo) {
        this.activo = activo;
    }
}