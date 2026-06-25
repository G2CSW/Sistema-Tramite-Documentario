package com.example.demo.Archivados;

import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.Tramite;
import com.example.demo.Tramite.TramiteDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArchivadosServiceImpl implements ArchivadosService {

    private final TramiteDAO tramiteDAO;

    public ArchivadosServiceImpl(TramiteDAO tramiteDAO) {
        this.tramiteDAO = tramiteDAO;
    }

    @Override
    public List<Tramite> listarArchivados(String idSolicitante) {

        List<Tramite> tramites = new ArrayList<>();

        if (idSolicitante == null || idSolicitante.isBlank()) {

            tramites.addAll(
                    tramiteDAO.buscarPorEstadoActual(
                            EstadoTramite.ARCHIVADO
                    )
            );

            tramites.addAll(
                    tramiteDAO.buscarPorEstadoActual(
                            EstadoTramite.CANCELADO
                    )
            );

        } else {

            tramites.addAll(
                    tramiteDAO.buscarPorEstadoActualYSolicitante(
                                    EstadoTramite.ARCHIVADO,
                                    idSolicitante
                            )
            );

            tramites.addAll(
                    tramiteDAO.buscarPorEstadoActualYSolicitante(
                                    EstadoTramite.CANCELADO,
                                    idSolicitante
                            )
            );
        }

        return tramites;
    }
}