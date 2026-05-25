package com.example.demo.Repository;

import com.example.demo.Trazabilidad.TrazabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrazabilidadRepository
        extends JpaRepository<TrazabilidadEntity, Long> {

    List<TrazabilidadEntity>
    findByTramite_NroTramiteOrderByFechaHoraDesc(Long nroTramite);
}