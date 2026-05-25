package com.example.demo.TipoTramite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTramiteRepository extends JpaRepository<TipoTramiteEntity, Long> {
}