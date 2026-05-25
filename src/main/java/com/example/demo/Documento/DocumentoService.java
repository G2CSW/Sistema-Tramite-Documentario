package com.example.demo.Documento;

import java.util.List;

public interface DocumentoService {

    List<Documento> listar();

    Documento prepararRegistro();

    Documento buscarPorId(Long id);

    Documento registrar(Documento documento);

    Documento editar(Long id, Documento form);

    void cambiarEstado(Long id);
}