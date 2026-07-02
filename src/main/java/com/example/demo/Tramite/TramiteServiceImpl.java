package com.example.demo.Tramite;

import com.example.demo.Solicitante.SolicitanteService;
import com.example.demo.TipoTramite.TipoTramiteService;
import com.example.demo.Trazabilidad.TrazabilidadService;
import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.UsuarioDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TramiteServiceImpl implements TramiteService {

    private final TramiteDAO tramiteDAO;
    private final TrazabilidadService trazabilidadService;
    private final SolicitanteService solicitanteService;
    private final TipoTramiteService tipoTramiteService;

    private final UsuarioDAO usuarioDAO;

    public TramiteServiceImpl(TramiteDAO tramiteDAO,
                              TrazabilidadService trazabilidadService,
                              SolicitanteService solicitanteService,
                              TipoTramiteService tipoTramiteService,
                              UsuarioDAO usuarioDAO) {

        this.tramiteDAO = tramiteDAO;
        this.trazabilidadService = trazabilidadService;
        this.solicitanteService = solicitanteService;
        this.tipoTramiteService = tipoTramiteService;
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<Tramite> listarActivos(String idSolicitante) {
        List<Tramite> tramites = tramiteDAO.listarTodos();

        return tramites.stream()
                .filter(tramite -> {
                    EstadoTramite estadoActual = tramite.getEstadoActual();
                    boolean activo = estadoActual != EstadoTramite.ARCHIVADO
                            && estadoActual != EstadoTramite.CANCELADO;

                    String idSolicitanteTramite = null;
                    if (tramite.getSolicitante() != null) {
                        idSolicitanteTramite = tramite.getSolicitante().getIdSolicitante();
                    }

                    boolean coincide = idSolicitante == null || idSolicitante.isBlank()
                            || (idSolicitanteTramite != null && idSolicitanteTramite.equals(idSolicitante));

                    return activo && coincide;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Tramite buscarPorId(Long id) {
        return tramiteDAO.buscarPorId(id);
    }

    @Override
    public Tramite registrar(Tramite tramite, String idUsuarioLogueado) {
        LocalDate fechaRegistro = LocalDate.now();
        EstadoTramite estadoInicial = EstadoTramite.REGISTRADO;

        tramite.setFechaRegistro(fechaRegistro);
        tramite.setEstadoActual(estadoInicial);

        

        Long idTipoTramite = tramite.getTipoTramite().getIdTipoTramite();
        tramite.setTipoTramite(
                tipoTramiteService.buscarTipo(idTipoTramite)
        );

        Tramite tramiteGuardado = tramiteDAO.guardar(tramite);

        Usuario usuarioTrazabilidad = null;
        if (idUsuarioLogueado != null) {
            usuarioTrazabilidad = usuarioDAO.buscarPorId(idUsuarioLogueado);
        }



        trazabilidadService.registrarTrazabilidad(
                tramiteGuardado,
                EstadoTramite.REGISTRADO,
                "Trámite registrado en el sistema",
                usuarioTrazabilidad
        );

        return tramiteGuardado;
    }

    @Override
    public boolean editar(Long id, Tramite form) {
        Tramite tramiteActual = buscarPorId(id);

        if (tramiteActual == null) {
            return false;
        }

        tramiteActual.setSolicitante(form.getSolicitante());

        Long idTipoTramite = form.getTipoTramite().getIdTipoTramite();
        tramiteActual.setTipoTramite(
                tipoTramiteService.buscarTipo(idTipoTramite)
        );

        tramiteDAO.actualizar(tramiteActual);

        return true;
    }

    @Override
    public boolean cambiarEstado(Long id, EstadoTramite estado, String idUsuarioLogueado) {
        Tramite tramiteActual = buscarPorId(id);

        if (tramiteActual == null) {
            return false;
        }

        tramiteActual.setEstadoActual(estado);

        String comentario;
        switch (estado) {
            case EN_EVALUACION:
                comentario = "Trámite derivado y en proceso de evaluación";
                break;
            case CANCELADO:
                comentario = "Trámite cancelado a solicitud del interesado";
                break;
            case ARCHIVADO:
                comentario = "Trámite archivado, proceso completado";
                break;
            default:
                comentario = "Cambio de estado a " + estado.name();
                break;
        }

        tramiteDAO.actualizar(tramiteActual);

        Usuario usuarioTrazabilidad = null;
        if (idUsuarioLogueado != null) {
            usuarioTrazabilidad = usuarioDAO.buscarPorId(idUsuarioLogueado);
        }



        trazabilidadService.registrarTrazabilidad(
                tramiteActual,
                estado,
                comentario,
                usuarioTrazabilidad
        );

        return true;
    }

    @Override
    public Long obtenerSiguienteId() {

        Long ultimoId = tramiteDAO.obtenerUltimoId();

        if (ultimoId == null) {
            return 1L;
        }

        return ultimoId + 1;
    }

}
