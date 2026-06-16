package com.example.demo.Metricas;

import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MetricasServiceImpl implements MetricasService {

    private final MetricasRepository metricaRepository;

    public MetricasServiceImpl(MetricasRepository metricaRepository) {
        this.metricaRepository = metricaRepository;
    }

    @Override
    public MetricasEstadoDTO estadosUltimos5Meses() {

        List<Object[]> filas = metricaRepository.estadosUltimos5Meses();

        Map<String, Object[]> aprobados = new LinkedHashMap<>();
        Map<String, Object[]> rechazados = new LinkedHashMap<>();
        Map<String, Object[]> cancelados = new LinkedHashMap<>();
        Map<String, Object[]> evaluacion = new LinkedHashMap<>();

        for (Object[] fila : filas) {

            String periodo = String.valueOf(fila[0]);

            aprobados.put(periodo,
                    new Object[]{
                            periodo,
                            fila[1] == null ? 0L : ((Number) fila[1]).longValue()
                    });

            rechazados.put(periodo,
                    new Object[]{
                            periodo,
                            fila[2] == null ? 0L : ((Number) fila[2]).longValue()
                    });

            cancelados.put(periodo,
                    new Object[]{
                            periodo,
                            fila[3] == null ? 0L : ((Number) fila[3]).longValue()
                    });

            evaluacion.put(periodo,
                    new Object[]{
                            periodo,
                            fila[4] == null ? 0L : ((Number) fila[4]).longValue()
                    });
        }

        return new MetricasEstadoDTO(
                completarMeses(aprobados),
                completarMeses(rechazados),
                completarMeses(cancelados),
                completarMeses(evaluacion)
        );
    }

    @Override
    public List<Object[]> cantidadTramitesRegistradosUltimas4Semanas() {
        return metricaRepository.cantidadTramitesRegistradosUltimas4Semanas();
    }

    private List<Object[]> completarMeses(Map<String, Object[]> datos) {

        List<Object[]> salida = new ArrayList<>();

        YearMonth inicio = YearMonth.now().minusMonths(4);

        for (int i = 0; i < 5; i++) {

            String periodo = inicio.plusMonths(i).toString();

            salida.add(
                    datos.getOrDefault(
                            periodo,
                            new Object[]{periodo, 0}
                    )
            );
        }

        return salida;
    }
}