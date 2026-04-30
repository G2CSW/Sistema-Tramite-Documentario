package com.example.demo.Tramite;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.TipoTramite.TipoTramite;
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

    // página listar tramite + filtro por dni
    @GetMapping("/listar")
    public String listarTramites(@RequestParam(required = false) String dni, Model model) {

        List<Tramite> resultado = new ArrayList<>();

        for (Tramite t : tramites) {
            boolean activo = t.getEstadoActual() != EstadoTramite.ARCHIVADO &&
                    t.getEstadoActual() != EstadoTramite.CANCELADO;

            boolean coincide = (dni == null || dni.isBlank()) ||
                    t.getSolicitante().getDni().equals(dni);

            if (activo && coincide) {
                resultado.add(t);
            }
        }

        model.addAttribute("tramites", resultado);
        model.addAttribute("dniBuscado", dni);

        return "tramite/tramites";
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

        String dni = tramite.getSolicitante().getDni();

        Solicitante solicitante = buscarSolicitante(dni, tramite.getSolicitante());
        boolean existe = existeSolicitante(dni);

        TipoTramite tipoSeleccionado = buscarTipo(tipoId);

        cargarModeloFormulario(model, tramite, solicitante, tipoSeleccionado, tipoId, dni, existe, generarNumeroTramite());

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

        String dni = form.getSolicitante().getDni();

        TipoTramite tipoSeleccionado = buscarTipo(
                tipoId != null ? tipoId : t.getTipoTramite().getIdTipoTramite()
        );

        cargarModeloFormulario(model, form, form.getSolicitante(), tipoSeleccionado,
                tipoSeleccionado.getIdTipoTramite(), dni, true, t.getNroTramite());

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

        t.setSolicitante(form.getSolicitante());
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
            tramite.setEstadoActual(estado);
            redirectAttributes.addFlashAttribute("mensaje", "Estado del trámite actualizado");
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "Trámite no encontrado");
        }

        return "redirect:/tramite/listar";
    }

    // FUNCIONES REUTILIZABLES

    private boolean validarSolicitante(Solicitante s) {
        return !(s.getDni() == null || s.getDni().isBlank() ||
                s.getNombreCompleto() == null || s.getNombreCompleto().isBlank() ||
                s.getCorreoElectronico() == null || s.getCorreoElectronico().isBlank() ||
                s.getTelefonoContacto() == null || s.getTelefonoContacto().isBlank());
    }

    private Solicitante guardarOActualizarSolicitante(Solicitante s) {
        for (Solicitante existente : solicitantes) {
            if (existente.getDni().equals(s.getDni())) {
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

    private Solicitante buscarSolicitante(String dni, Solicitante fallback) {
        if (dni == null) return fallback;
        for (Solicitante s : solicitantes) {
            if (s.getDni().equals(dni)) return s;
        }
        return fallback;
    }

    private boolean existeSolicitante(String dni) {
        if (dni == null) return false;
        for (Solicitante s : solicitantes) {
            if (s.getDni().equals(dni)) return true;
        }
        return false;
    }

    private void cargarModeloFormulario(Model model, Tramite tramite,
                                        Solicitante solicitante,
                                        TipoTramite tipo,
                                        String tipoId,
                                        String dni,
                                        boolean existe,
                                        String nro) {

        model.addAttribute("tramite", tramite);
        model.addAttribute("solicitante", solicitante);
        model.addAttribute("tipoSeleccionado", tipo);
        model.addAttribute("tipoTramites", tipoTramites);
        model.addAttribute("tipoTramiteId", tipoId);
        model.addAttribute("dniBuscado", dni);
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
                tipo, tipoId, tramite.getSolicitante().getDni(),
                existeSolicitante(tramite.getSolicitante().getDni()), nro);

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