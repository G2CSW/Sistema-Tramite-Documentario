package com.example.demo.BandejaTrabajo;

import com.example.demo.Tramite.*;
import com.example.demo.Trazabilidad.TrazabilidadService;
import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.UsuarioDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BandejaTrabajoServiceImpl implements BandejaTrabajoService {

    private final TramiteDAO tramiteDAO;
    private final TrazabilidadService trazabilidadService;
    private final UsuarioDAO usuarioDAO;

    public BandejaTrabajoServiceImpl(TramiteDAO tramiteDAO,
                                     TrazabilidadService trazabilidadService,
                                     UsuarioDAO usuarioDAO) {
        this.tramiteDAO = tramiteDAO;
        this.trazabilidadService = trazabilidadService;
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<Tramite> listarTramitesAEvaluar(String dni) {
        List<Tramite> tramites;

        if (dni != null && !dni.isBlank()) {
            tramites = tramiteDAO.buscarPorEstadoActualYSolicitante(
                    EstadoTramite.EN_EVALUACION,
                    dni
            );
        } else {
            tramites = tramiteDAO.buscarPorEstadoActual(EstadoTramite.EN_EVALUACION);
        }

        return tramites;
    }

    @Override
    public Tramite buscarPorId(Long id) {
        return tramiteDAO.buscarPorId(id);
    }

    @Override
    public String procesarEvaluacion(Long id,
                                     boolean datosCompletos,
                                     boolean datosConsistentes,
                                     boolean cumpleRequisitos,
                                     boolean sustentoValido,
                                     String accion,
                                     String comentario,
                                     String idUsuarioLogueado) {

        Tramite tramite = tramiteDAO.buscarPorId(id);

        if (tramite == null) {
            return "Trámite no encontrado";
        }

        boolean todosCumplen = datosCompletos
                && datosConsistentes
                && cumpleRequisitos
                && sustentoValido;

        if ("aprobar".equals(accion) && !todosCumplen) {
            return "No se puede aprobar un trámite que no cumple con los checks.";
        }

        if ("rechazar".equals(accion) && todosCumplen) {
            return "No se puede rechazar un trámite que tiene todo check.";
        }

        tramite.setDatosCompletos(datosCompletos);
        tramite.setDatosConsistentes(datosConsistentes);
        tramite.setCumpleRequisitos(cumpleRequisitos);
        tramite.setSustentoValido(sustentoValido);

        EstadoTramite estado;
        String comentarioTrazabilidad;

        if ("aprobar".equals(accion)) {
            tramite.setEstadoActual(EstadoTramite.APROBADO);
            estado = EstadoTramite.APROBADO;
            comentarioTrazabilidad = "Trámite aprobado" + agregarComentarioExtra(comentario);
        } else {
            tramite.setEstadoActual(EstadoTramite.RECHAZADO);
            estado = EstadoTramite.RECHAZADO;
            comentarioTrazabilidad = "Trámite rechazado por no cumplir con los siguientes criterios: "
                    + listarChecksNoCumplidos(datosCompletos, datosConsistentes, cumpleRequisitos, sustentoValido)
                    + agregarComentarioExtra(comentario);
        }

        Tramite tramiteGuardado = tramiteDAO.guardar(tramite);



        Usuario usuarioEvaluador = null;
        if (idUsuarioLogueado != null) {
            usuarioEvaluador = usuarioDAO.buscarPorId(idUsuarioLogueado);
        }
        if (usuarioEvaluador == null) {
            return "No se encontró el usuario evaluador";
        }



        trazabilidadService.registrarTrazabilidad(
                tramiteGuardado,
                estado,
                comentarioTrazabilidad,
                usuarioEvaluador
        );

        return null;
    }

    @Override
    public String obtenerMensajeErrorEvaluacion(String accion,
                                                boolean datosCompletos,
                                                boolean datosConsistentes,
                                                boolean cumpleRequisitos,
                                                boolean sustentoValido) {

        boolean todosCumplen = datosCompletos
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

        StringBuilder faltantes = new StringBuilder();

        if (!datosCompletos) {
            faltantes.append("Datos Completos");
        }

        if (!datosConsistentes) {
            if (!faltantes.isEmpty()) {
                faltantes.append(", ");
            }
            faltantes.append("Datos Consistentes");
        }

        if (!cumpleRequisitos) {
            if (!faltantes.isEmpty()) {
                faltantes.append(", ");
            }
            faltantes.append("Cumple requisitos del trámite");
        }

        if (!sustentoValido) {
            if (!faltantes.isEmpty()) {
                faltantes.append(", ");
            }
            faltantes.append("Sustento válido");
        }

        return faltantes.toString();
    }

    private String agregarComentarioExtra(String comentario) {
        if (comentario == null || comentario.isBlank()) {
            return "";
        }

        return ". " + comentario.trim();
    }
}