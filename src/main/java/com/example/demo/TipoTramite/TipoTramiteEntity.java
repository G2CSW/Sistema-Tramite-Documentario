package com.example.demo.TipoTramite;

import com.example.demo.Documento.DocumentoEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipos_tramite")
public class TipoTramiteEntity {

    @Id
    @Column(name = "id_tipo_tramite")
    private String idTipoTramite;

    @Column(name = "nombre")
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

    public TipoTramiteEntity(String idTipoTramite, String nombre,
                              List<DocumentoEntity> documentacionMinima,
                              LocalDate fechaCreacion, boolean activo) {
        this.idTipoTramite = idTipoTramite;
        this.nombre = nombre;
        this.documentacionMinima = documentacionMinima;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public String getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(String idTipoTramite) {
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
