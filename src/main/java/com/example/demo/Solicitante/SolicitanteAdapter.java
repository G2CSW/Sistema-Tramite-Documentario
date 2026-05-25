package com.example.demo.Solicitante;

import org.springframework.stereotype.Component;

@Component
public class SolicitanteAdapter {

    public SolicitanteEntity toEntity(Solicitante solicitante) {
        if (solicitante == null) return null;
        SolicitanteEntity entity = new SolicitanteEntity();
        entity.setIdSolicitante(solicitante.getIdSolicitante());
        entity.setNombreCompleto(solicitante.getNombreCompleto());
        entity.setCorreoElectronico(solicitante.getCorreoElectronico());
        entity.setTelefonoContacto(solicitante.getTelefonoContacto());
        return entity;
    }

    public Solicitante toModel(SolicitanteEntity entity) {
        if (entity == null) return null;
        Solicitante solicitante = new Solicitante();
        solicitante.setIdSolicitante(entity.getIdSolicitante());
        solicitante.setNombreCompleto(entity.getNombreCompleto());
        solicitante.setCorreoElectronico(entity.getCorreoElectronico());
        solicitante.setTelefonoContacto(entity.getTelefonoContacto());
        return solicitante;
    }
}
