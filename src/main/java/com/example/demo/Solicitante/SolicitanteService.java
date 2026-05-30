package com.example.demo.Solicitante;

public interface SolicitanteService {

    String validarSolicitante(Solicitante solicitante);

    Solicitante guardarOActualizarSolicitante(Solicitante solicitante);

    Solicitante buscarSolicitante(String idSolicitante);

    boolean existeSolicitante(String idSolicitante);
}