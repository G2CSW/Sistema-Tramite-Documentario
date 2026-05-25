package com.example.demo.Tramite;

import com.example.demo.Solicitante.SolicitanteEntity;
import com.example.demo.TipoTramite.TipoTramiteEntity;
import com.example.demo.Usuario.UsuarioEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tramites")
public class TramiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_tramite")
    private Long nroTramite;

    @ManyToOne
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramiteEntity tipoTramite;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_solicitante")
    private SolicitanteEntity solicitante;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_actual")
    private EstadoTramite estadoActual;

    @Column(name = "datos_completos")
    private Boolean datosCompletos;

    @Column(name = "datos_consistentes")
    private Boolean datosConsistentes;

    @Column(name = "cumple_requisitos")
    private Boolean cumpleRequisitos;

    @Column(name = "sustento_valido")
    private Boolean sustentoValido;

    public TramiteEntity() {
    }

    public TramiteEntity(Long nroTramite, TipoTramiteEntity tipoTramite, UsuarioEntity usuario,
                         SolicitanteEntity solicitante, LocalDate fechaRegistro,
                         EstadoTramite estadoActual, Boolean datosCompletos,
                         Boolean datosConsistentes, Boolean cumpleRequisitos, Boolean sustentoValido) {
        this.nroTramite = nroTramite;
        this.tipoTramite = tipoTramite;
        this.usuario = usuario;
        this.solicitante = solicitante;
        this.fechaRegistro = fechaRegistro;
        this.estadoActual = estadoActual;
        this.datosCompletos = datosCompletos;
        this.datosConsistentes = datosConsistentes;
        this.cumpleRequisitos = cumpleRequisitos;
        this.sustentoValido = sustentoValido;
    }

    public Long getNroTramite() {
        return nroTramite;
    }

    public void setNroTramite(Long nroTramite) {
        this.nroTramite = nroTramite;
    }

    public TipoTramiteEntity getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramiteEntity tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public SolicitanteEntity getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(SolicitanteEntity solicitante) {
        this.solicitante = solicitante;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoTramite getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoTramite estadoActual) {
        this.estadoActual = estadoActual;
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
