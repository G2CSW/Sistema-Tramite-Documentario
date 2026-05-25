package com.example.demo.Tramite;

import com.example.demo.Usuario.UsuarioEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "trazabilidades")
public class TrazabilidadEntity {

    @Id
    @Column(name = "id_trazabilidad")
    private String idTrazabilidad;

    @ManyToOne
    @JoinColumn(name = "nro_tramite")
    private TramiteEntity tramite;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cambio")
    private EstadoTramite estadoCambio;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    public TrazabilidadEntity() {
    }

    public TrazabilidadEntity(String idTrazabilidad, TramiteEntity tramite, UsuarioEntity usuario,
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

    public TramiteEntity getTramite() {
        return tramite;
    }

    public void setTramite(TramiteEntity tramite) {
        this.tramite = tramite;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
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
}
