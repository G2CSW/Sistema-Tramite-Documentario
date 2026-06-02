package com.example.demo.Metricas;

import com.example.demo.Tramite.TramiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricasRepository extends JpaRepository<TramiteEntity, Long> {

    @Query(value = """
        SELECT FORMATDATETIME(t.fecha_registro, 'yyyy-MM') AS periodo,
               SUM(CASE WHEN tz.estado_cambio = 'APROBADO' THEN 1 ELSE 0 END) AS aprobados,
               SUM(CASE WHEN tz.estado_cambio = 'RECHAZADO' THEN 1 ELSE 0 END) AS rechazados
        FROM tramites t
        INNER JOIN (
            SELECT nro_tramite, estado_cambio
            FROM trazabilidades tz1
            WHERE (tz1.estado_cambio IN ('APROBADO', 'RECHAZADO'))
              AND tz1.fecha_hora = (
                SELECT MIN(tz2.fecha_hora)
                FROM trazabilidades tz2
                WHERE tz2.nro_tramite = tz1.nro_tramite
                  AND tz2.estado_cambio IN ('APROBADO', 'RECHAZADO')
              )
        ) tz ON tz.nro_tramite = t.nro_tramite
        WHERE t.fecha_registro >= DATEADD('MONTH', -4, CURRENT_DATE)
        GROUP BY FORMATDATETIME(t.fecha_registro, 'yyyy-MM')
        ORDER BY periodo
        """, nativeQuery = true)
    List<Object[]> aprobadosYRechazadosUltimos5Meses();

    @Query(value = """
        SELECT FORMATDATETIME(t.fecha_registro, 'yyyy-MM') AS periodo,
               SUM(CASE WHEN tz.estado_cambio = 'CANCELADO' THEN 1 ELSE 0 END) AS cancelados,
               COUNT(DISTINCT t.nro_tramite) AS total
        FROM tramites t
        LEFT JOIN (
            SELECT nro_tramite, estado_cambio
            FROM trazabilidades tz1
            WHERE tz1.estado_cambio = 'CANCELADO'
              AND tz1.fecha_hora = (
                SELECT MIN(tz2.fecha_hora)
                FROM trazabilidades tz2
                WHERE tz2.nro_tramite = tz1.nro_tramite
                  AND tz2.estado_cambio = 'CANCELADO'
              )
        ) tz ON tz.nro_tramite = t.nro_tramite
        WHERE t.fecha_registro >= DATEADD('MONTH', -4, CURRENT_DATE)
        GROUP BY FORMATDATETIME(t.fecha_registro, 'yyyy-MM')
        ORDER BY periodo
        """, nativeQuery = true)
    List<Object[]> abandonoUltimos5Meses();

    @Query(value = """
        SELECT 'Hace 3 sem' AS etiqueta, COUNT(*) AS valor
        FROM tramites
        WHERE fecha_registro >= DATEADD('DAY', -28, CURRENT_DATE)
          AND fecha_registro <  DATEADD('DAY', -21, CURRENT_DATE)

        UNION ALL

        SELECT 'Hace 2 sem' AS etiqueta, COUNT(*) AS valor
        FROM tramites
        WHERE fecha_registro >= DATEADD('DAY', -21, CURRENT_DATE)
          AND fecha_registro <  DATEADD('DAY', -14, CURRENT_DATE)

        UNION ALL

        SELECT 'Hace 1 sem' AS etiqueta, COUNT(*) AS valor
        FROM tramites
        WHERE fecha_registro >= DATEADD('DAY', -14, CURRENT_DATE)
          AND fecha_registro <  DATEADD('DAY', -7, CURRENT_DATE)

        UNION ALL

        SELECT 'Actual' AS etiqueta, COUNT(*) AS valor
        FROM tramites
        WHERE fecha_registro >= DATEADD('DAY', -7, CURRENT_DATE)
        """, nativeQuery = true)
    List<Object[]> intensidadUltimas4Semanas();

    @Query(value = """
        SELECT FORMATDATETIME(t.fecha_registro, 'yyyy-MM') AS periodo,
               ROUND(AVG(CAST((f.fecha_fin - t.fecha_registro) AS DECIMAL)), 2) AS promedio
        FROM tramites t
        INNER JOIN (
            SELECT nro_tramite, 
                   MIN(CASE WHEN estado_cambio IN ('APROBADO', 'RECHAZADO', 'CANCELADO') 
                            THEN fecha_hora 
                       END) AS fecha_fin
            FROM trazabilidades
            GROUP BY nro_tramite
        ) f ON f.nro_tramite = t.nro_tramite
        WHERE t.fecha_registro >= DATEADD('MONTH', -4, CURRENT_DATE)
          AND f.fecha_fin IS NOT NULL
        GROUP BY FORMATDATETIME(t.fecha_registro, 'yyyy-MM')
        ORDER BY periodo
        """, nativeQuery = true)
    List<Object[]> tiempoResolucionUltimos5Meses();
}