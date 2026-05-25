// TramiteServiceImpl.java

package com.example.demo.Tramite;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.TipoTramite.TipoTramite;
import com.example.demo.TipoTramite.TipoTramiteService;
import com.example.demo.Usuario.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TramiteServiceImpl implements TramiteService {

    private final List<Tramite> tramites = DatosMemoria.TRAMITES;
    private final List<TipoTramite> tipoTramites = DatosMemoria.TIPOS_TRAMITE;
    private final List<Usuario> usuarios = DatosMemoria.USUARIOS;
    
    private final TrazabilidadService trazabilidadService;
    private final SolicitanteService solicitanteService;
    private final TipoTramiteService tipoTramiteService;

    public TramiteServiceImpl(TrazabilidadService trazabilidadService, 
                              SolicitanteService solicitanteService,
                              TipoTramiteService tipoTramiteService) {
        this.trazabilidadService = trazabilidadService;
        this.solicitanteService = solicitanteService;
        this.tipoTramiteService = tipoTramiteService;
    }

    @Override
    public List<Tramite> listarActivos(String idSolicitante) {

        List<Tramite> resultado = new ArrayList<>();

        for (Tramite t : tramites) {

            boolean activo =
                    t.getEstadoActual() != EstadoTramite.ARCHIVADO &&
                            t.getEstadoActual() != EstadoTramite.CANCELADO;

            boolean coincide =
                    (idSolicitante == null || idSolicitante.isBlank()) ||
                            t.getSolicitante().getIdSolicitante().equals(idSolicitante);

            if (activo && coincide) {
                resultado.add(t);
            }
        }

        return resultado;
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
    public Tramite registrar(Tramite tramite) {

        tramite.setNroTramite(generarNumeroTramite());
        tramite.setFechaRegistro(LocalDate.now());
        tramite.setEstadoActual(EstadoTramite.REGISTRADO);

        tramite.setSolicitante(
                solicitanteService.guardarOActualizarSolicitante(
                        tramite.getSolicitante()
                )
        );

        tramite.setTipoTramite(
                tipoTramiteService.buscarTipo(
                        tramite.getTipoTramite().getIdTipoTramite()
                )
        );

        tramites.add(tramite);

        trazabilidadService.registrarTrazabilidad(
                tramite,
                EstadoTramite.REGISTRADO,
                "Trámite registrado en el sistema",
                usuarios.get(0)
        );

        return tramite;
    }

    @Override
    public boolean editar(String id, Tramite form) {

        Tramite tramite = buscarPorId(id);

        if (tramite == null) {
            return false;
        }

        Solicitante solicitante =
                solicitanteService.guardarOActualizarSolicitante(
                        form.getSolicitante()
                );

        tramite.setSolicitante(solicitante);

        tramite.setTipoTramite(
                tipoTramiteService.buscarTipo(
                        form.getTipoTramite().getIdTipoTramite()
                )
        );

        return true;
    }

    @Override
    public boolean cambiarEstado(String id, EstadoTramite estado) {

        Tramite tramite = buscarPorId(id);

        if (tramite == null) {
            return false;
        }

        tramite.setEstadoActual(estado);

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

        trazabilidadService.registrarTrazabilidad(
                tramite,
                estado,
                comentario,
                usuarios.get(0)
        );

        return true;
    }



    private List<TipoTramite> listarTiposActivos() {

        List<TipoTramite> activos = new ArrayList<>();

        for (TipoTramite t : tipoTramites) {

            if (t.isActivo()) {
                activos.add(t);
            }
        }

        return activos;
    }

    @Override
    public String generarNumeroTramite() {
        int max = 0;
        for (Tramite t : tramites) {
            try {
                int num = Integer.parseInt(t.getNroTramite().substring(2));
                if (num > max) {
                    max = num;
                }
            } catch (Exception ignored) {
            }
        }
        return "TR" + (max + 1);
    }
}