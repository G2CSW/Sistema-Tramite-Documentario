package com.example.demo.Tramite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TramiteRepository extends JpaRepository<TramiteEntity, Long> {

    @Query("""
            SELECT MAX(t.idTramite)
            FROM TramiteEntity t
            """)
    Long obtenerUltimoId();
}
