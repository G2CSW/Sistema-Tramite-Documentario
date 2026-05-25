package com.example.demo.BandejaTrabajo;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.Tramite;
import com.example.demo.Trazabilidad.TrazabilidadService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandejaTrabajoServiceImpl implements BandejaTrabajoService {

    private final List<Tramite> tramites = DatosMemoria.TRAMITES;
    private final TrazabilidadService trazabilidadService;

    public BandejaTrabajoServiceImpl(TrazabilidadService trazabilidadService) {
        this.trazabilidadService = trazabilidadService;
    }

    @Override
    public List<Tramite> listarTramitesAEvaluar(String dni) {

        List<Tramite> tramitesEvaluar = new ArrayList<>();

        for (Tramite t : tramites) {

            if (t.getEstadoActual() == EstadoTramite.EN_EVALUACION) {

                if (dni != null && !dni.isEmpty()) {

                    if (t.getSolicitante() != null
                            && dni.equals(t.getSolicitante().getIdSolicitante())) {

                        tramitesEvaluar.add(t);
                    }

                } else {
                    tramitesEvaluar.add(t);
                }
            }
        }

        return tramitesEvaluar;
    }

    @Override
    public Tramite buscarPorId(String id) {

        for (Tramite t : tramites) {

            if (t.getNroTramite().equals(id)) {
                return t;
            }
        }

        return null;
    }

    @Override
    public String procesarEvaluacion(String id,
                                     boolean datosCompletos,
                                     boolean datosConsistentes,
                                     boolean cumpleRequisitos,
                                     boolean sustentoValido,
                                     String accion,
                                     String comentario) {

        Tramite t = buscarPorId(id);

        if (t == null) {
            return "Trámite no encontrado";
        }

        boolean todosCumplen =
                datosCompletos
                        && datosConsistentes
                        && cumpleRequisitos
                        && sustentoValido;

        if ("aprobar".equals(accion) && !todosCumplen) {
            return "No se puede aprobar un trámite que no cumple con los checks.";
        }

        if ("rechazar".equals(accion) && todosCumplen) {
            return "No se puede rechazar un trámite que tiene todo check.";
        }

        t.setDatosCompletos(datosCompletos);
        t.setDatosConsistentes(datosConsistentes);
        t.setCumpleRequisitos(cumpleRequisitos);
        t.setSustentoValido(sustentoValido);

        EstadoTramite estado;
        String comentarioTrazabilidad;

        if ("aprobar".equals(accion)) {

            t.setEstadoActual(EstadoTramite.APROBADO);
            estado = EstadoTramite.APROBADO;
            comentarioTrazabilidad = "Trámite aprobado" + agregarComentarioExtra(comentario);

        } else {

            t.setEstadoActual(EstadoTramite.RECHAZADO);
            estado = EstadoTramite.RECHAZADO;
            comentarioTrazabilidad = "Trámite rechazado por no cumplir con los siguientes criterios: "
                    + listarChecksNoCumplidos(datosCompletos, datosConsistentes, cumpleRequisitos, sustentoValido)
                    + agregarComentarioExtra(comentario);
        }

        trazabilidadService.registrarTrazabilidad(
                t,
                estado,
                comentarioTrazabilidad,
                DatosMemoria.USUARIOS.get(1)
        );

        return null;
    }

    @Override
    public String obtenerMensajeErrorEvaluacion(String accion,
                                                boolean datosCompletos,
                                                boolean datosConsistentes,
                                                boolean cumpleRequisitos,
                                                boolean sustentoValido) {

        boolean todosCumplen =
                datosCompletos
                        && datosConsistentes
                        && cumpleRequisitos
                        && sustentoValido;

        if ("aprobar".equals(accion) && !todosCumplen) {
            return "No se puede aprobar un trámite que no cumple con los checks.";
        }

        if ("rechazar".equals(accion) && todosCumplen) {
            return "No se puede rechazar un trámite que tiene todo check.";
        }

        return null;
    }

    private String listarChecksNoCumplidos(boolean datosCompletos,
                                           boolean datosConsistentes,
                                           boolean cumpleRequisitos,
                                           boolean sustentoValido) {

        List<String> faltantes = new ArrayList<>();

        if (!datosCompletos) {
            faltantes.add("Datos Completos");
        }

        if (!datosConsistentes) {
            faltantes.add("Datos Consistentes");
        }

        if (!cumpleRequisitos) {
            faltantes.add("Cumple requisitos del trámite");
        }

        if (!sustentoValido) {
            faltantes.add("Sustento válido");
        }

        return String.join(", ", faltantes);
    }

    private String agregarComentarioExtra(String comentario) {

        if (comentario == null || comentario.isBlank()) {
            return "";
        }

        return ". " + comentario.trim();
    }
}