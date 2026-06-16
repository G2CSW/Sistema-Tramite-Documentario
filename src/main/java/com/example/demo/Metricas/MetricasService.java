package com.example.demo.Metricas;

import java.util.List;

public interface MetricasService {

    MetricasEstadoDTO estadosUltimos5Meses();

    List<Object[]> cantidadTramitesRegistradosUltimas4Semanas();
}