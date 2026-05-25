package com.example.demo.TipoTramite;

import com.example.demo.Documento.DocumentoAdapter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class TipoTramiteAdapter {

    private final DocumentoAdapter documentoAdapter;

    public TipoTramiteAdapter(DocumentoAdapter documentoAdapter) {
        this.documentoAdapter = documentoAdapter;
    }

    public TipoTramiteEntity toEntity(TipoTramite tipoTramite) {
        if (tipoTramite == null) return null;
        TipoTramiteEntity entity = new TipoTramiteEntity();
        entity.setIdTipoTramite(tipoTramite.getIdTipoTramite());
        entity.setNombre(tipoTramite.getNombre());
        entity.setFechaCreacion(tipoTramite.getFechaCreacion());
        entity.setActivo(tipoTramite.isActivo());
        entity.setDocumentacionMinima(
            tipoTramite.getDocumentacionMinima() != null
                ? tipoTramite.getDocumentacionMinima().stream()
                    .map(documentoAdapter::toEntity)
                    .collect(Collectors.toList())
                : new ArrayList<>()
        );
        return entity;
    }

    public TipoTramite toModel(TipoTramiteEntity entity) {
        if (entity == null) return null;
        TipoTramite tipoTramite = new TipoTramite();
        tipoTramite.setIdTipoTramite(entity.getIdTipoTramite());
        tipoTramite.setNombre(entity.getNombre());
        tipoTramite.setFechaCreacion(entity.getFechaCreacion());
        tipoTramite.setActivo(entity.isActivo());
        tipoTramite.setDocumentacionMinima(
            entity.getDocumentacionMinima() != null
                ? entity.getDocumentacionMinima().stream()
                    .map(documentoAdapter::toModel)
                    .collect(Collectors.toList())
                : new ArrayList<>()
        );
        return tipoTramite;
    }
}
