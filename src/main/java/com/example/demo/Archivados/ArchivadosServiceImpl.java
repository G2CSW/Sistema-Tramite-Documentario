package com.example.demo.Archivados;

import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.Tramite;
import com.example.demo.Tramite.TramiteAdapter;
import com.example.demo.Tramite.TramiteEntity;
import com.example.demo.Tramite.TramiteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArchivadosServiceImpl implements ArchivadosService {

    private final TramiteRepository tramiteRepository;
    private final TramiteAdapter tramiteAdapter;

    public ArchivadosServiceImpl(TramiteRepository tramiteRepository,
                                 TramiteAdapter tramiteAdapter) {
        this.tramiteRepository = tramiteRepository;
        this.tramiteAdapter = tramiteAdapter;
    }

    @Override
    public List<Tramite> listarArchivados(String idSolicitante) {

        List<TramiteEntity> entidades = new ArrayList<>();

        if (idSolicitante == null || idSolicitante.isBlank()) {

            entidades.addAll(
                    tramiteRepository.findByEstadoActual(
                            EstadoTramite.ARCHIVADO
                    )
            );

            entidades.addAll(
                    tramiteRepository.findByEstadoActual(
                            EstadoTramite.CANCELADO
                    )
            );

        } else {

            entidades.addAll(
                    tramiteRepository
                            .findByEstadoActualAndSolicitante_IdSolicitante(
                                    EstadoTramite.ARCHIVADO,
                                    idSolicitante
                            )
            );

            entidades.addAll(
                    tramiteRepository
                            .findByEstadoActualAndSolicitante_IdSolicitante(
                                    EstadoTramite.CANCELADO,
                                    idSolicitante
                            )
            );
        }

        return entidades.stream()
                .map(tramiteAdapter::toModel)
                .collect(Collectors.toList());
    }
}