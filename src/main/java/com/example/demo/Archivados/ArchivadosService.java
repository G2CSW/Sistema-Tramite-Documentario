package com.example.demo.Archivados;

import com.example.demo.Tramite.Tramite;

import java.util.List;

public interface ArchivadosService {
    List<Tramite> listarArchivados(String idSolicitante);
}
