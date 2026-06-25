package com.example.demo.Metricas;

import java.util.List;

public class MetricasEstadoDTO {

    private final List<Object[]> aprobados;
    private final List<Object[]> rechazados;
    private final List<Object[]> cancelados;
    private final List<Object[]> evaluacion;

    public MetricasEstadoDTO(
            List<Object[]> aprobados,
            List<Object[]> rechazados,
            List<Object[]> cancelados,
            List<Object[]> evaluacion) {

        this.aprobados = aprobados;
        this.rechazados = rechazados;
        this.cancelados = cancelados;
        this.evaluacion = evaluacion;
    }

    public List<Object[]> getAprobados() {
        return aprobados;
    }

    public List<Object[]> getRechazados() {
        return rechazados;
    }

    public List<Object[]> getCancelados() {
        return cancelados;
    }

    public List<Object[]> getEvaluacion() {
        return evaluacion;
    }
}
