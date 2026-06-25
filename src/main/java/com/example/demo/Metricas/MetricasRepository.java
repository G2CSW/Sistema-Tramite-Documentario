package com.example.demo.Metricas;

import com.example.demo.Tramite.TramiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricasRepository extends JpaRepository<TramiteEntity, Long> {

    @Query(value = """
    SELECT FORMATDATETIME(tz.fecha_hora, 'yyyy-MM') AS periodo,

           SUM(CASE
                   WHEN tz.estado_cambio = 'APROBADO'
                   THEN 1
                   ELSE 0
               END) AS aprobados,

           SUM(CASE
                   WHEN tz.estado_cambio = 'RECHAZADO'
                   THEN 1
                   ELSE 0
               END) AS rechazados,

           SUM(CASE
                   WHEN tz.estado_cambio = 'CANCELADO'
                   THEN 1
                   ELSE 0
               END) AS cancelados,

           SUM(CASE
                   WHEN tz.estado_cambio = 'EN_EVALUACION'
                   THEN 1
                   ELSE 0
               END) AS evaluacion

    FROM trazabilidades tz

    WHERE tz.estado_cambio IN (
        'APROBADO',
        'RECHAZADO',
        'CANCELADO',
        'EN_EVALUACION'
    )
    AND tz.fecha_hora >=
        DATE_TRUNC('MONTH', DATEADD('MONTH', -4, CURRENT_DATE))

    GROUP BY FORMATDATETIME(tz.fecha_hora, 'yyyy-MM')

    ORDER BY periodo
    """, nativeQuery = true)
    List<Object[]> estadosUltimos5Meses();


    @Query(value = """
    SELECT 'Hace 3 sem' AS etiqueta, COUNT(*) AS valor
    FROM tramites
    WHERE fecha_registro >= DATEADD('WEEK', -3, DATE_TRUNC('week', CURRENT_DATE))
      AND fecha_registro <  DATEADD('WEEK', -2, DATE_TRUNC('week', CURRENT_DATE))

    UNION ALL

    SELECT 'Hace 2 sem' AS etiqueta, COUNT(*) AS valor
    FROM tramites
    WHERE fecha_registro >= DATEADD('WEEK', -2, DATE_TRUNC('week', CURRENT_DATE))
      AND fecha_registro <  DATEADD('WEEK', -1, DATE_TRUNC('week', CURRENT_DATE))

    UNION ALL

    SELECT 'Hace 1 sem' AS etiqueta, COUNT(*) AS valor
    FROM tramites
    WHERE fecha_registro >= DATEADD('WEEK', -1, DATE_TRUNC('week', CURRENT_DATE))
      AND fecha_registro <  DATE_TRUNC('week', CURRENT_DATE)

    UNION ALL

    SELECT 'Actual' AS etiqueta, COUNT(*) AS valor
    FROM tramites
    WHERE fecha_registro >= DATE_TRUNC('week', CURRENT_DATE)
    """, nativeQuery = true)
    List<Object[]> cantidadTramitesRegistradosUltimas4Semanas();

}
