package com.example.demo.Solicitante;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SolicitanteDAOImpl implements SolicitanteDAO {

    private final SolicitanteRepository repository;
    private final SolicitanteAdapter adapter;

    public SolicitanteDAOImpl(SolicitanteRepository repository, SolicitanteAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public List<Solicitante> listarTodos() {
        return repository.findAll()
                .stream()
                .map(x -> adapter.toModel(x))
                .toList();
    }

    @Override
    public Solicitante buscarPorId(String id) {
        return repository.findById(id)
                .map(x -> adapter.toModel(x))
                .orElse(null);
    }

    @Override
    public Solicitante guardar(Solicitante solicitante) {
        return adapter.toModel(
                repository.save(adapter.toEntity(solicitante))
        );
    }

    @Override
    public boolean existePorId(String id) {
        return repository.existsById(id);
    }
}
