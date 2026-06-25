package com.example.demo.Metricas;

import java.util.List;

public interface MetricasDAO {
    List<Object[]> estadosUltimos5Meses();
    List<Object[]> cantidadTramitesRegistradosUltimas4Semanas();
}
