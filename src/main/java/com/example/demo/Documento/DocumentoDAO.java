package com.example.demo.Documento;

import java.util.List;

public interface DocumentoDAO {
    List<Documento> listarTodos();
    Documento buscarPorId(Long id);
    Documento guardar(Documento documento);
    List<Documento> listarActivos();
    List<Documento> buscarPorIds(List<Long> ids);
}
