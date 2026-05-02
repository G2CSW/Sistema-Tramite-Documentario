package com.example.demo.Tramite;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.TipoTramite.TipoTramite;
import com.example.demo.Usuario.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tramite")
public class TramiteController {

    private final List<Tramite> tramites = DatosMemoria.TRAMITES;
    private final List<Solicitante> solicitantes = DatosMemoria.SOLICITANTES;
    private final List<TipoTramite> tipoTramites = DatosMemoria.TIPOS_TRAMITE;
    private final List<Trazabilidad> trazabilidades = DatosMemoria.TRAZABILIDADES;
    private final List<Usuario> usuarios = DatosMemoria.USUARIOS;

    // página listar tramite + filtro por idSolicitante
    @GetMapping("/listar")
    public String listarTramites(@RequestParam(required = false) String idSolicitante, Model model) {

        List<Tramite> resultado = new ArrayList<>();

        for (Tramite t : tramites) {
            boolean activo = t.getEstadoActual() != EstadoTramite.ARCHIVADO &&
                    t.getEstadoActual() != EstadoTramite.CANCELADO;

            boolean coincide = (idSolicitante == null || idSolicitante.isBlank()) ||
                    t.getSolicitante().getIdSolicitante().equals(idSolicitante);

            if (activo && coincide) {
                resultado.add(t);
            }
        }

        model.addAttribute("tramites", resultado);
        model.addAttribute("idSolicitanteBuscado", idSolicitante);

        return "tramite/tramites";
    }

    @GetMapping("/{nroTramite}")
    public String mostrarSeguimiento(@PathVariable String nroTramite, Model model) {

        List<Trazabilidad> resultado = new ArrayList<>();
        Tramite tramite = null;

        for (Tramite t : tramites) {
            if (t.getNroTramite().equals(nroTramite)) {
                tramite = t;
                break;
            }
        }

        for (Trazabilidad t : trazabilidades) {
            if (t.getTramite().getNroTramite().equals(nroTramite)) {
                resultado.add(t);
            }
        }

        // Ordenar (más reciente primero)
        resultado.sort((a, b) -> b.getFechaHora().compareTo(a.getFechaHora()));


        model.addAttribute("tramite", tramite);
        model.addAttribute("trazabilidades", resultado);

        return "tramite/seguimiento";
    }

    // página registrar tramite
    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(
            @ModelAttribute("tramite") Tramite tramite,
            @RequestParam(required = false, name = "tipoTramite.idTipoTramite") String tipoId,
            Model model) {

        if (tramite.getSolicitante() == null) {
            tramite.setSolicitante(new Solicitante());
        }

        String idSolicitante = tramite.getSolicitante().getIdSolicitante();

        Solicitante solicitante = buscarSolicitante(idSolicitante, tramite.getSolicitante());
        boolean existe = existeSolicitante(idSolicitante);

        TipoTramite tipoSeleccionado = buscarTipo(tipoId);

        cargarModeloFormulario(model, tramite, solicitante, tipoSeleccionado, tipoId, idSolicitante, existe, generarNumeroTramite());

        return "tramite/registrarTramite";
    }

    // registrar tramite
    @PostMapping("/registrar")
    public String registrarTramite(@ModelAttribute Tramite tramite,
                                   Model model,
                                   RedirectAttributes redirectAttributes) {

        if (!validarSolicitante(tramite.getSolicitante())) {
            return devolverFormularioConError(model, tramite, "Complete todos los datos del solicitante", "tramite/registrarTramite", generarNumeroTramite());
        }

        tramite.setNroTramite(generarNumeroTramite());
        tramite.setFechaRegistro(LocalDate.now());
        tramite.setEstadoActual(EstadoTramite.REGISTRADO);

        tramite.setSolicitante(guardarOActualizarSolicitante(tramite.getSolicitante()));
        tramite.setTipoTramite(buscarTipo(tramite.getTipoTramite().getIdTipoTramite()));

        tramites.add(tramite);

        // guardar trazabilidad inicial
        Trazabilidad trazabilidad = new Trazabilidad();
        trazabilidad.setIdTrazabilidad("TZ" + (DatosMemoria.TRAZABILIDADES.size() + 1));
        trazabilidad.setTramite(tramite);
        trazabilidad.setUsuario(usuarios.get(0));
        trazabilidad.setEstadoCambio(EstadoTramite.REGISTRADO);
        trazabilidad.setComentario("Trámite registrado en el sistema");
        trazabilidad.setFechaHora(java.time.LocalDateTime.now());

        DatosMemoria.TRAZABILIDADES.add(trazabilidad);

        redirectAttributes.addFlashAttribute("mensaje", "Trámite " + tramite.getNroTramite() + " registrado correctamente");
        return "redirect:/tramite/listar";
    }

    // página editar tramite
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(
            @PathVariable String id,
            @ModelAttribute("tramite") Tramite form,
            @RequestParam(required = false, name = "tipoTramite.idTipoTramite") String tipoId,
            Model model,
            RedirectAttributes ra) {

        Tramite t = buscarPorId(id);

        if (t == null) {
            ra.addFlashAttribute("mensaje", "Trámite no encontrado");
            return "redirect:/tramite/listar";
        }

        if (form.getSolicitante() == null) {
            form.setSolicitante(t.getSolicitante());
        }

        String idSolicitante = form.getSolicitante().getIdSolicitante();

        TipoTramite tipoSeleccionado = buscarTipo(
                tipoId != null ? tipoId : t.getTipoTramite().getIdTipoTramite()
        );

        cargarModeloFormulario(model, form, form.getSolicitante(), tipoSeleccionado,
                tipoSeleccionado.getIdTipoTramite(), idSolicitante, true, t.getNroTramite());

        return "tramite/editarTramite";
    }

