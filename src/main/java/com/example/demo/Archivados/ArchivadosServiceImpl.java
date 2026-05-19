package com.example.demo.Archivados;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.Tramite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArchivadosServiceImpl implements ArchivadosService {

    private final List<Tramite> tramites = DatosMemoria.TRAMITES;

    @Override
    public List<Tramite> listarArchivados(String idSolicitante) {
        List<Tramite> tramitesArchivados = new ArrayList<>();

        for (Tramite t : tramites) {
            boolean archivadoOCancelado =
                    t.getEstadoActual() == EstadoTramite.ARCHIVADO ||
                            t.getEstadoActual() == EstadoTramite.CANCELADO;

            boolean coincide = (idSolicitante == null || idSolicitante.isBlank()) ||
                    (t.getSolicitante() != null &&
                            t.getSolicitante().getIdSolicitante().equals(idSolicitante));

            if (archivadoOCancelado && coincide) {
                tramitesArchivados.add(t);
            }
        }


        return tramitesArchivados;
    }
}
