package com.example.demo.BandejaTrabajo;

import com.example.demo.Tramite.*;
import com.example.demo.Trazabilidad.TrazabilidadService;
import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.UsuarioAdapter;
import com.example.demo.Usuario.UsuarioEntity;
import com.example.demo.Usuario.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BandejaTrabajoServiceImpl implements BandejaTrabajoService {

    private final TramiteRepository tramiteRepository;
    private final TramiteAdapter tramiteAdapter;
    private final TrazabilidadService trazabilidadService;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioAdapter usuarioAdapter;

    public BandejaTrabajoServiceImpl(TramiteRepository tramiteRepository,
                                     TramiteAdapter tramiteAdapter,
                                     TrazabilidadService trazabilidadService,
                                     UsuarioRepository usuarioRepository,
                                     UsuarioAdapter usuarioAdapter) {
        this.tramiteRepository = tramiteRepository;
        this.tramiteAdapter = tramiteAdapter;
        this.trazabilidadService = trazabilidadService;
        this.usuarioRepository = usuarioRepository;
        this.usuarioAdapter = usuarioAdapter;
    }

    @Override
    public List<Tramite> listarTramitesAEvaluar(String dni) {
        List<TramiteEntity> entidades;

        if (dni != null && !dni.isBlank()) {
            entidades = tramiteRepository.findByEstadoActualAndSolicitante_IdSolicitante(
                    EstadoTramite.EN_EVALUACION,
                    dni
            );
        } else {
            entidades = tramiteRepository.findByEstadoActual(EstadoTramite.EN_EVALUACION);
        }

        return entidades.stream()
                .map(e -> tramiteAdapter.toModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public Tramite buscarPorId(Long id) {
        TramiteEntity entidad = tramiteRepository.findById(id).orElse(null);

        if (entidad == null) {
            return null;
        }

        return tramiteAdapter.toModel(entidad);
    }

    @Override
    public String procesarEvaluacion(Long id,
                                     boolean datosCompletos,
                                     boolean datosConsistentes,
                                     boolean cumpleRequisitos,
                                     boolean sustentoValido,
                                     String accion,
                                     String comentario) {

        TramiteEntity entidad = tramiteRepository.findById(id).orElse(null);

        if (entidad == null) {
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

        entidad.setDatosCompletos(datosCompletos);
        entidad.setDatosConsistentes(datosConsistentes);
        entidad.setCumpleRequisitos(cumpleRequisitos);
        entidad.setSustentoValido(sustentoValido);

        EstadoTramite estado;
        String comentarioTrazabilidad;

        if ("aprobar".equals(accion)) {
            entidad.setEstadoActual(EstadoTramite.APROBADO);
            estado = EstadoTramite.APROBADO;
            comentarioTrazabilidad = "Trámite aprobado" + agregarComentarioExtra(comentario);
        } else {
            entidad.setEstadoActual(EstadoTramite.RECHAZADO);
            estado = EstadoTramite.RECHAZADO;
            comentarioTrazabilidad = "Trámite rechazado por no cumplir con los siguientes criterios: "
                    + listarChecksNoCumplidos(datosCompletos, datosConsistentes, cumpleRequisitos, sustentoValido)
                    + agregarComentarioExtra(comentario);
        }

        TramiteEntity entidadGuardada = tramiteRepository.save(entidad);
        Tramite tramiteGuardado = tramiteAdapter.toModel(entidadGuardada);

        UsuarioEntity usuarioEntity = usuarioRepository
                .findFirstByActivoTrueOrderByIdUsuarioAsc()
                .orElse(null);

        if (usuarioEntity == null) {
            return "No se encontró un usuario evaluador activo";
        }

        Usuario usuarioEvaluador = usuarioAdapter.toModel(usuarioEntity);

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