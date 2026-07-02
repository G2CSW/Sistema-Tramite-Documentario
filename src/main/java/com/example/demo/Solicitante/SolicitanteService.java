package com.example.demo.Solicitante;

import java.util.List;

public interface SolicitanteService {

    String validarSolicitante(Solicitante solicitante);

    Solicitante guardarOActualizarSolicitante(Solicitante solicitante);

    Solicitante buscarSolicitante(String idSolicitante);

    List<Solicitante> listarTodos();

    boolean existeSolicitante(String idSolicitante);
}