    // Guardar Cambios trámite
    @PostMapping("/editar/{id}")
    public String editarTramite(@PathVariable String id,
                                @ModelAttribute Tramite form,
                                Model model,
                                RedirectAttributes ra) {

        Tramite t = buscarPorId(id);

        if (t == null) {
            ra.addFlashAttribute("mensaje", "Trámite no encontrado");
            return "redirect:/tramite/listar";
        }

        if (!validarSolicitante(form.getSolicitante())) {
            return devolverFormularioConError(model, form, "Complete todos los datos del solicitante",
                    "tramite/editarTramite", t.getNroTramite());
        }

        Solicitante s = guardarOActualizarSolicitante(form.getSolicitante());
        t.setSolicitante(s);
        t.setTipoTramite(buscarTipo(form.getTipoTramite().getIdTipoTramite()));

        ra.addFlashAttribute("mensaje", "Trámite actualizado correctamente");
        return "redirect:/tramite/listar";
    }

    @PostMapping("/cambiar-estado/{id}")
    public String cambiarEstadoTramite(@PathVariable String id,
                                       @RequestParam("estado") EstadoTramite estado,
                                       RedirectAttributes redirectAttributes) {

        Tramite tramite = buscarPorId(id);

        if (tramite != null) {

            // Cambiar estado
            tramite.setEstadoActual(estado);

            // Registrar trazabilidad
            Trazabilidad tr = new Trazabilidad();
            tr.setIdTrazabilidad("TZ" + (DatosMemoria.TRAZABILIDADES.size() + 1));
            tr.setTramite(tramite);
            tr.setUsuario(usuarios.get(0)); // o usuario logueado
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
            tr.setFechaHora(java.time.LocalDateTime.now());

            DatosMemoria.TRAZABILIDADES.add(tr);

            redirectAttributes.addFlashAttribute("mensaje", "Estado del trámite actualizado");

        } else {
            redirectAttributes.addFlashAttribute("mensaje", "Trámite no encontrado");
        }

        return "redirect:/tramite/listar";
    }



    // FUNCIONES REUTILIZABLES

    private boolean validarSolicitante(Solicitante s) {
        return !(s.getIdSolicitante() == null || s.getIdSolicitante().isBlank() ||
                s.getNombreCompleto() == null || s.getNombreCompleto().isBlank() ||
                s.getCorreoElectronico() == null || s.getCorreoElectronico().isBlank() ||
                s.getTelefonoContacto() == null || s.getTelefonoContacto().isBlank());
    }

    private Solicitante guardarOActualizarSolicitante(Solicitante s) {
        for (Solicitante existente : solicitantes) {
            if (existente.getIdSolicitante().equals(s.getIdSolicitante())) {
                existente.setNombreCompleto(s.getNombreCompleto());
                existente.setCorreoElectronico(s.getCorreoElectronico());
                existente.setTelefonoContacto(s.getTelefonoContacto());
                return existente;
            }
        }
        solicitantes.add(s);
        return s;
    }

    private TipoTramite buscarTipo(String id) {
        if (id == null) return new TipoTramite();
        for (TipoTramite t : tipoTramites) {
            if (t.getIdTipoTramite().equals(id)) return t;
        }
        return new TipoTramite();
    }

    private Solicitante buscarSolicitante(String idSolicitante, Solicitante fallback) {
        if (idSolicitante == null) return fallback;
        for (Solicitante s : solicitantes) {
            if (s.getIdSolicitante().equals(idSolicitante)) return s;
        }
        return fallback;
    }

    private boolean existeSolicitante(String idSolicitante) {
        if (idSolicitante == null) return false;
        for (Solicitante s : solicitantes) {
            if (s.getIdSolicitante().equals(idSolicitante)) return true;
        }
        return false;
    }

    private void cargarModeloFormulario(Model model, Tramite tramite,
                                        Solicitante solicitante,
                                        TipoTramite tipo,
                                        String tipoId,
                                        String idSolicitante,
                                        boolean existe,
                                        String nro) {

        List<TipoTramite> tipoTramitesActivos = new ArrayList<>();

        for (TipoTramite t : tipoTramites) {
            if (t.isActivo()) {
                tipoTramitesActivos.add(t);
            }
        }
        model.addAttribute("tramite", tramite);
        model.addAttribute("solicitante", solicitante);
        model.addAttribute("tipoSeleccionado", tipo);
        model.addAttribute("tipoTramites", tipoTramitesActivos);
        model.addAttribute("tipoTramiteId", tipoId);
        model.addAttribute("idSolicitanteBuscado", idSolicitante);
        model.addAttribute("existeSolicitante", existe);
        model.addAttribute("numeroTramiteGenerado", nro);
    }

    private String devolverFormularioConError(Model model, Tramite tramite,
                                              String error, String vista, String nro) {

        model.addAttribute("error", error);

        String tipoId = tramite.getTipoTramite() != null
                ? tramite.getTipoTramite().getIdTipoTramite()
                : null;

        TipoTramite tipo = buscarTipo(tipoId);

        cargarModeloFormulario(model, tramite, tramite.getSolicitante(),
                tipo, tipoId, tramite.getSolicitante().getIdSolicitante(),
                existeSolicitante(tramite.getSolicitante().getIdSolicitante()), nro);

        return vista;
    }

    private Tramite buscarPorId(String id) {
        for (Tramite t : tramites) {
            if (t.getNroTramite().equals(id)) return t;
        }
        return null;
    }

    private String generarNumeroTramite() {
        int max = 0;
        for (Tramite t : tramites) {
            try {
                int num = Integer.parseInt(t.getNroTramite().substring(2));
                if (num > max) max = num;
            } catch (Exception ignored) {}
        }
        return "TR" + (max + 1);
    }
}