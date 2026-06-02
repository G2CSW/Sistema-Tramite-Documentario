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
    public List<Object[]> aprobarUltimos5Meses() {
        return completarMesesPorcentaje(metricaRepository.aprobadosYRechazadosUltimos5Meses(), true);
    }

    @Override
    public List<Object[]> rechazoUltimos5Meses() {
        return completarMesesPorcentaje(metricaRepository.aprobadosYRechazadosUltimos5Meses(), false);
    }

    @Override
    public List<Object[]> abandonoUltimos5Meses() {
        List<Object[]> filas = metricaRepository.abandonoUltimos5Meses();
        Map<String, Object[]> mapa = new LinkedHashMap<>();

        for (Object[] fila : filas) {
            String periodo = String.valueOf(fila[0]);
            long cancelados = fila[1] == null ? 0L : ((Number) fila[1]).longValue();
            long total = fila[2] == null ? 0L : ((Number) fila[2]).longValue();
            double porcentaje = total == 0 ? 0 : (cancelados * 100.0 / total);

            mapa.put(periodo, new Object[]{periodo, redondear2(porcentaje)});
        }

        return completarMeses(mapa);
    }

    @Override
    public List<Object[]> intensidadUltimas4Semanas() {
        return metricaRepository.intensidadUltimas4Semanas();
    }

    @Override
    public List<Object[]> tiempoResolucionUltimos5Meses() {
        List<Object[]> filas = metricaRepository.tiempoResolucionUltimos5Meses();
        Map<String, Object[]> mapa = new LinkedHashMap<>();

        for (Object[] fila : filas) {
            String periodo = String.valueOf(fila[0]);
            double promedio = fila[1] == null ? 0.0 : ((Number) fila[1]).doubleValue();
            mapa.put(periodo, new Object[]{periodo, redondear2(promedio)});
        }

        return completarMeses(mapa);
    }

    private List<Object[]> completarMesesPorcentaje(List<Object[]> filas, boolean aprobacion) {
        Map<String, Object[]> mapa = new LinkedHashMap<>();

        for (Object[] fila : filas) {
            String periodo = String.valueOf(fila[0]);
            long aprobados = fila[1] == null ? 0L : ((Number) fila[1]).longValue();
            long rechazados = fila[2] == null ? 0L : ((Number) fila[2]).longValue();
            long total = aprobados + rechazados;

            double porcentaje = total == 0
                    ? 0
                    : (aprobacion ? (aprobados * 100.0 / total) : (rechazados * 100.0 / total));

            mapa.put(periodo, new Object[]{periodo, redondear2(porcentaje)});
        }

        return completarMeses(mapa);
    }

    private List<Object[]> completarMeses(Map<String, Object[]> datos) {
        List<Object[]> salida = new ArrayList<>();
        YearMonth inicio = YearMonth.now().minusMonths(4);

        for (int i = 0; i < 5; i++) {
            String periodo = inicio.plusMonths(i).toString();
            salida.add(datos.getOrDefault(periodo, new Object[]{periodo, 0}));
        }

        return salida;
    }

    private double redondear2(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}