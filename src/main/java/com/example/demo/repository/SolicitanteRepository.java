package com.example.demo.repository;

import com.example.demo.Tramite.SolicitanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitanteRepository extends JpaRepository<SolicitanteEntity, String> {
}
