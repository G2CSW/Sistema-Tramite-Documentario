package com.example.demo.TipoTramite;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoTramiteDAOImpl implements TipoTramiteDAO {

    private final TipoTramiteRepository repository;
    private final TipoTramiteAdapter adapter;

    public TipoTramiteDAOImpl(TipoTramiteRepository repository, TipoTramiteAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public List<TipoTramite> listarTodos() {
        return repository.findAll()
                .stream()
                .map(adapter::toModel)
                .toList();
    }

    @Override
    public TipoTramite buscarPorId(Long id) {
        return repository.findById(id)
                .map(adapter::toModel)
                .orElse(null);
    }

    @Override
    public TipoTramite guardar(TipoTramite tipoTramite) {
        return adapter.toModel(
                repository.save(adapter.toEntity(tipoTramite))
        );
    }
}
