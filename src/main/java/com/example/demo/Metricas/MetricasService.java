package com.example.demo.Metricas;

import java.util.List;

public interface MetricasService {

    List<Object[]> aprobarUltimos5Meses();

    List<Object[]> rechazoUltimos5Meses();

    List<Object[]> abandonoUltimos5Meses();

    List<Object[]> intensidadUltimas4Semanas();

    List<Object[]> tiempoResolucionUltimos5Meses();
}