// TramiteServiceImpl.java

package com.example.demo.Tramite;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.TipoTramite.TipoTramite;
import com.example.demo.Usuario.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TramiteServiceImpl implements TramiteService {

    private final List<Tramite> tramites = DatosMemoria.TRAMITES;
    private final List<Solicitante> solicitantes = DatosMemoria.SOLICITANTES;
    private final List<TipoTramite> tipoTramites = DatosMemoria.TIPOS_TRAMITE;
    private final List<Trazabilidad> trazabilidades = DatosMemoria.TRAZABILIDADES;
    private final List<Usuario> usuarios = DatosMemoria.USUARIOS;

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
    public List<Trazabilidad> obtenerTrazabilidad(String nroTramite) {

        List<Trazabilidad> resultado = new ArrayList<>();

        for (Trazabilidad t : trazabilidades) {

            if (t.getTramite().getNroTramite().equals(nroTramite)) {
                resultado.add(t);
            }
        }

        resultado.sort((a, b) ->
                b.getFechaHora().compareTo(a.getFechaHora()));

        return resultado;
    }

    @Override
    public FormularioTramiteDTO prepararFormularioRegistro(
            Tramite tramite,
            String tipoId) {

        if (tramite.getSolicitante() == null) {
            tramite.setSolicitante(new Solicitante());
        }

        String idSolicitante =
                tramite.getSolicitante().getIdSolicitante();

        Solicitante solicitante =
                buscarSolicitante(
                        idSolicitante,
                        tramite.getSolicitante()
                );

        boolean existe =
                existeSolicitante(idSolicitante);

        TipoTramite tipoSeleccionado =
                buscarTipo(tipoId);

        return construirFormularioDTO(
                tramite,
                solicitante,
                tipoSeleccionado,
                tipoId,
                idSolicitante,
                existe,
                generarNumeroTramite()
        );
    }

    @Override
    public FormularioTramiteDTO prepararFormularioEdicion(
            String id,
            Tramite form) {

        Tramite tramite = buscarPorId(id);

        if (tramite == null) {
            return null;
        }

        if (form.getSolicitante() == null) {
            form.setSolicitante(tramite.getSolicitante());
        }

        String idSolicitante =
                form.getSolicitante().getIdSolicitante();

        TipoTramite tipoSeleccionado =
                buscarTipo(
                        tramite.getTipoTramite().getIdTipoTramite()
                );

        return construirFormularioDTO(
                form,
                form.getSolicitante(),
                tipoSeleccionado,
                tipoSeleccionado.getIdTipoTramite(),
                idSolicitante,
                true,
                tramite.getNroTramite()
        );
    }

    @Override
    public boolean validarSolicitante(Solicitante s) {

        return !(s.getIdSolicitante() == null || s.getIdSolicitante().isBlank() ||
                s.getNombreCompleto() == null || s.getNombreCompleto().isBlank() ||
                s.getCorreoElectronico() == null || s.getCorreoElectronico().isBlank() ||
                s.getTelefonoContacto() == null || s.getTelefonoContacto().isBlank());
    }

    @Override
    public Tramite registrar(Tramite tramite) {

        tramite.setNroTramite(generarNumeroTramite());
        tramite.setFechaRegistro(LocalDate.now());
        tramite.setEstadoActual(EstadoTramite.REGISTRADO);

        tramite.setSolicitante(
                guardarOActualizarSolicitante(
                        tramite.getSolicitante()
                )
        );

        tramite.setTipoTramite(
                buscarTipo(
                        tramite.getTipoTramite().getIdTipoTramite()
                )
        );

        tramites.add(tramite);

        Trazabilidad trazabilidad = new Trazabilidad();

        trazabilidad.setIdTrazabilidad(
                "TZ" + (trazabilidades.size() + 1)
        );

        trazabilidad.setTramite(tramite);
        trazabilidad.setUsuario(usuarios.get(0));
        trazabilidad.setEstadoCambio(EstadoTramite.REGISTRADO);
        trazabilidad.setComentario("Trámite registrado en el sistema");
        trazabilidad.setFechaHora(LocalDateTime.now());

        trazabilidades.add(trazabilidad);

        return tramite;
    }

    @Override
    public boolean editar(String id, Tramite form) {

        Tramite tramite = buscarPorId(id);

        if (tramite == null) {
            return false;
        }

        Solicitante solicitante =
                guardarOActualizarSolicitante(
                        form.getSolicitante()
                );

        tramite.setSolicitante(solicitante);

        tramite.setTipoTramite(
                buscarTipo(
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

        Trazabilidad tr = new Trazabilidad();

        tr.setIdTrazabilidad(
                "TZ" + (trazabilidades.size() + 1)
        );

        tr.setTramite(tramite);
        tr.setUsuario(usuarios.get(0));
        tr.setEstadoCambio(estado);

        switch (estado) {

            case EN_EVALUACION:
                tr.setComentario("Trámite derivado y en proceso de evaluación");
                break;

            case CANCELADO:
                tr.setComentario("Trámite cancelado a solicitud del interesado");
                break;

            case ARCHIVADO:
                tr.setComentario("Trámite archivado, proceso completado");
                break;

            default:
                tr.setComentario("Cambio de estado a " + estado.name());
                break;
        }

        tr.setFechaHora(LocalDateTime.now());

        trazabilidades.add(tr);

        return true;
    }



    // HELPERS PRIVADOS DEL SERVICE
    private Solicitante guardarOActualizarSolicitante(Solicitante s) {

        for (Solicitante existente : solicitantes) {

            if (existente.getIdSolicitante().equals(
                    s.getIdSolicitante())) {

                existente.setNombreCompleto(
                        s.getNombreCompleto());

                existente.setCorreoElectronico(
                        s.getCorreoElectronico());

                existente.setTelefonoContacto(
                        s.getTelefonoContacto());

                return existente;
            }
        }

        solicitantes.add(s);

        return s;
    }

    private TipoTramite buscarTipo(String id) {

        if (id == null) {
            return null;
        }

        for (TipoTramite t : tipoTramites) {

            if (t.getIdTipoTramite().equals(id)) {
                return t;
            }
        }

        return null;
    }

    private Solicitante buscarSolicitante(
            String idSolicitante,
            Solicitante fallback) {

        if (idSolicitante == null) {
            return fallback;
        }

        for (Solicitante s : solicitantes) {

            if (s.getIdSolicitante().equals(idSolicitante)) {
                return s;
            }
        }

        return fallback;
    }

    private boolean existeSolicitante(String idSolicitante) {

        if (idSolicitante == null) {
            return false;
        }

        for (Solicitante s : solicitantes) {

            if (s.getIdSolicitante().equals(idSolicitante)) {
                return true;
            }
        }

        return false;
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

    private String generarNumeroTramite() {

        int max = 0;

        for (Tramite t : tramites) {

            try {

                int num = Integer.parseInt(
                        t.getNroTramite().substring(2)
                );

                if (num > max) {
                    max = num;
                }

            } catch (Exception ignored) {
            }
        }

        return "TR" + (max + 1);
    }

    private FormularioTramiteDTO construirFormularioDTO(
            Tramite tramite,
            Solicitante solicitante,
            TipoTramite tipoSeleccionado,
            String tipoId,
            String idSolicitante,
            boolean existe,
            String nro) {

        return new FormularioTramiteDTO(
                tramite,
                solicitante,
                tipoSeleccionado,
                listarTiposActivos(),
                tipoId,
                idSolicitante,
                existe,
                nro
        );
    }
}