package com.example.demo.repository;

import com.example.demo.Tramite.TrazabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrazabilidadRepository extends JpaRepository<TrazabilidadEntity, String> {
}
