package com.example.demo.Solicitante;

public interface SolicitanteService {

    boolean validarSolicitante(Solicitante solicitante);

    Solicitante guardarOActualizarSolicitante(Solicitante solicitante);

    Solicitante buscarSolicitante(String idSolicitante);

    boolean existeSolicitante(String idSolicitante);
}
