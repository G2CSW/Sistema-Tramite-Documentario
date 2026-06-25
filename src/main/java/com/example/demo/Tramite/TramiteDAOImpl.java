package com.example.demo.Tramite;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TramiteDAOImpl implements TramiteDAO {

    private final TramiteRepository repository;
    private final TramiteAdapter adapter;

    public TramiteDAOImpl(TramiteRepository repository, TramiteAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public List<Tramite> listarTodos() {
        return repository.findAll()
                .stream()
                .map(x -> adapter.toModel(x))
                .toList();
    }

    @Override
    public Tramite buscarPorId(Long id) {
        return repository.findById(id)
                .map(x -> adapter.toModel(x))
                .orElse(null);
    }

    @Override
    public Tramite guardar(Tramite tramite) {
        return adapter.toModel(
                repository.save(adapter.toEntity(tramite))
        );
    }

    @Override
    public boolean actualizar(Tramite tramite) {
        repository.save(adapter.toEntity(tramite));
        return true;
    }

    @Override
    public Long obtenerUltimoId() {
        return repository.obtenerUltimoId();
    }

    @Override
    public List<Tramite> buscarPorEstadoActual(EstadoTramite estadoActual) {
        return repository.findByEstadoActual(estadoActual)
                .stream()
                .map(x -> adapter.toModel(x))
                .toList();
    }

    @Override
    public List<Tramite> buscarPorEstadoActualYSolicitante(EstadoTramite estadoActual, String idSolicitante) {
        return repository.findByEstadoActualAndSolicitante_IdSolicitante(estadoActual, idSolicitante)
                .stream()
                .map(x -> adapter.toModel(x))
                .toList();
    }
}
