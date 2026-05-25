package com.example.demo.Trazabilidad;

import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.TramiteEntity;
import com.example.demo.Usuario.UsuarioEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "trazabilidades")
public class TrazabilidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trazabilidad")
    private Long idTrazabilidad;

    @ManyToOne
    @JoinColumn(name = "nro_tramite", nullable = false)
    private TramiteEntity tramite;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cambio", nullable = false)
    private EstadoTramite estadoCambio;

    @Column(name = "comentario", length = 500)
    private String comentario;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    public TrazabilidadEntity() {
    }

    public Long getIdTrazabilidad() {
        return idTrazabilidad;
    }

    public void setIdTrazabilidad(Long idTrazabilidad) {
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