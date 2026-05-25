package com.example.demo.Tramite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TramiteRepository extends JpaRepository<TramiteEntity, Long> {

    @Query("""
            SELECT MAX(t.idTramite)
            FROM TramiteEntity t
            """)
    Long obtenerUltimoId();

    List<TramiteEntity> findByEstadoActual(EstadoTramite estadoActual);

    List<TramiteEntity> findByEstadoActualAndSolicitante_IdSolicitante(EstadoTramite estadoActual,
                                                                       String idSolicitante);
}
