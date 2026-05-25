package com.example.demo.Repository;

import com.example.demo.Solicitante.SolicitanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitanteRepository extends JpaRepository<SolicitanteEntity, String> {
}
