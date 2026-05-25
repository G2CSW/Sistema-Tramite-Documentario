package com.example.demo.Documento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> {

    List<DocumentoEntity> findByActivoTrue();

    List<DocumentoEntity> findByIdDocumentoIn(List<Long> ids);
}