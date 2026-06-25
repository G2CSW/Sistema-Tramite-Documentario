package com.example.demo.Solicitante;

import java.util.List;

public interface SolicitanteDAO {
    List<Solicitante> listarTodos();
    Solicitante buscarPorId(String id);
    Solicitante guardar(Solicitante solicitante);
    boolean existePorId(String id);
}
