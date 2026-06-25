package com.example.demo.Documento;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentoDAOImpl implements DocumentoDAO {

    private final DocumentoRepository repository;
    private final DocumentoAdapter adapter;

    public DocumentoDAOImpl(DocumentoRepository repository, DocumentoAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public List<Documento> listarTodos() {
        return repository.findAll()
                .stream()
                .map(adapter::toModel)
                .toList();
    }

    @Override
    public Documento buscarPorId(Long id) {
        return repository.findById(id)
                .map(adapter::toModel)
                .orElse(null);
    }

    @Override
    public Documento guardar(Documento documento) {
        return adapter.toModel(
                repository.save(adapter.toEntity(documento))
        );
    }

    @Override
    public List<Documento> listarActivos() {
        return repository.findByActivoTrue()
                .stream()
                .map(adapter::toModel)
                .toList();
    }

    @Override
    public List<Documento> buscarPorIds(List<Long> ids) {
        return repository.findByIdDocumentoIn(ids)
                .stream()
                .map(adapter::toModel)
                .toList();
    }
}
