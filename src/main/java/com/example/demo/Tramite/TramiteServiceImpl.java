package com.example.demo.Tramite;

import com.example.demo.Solicitante.SolicitanteService;
import com.example.demo.TipoTramite.TipoTramiteService;
import com.example.demo.Trazabilidad.TrazabilidadService;
import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.UsuarioAdapter;
import com.example.demo.Usuario.UsuarioEntity;
import com.example.demo.Usuario.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TramiteServiceImpl implements TramiteService {

    private final TramiteRepository tramiteRepository;
    private final TramiteAdapter tramiteAdapter;
    private final TrazabilidadService trazabilidadService;
    private final SolicitanteService solicitanteService;
    private final TipoTramiteService tipoTramiteService;



    private final UsuarioRepository usuarioRepository;
    private final UsuarioAdapter usuarioAdapter;

    public TramiteServiceImpl(TramiteRepository tramiteRepository,
                              TramiteAdapter tramiteAdapter,
                              TrazabilidadService trazabilidadService,
                              SolicitanteService solicitanteService,
                              TipoTramiteService tipoTramiteService,
                              UsuarioRepository usuarioRepository,
                              UsuarioAdapter usuarioAdapter) {

        this.tramiteRepository = tramiteRepository;
        this.tramiteAdapter = tramiteAdapter;
        this.trazabilidadService = trazabilidadService;
        this.solicitanteService = solicitanteService;
        this.tipoTramiteService = tipoTramiteService;
        this.usuarioRepository = usuarioRepository;
        this.usuarioAdapter = usuarioAdapter;
    }

    @Override
    public List<Tramite> listarActivos(String idSolicitante) {
        List<TramiteEntity> entidades = tramiteRepository.findAll();

        return entidades.stream()
                .filter(entidad -> {
                    EstadoTramite estadoActual = entidad.getEstadoActual();
                    boolean activo = estadoActual != EstadoTramite.ARCHIVADO
                            && estadoActual != EstadoTramite.CANCELADO;

                    String idSolicitanteEntidad = null;
                    if (entidad.getSolicitante() != null) {
                        idSolicitanteEntidad = entidad.getSolicitante().getIdSolicitante();
                    }

                    boolean coincide = idSolicitante == null || idSolicitante.isBlank()
                            || (idSolicitanteEntidad != null && idSolicitanteEntidad.equals(idSolicitante));

                    return activo && coincide;
                })
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
    public Tramite registrar(Tramite tramite) {
        Long numeroTramite = obtenerSiguienteId();
        LocalDate fechaRegistro = LocalDate.now();
        EstadoTramite estadoInicial = EstadoTramite.REGISTRADO;

        tramite.setFechaRegistro(fechaRegistro);
        tramite.setEstadoActual(estadoInicial);

        tramite.setSolicitante(
                solicitanteService.guardarOActualizarSolicitante(tramite.getSolicitante())
        );

        Long idTipoTramite = tramite.getTipoTramite().getIdTipoTramite();
        tramite.setTipoTramite(
                tipoTramiteService.buscarTipo(idTipoTramite)
        );

        TramiteEntity entidad = tramiteAdapter.toEntity(tramite);
        TramiteEntity entidadGuardada = tramiteRepository.save(entidad);
        Tramite tramiteGuardado = tramiteAdapter.toModel(entidadGuardada);


        UsuarioEntity usuarioEntity = usuarioRepository.findById("12345678").orElse(null);
        if (usuarioEntity == null) {
            return tramiteGuardado;
        }
        Usuario usuarioTrazabilidad = usuarioAdapter.toModel(usuarioEntity);



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

        tramiteActual.setSolicitante(
                solicitanteService.guardarOActualizarSolicitante(form.getSolicitante())
        );

        Long idTipoTramite = form.getTipoTramite().getIdTipoTramite();
        tramiteActual.setTipoTramite(
                tipoTramiteService.buscarTipo(idTipoTramite)
        );

        TramiteEntity entidad = tramiteAdapter.toEntity(tramiteActual);
        tramiteRepository.save(entidad);

        return true;
    }

    @Override
    public boolean cambiarEstado(Long id, EstadoTramite estado) {
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

        TramiteEntity entidad = tramiteAdapter.toEntity(tramiteActual);
        tramiteRepository.save(entidad);



        Usuario usuarioTrazabilidad = null;
        UsuarioEntity usuarioEntity = usuarioRepository.findById("12345678").orElse(null);

        if (usuarioEntity != null) {
            usuarioTrazabilidad = usuarioAdapter.toModel(usuarioEntity);
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

        Long ultimoId = tramiteRepository.obtenerUltimoId();

        if (ultimoId == null) {
            return 1L;
        }

        return ultimoId + 1;
    }

}