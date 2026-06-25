package com.example.demo.Metricas;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MetricasDAOImpl implements MetricasDAO {

    private final MetricasRepository repository;

    public MetricasDAOImpl(MetricasRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Object[]> estadosUltimos5Meses() {
        return repository.estadosUltimos5Meses();
    }

    @Override
    public List<Object[]> cantidadTramitesRegistradosUltimas4Semanas() {
        return repository.cantidadTramitesRegistradosUltimas4Semanas();
    }
}
