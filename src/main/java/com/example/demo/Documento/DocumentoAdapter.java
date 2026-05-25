package com.example.demo.Documento;

import org.springframework.stereotype.Component;

@Component
public class DocumentoAdapter {

    public DocumentoEntity toEntity(Documento documento) {
        if (documento == null) return null;
        DocumentoEntity entity = new DocumentoEntity();
        entity.setIdDocumento(documento.getIdDocumento());
        entity.setNombreDocumento(documento.getNombreDocumento());
        entity.setActivo(documento.isActivo());
        return entity;
    }

    public Documento toModel(DocumentoEntity entity) {
        if (entity == null) return null;
        Documento documento = new Documento();
        documento.setIdDocumento(entity.getIdDocumento());
        documento.setNombreDocumento(entity.getNombreDocumento());
        documento.setActivo(entity.isActivo());
        return documento;
    }
}
