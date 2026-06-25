package com.example.demo.TipoTramite;

import com.example.demo.Documento.DocumentoEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipos_tramite")
public class TipoTramiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_tramite")
    private Long idTipoTramite;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tipo_tramite_documento",
            joinColumns = @JoinColumn(name = "tipo_tramite_id"),
            inverseJoinColumns = @JoinColumn(name = "documento_id")
    )
    private List<DocumentoEntity> documentacionMinima = new ArrayList<>();

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "activo")
    private boolean activo;

    public TipoTramiteEntity() {
    }

    public TipoTramiteEntity(Long idTipoTramite,
                             String nombre,
                             List<DocumentoEntity> documentacionMinima,
                             LocalDate fechaCreacion,
                             boolean activo) {
        this.idTipoTramite = idTipoTramite;
        this.nombre = nombre;
        this.documentacionMinima = documentacionMinima;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Long getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(Long idTipoTramite) {
        this.idTipoTramite = idTipoTramite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DocumentoEntity> getDocumentacionMinima() {
        return documentacionMinima;
    }

    public void setDocumentacionMinima(List<DocumentoEntity> documentacionMinima) {
        this.documentacionMinima = documentacionMinima;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
