package com.example.demo.Trazabilidad;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrazabilidadDAOImpl implements TrazabilidadDAO {

    private final TrazabilidadRepository repository;
    private final TrazabilidadAdapter adapter;

    public TrazabilidadDAOImpl(TrazabilidadRepository repository, TrazabilidadAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public List<Trazabilidad> listarTodos() {
        return repository.findAll()
                .stream()
                .map(x -> adapter.toModel(x))
                .toList();
    }

    @Override
    public Trazabilidad buscarPorId(Long id) {
        return repository.findById(id)
                .map(x -> adapter.toModel(x))
                .orElse(null);
    }

    @Override
    public Trazabilidad guardar(Trazabilidad trazabilidad) {
        return adapter.toModel(
                repository.save(adapter.toEntity(trazabilidad))
        );
    }

    @Override
    public List<Trazabilidad> buscarPorTramiteOrdenado(Long nroTramite) {
        return repository.findByTramite_NroTramiteOrderByFechaHoraDesc(nroTramite)
                .stream()
                .map(x -> adapter.toModel(x))
                .toList();
    }
}
