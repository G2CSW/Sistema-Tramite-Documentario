// TramiteController.java

package com.example.demo.Tramite;

import com.example.demo.Solicitante.Solicitante;
import com.example.demo.Solicitante.SolicitanteService;
import com.example.demo.TipoTramite.TipoTramite;
import com.example.demo.TipoTramite.TipoTramiteService;
import com.example.demo.Trazabilidad.TrazabilidadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tramite")
public class TramiteController {

    private final TramiteService tramiteService;
    private final TrazabilidadService trazabilidadService;
    private final SolicitanteService solicitanteService;
    private final TipoTramiteService tipoTramiteService;

    public TramiteController(TramiteService tramiteService, 
                             TrazabilidadService trazabilidadService,
                             SolicitanteService solicitanteService,
                             TipoTramiteService tipoTramiteService) {
        this.tramiteService = tramiteService;
        this.trazabilidadService = trazabilidadService;
        this.solicitanteService = solicitanteService;
        this.tipoTramiteService = tipoTramiteService;
    }

    @GetMapping("/listar")
    public String listarTramites(
            @RequestParam(required = false)
            String idSolicitante,
            Model model) {

        model.addAttribute(
                "tramites",
                tramiteService.listarActivos(idSolicitante)
        );

        model.addAttribute(
                "idSolicitanteBuscado",
                idSolicitante
        );

        return "tramite/tramites";
    }

    @GetMapping("/{nroTramite}")
    public String mostrarSeguimiento(
            @PathVariable Long nroTramite,
            Model model) {

        model.addAttribute(
                "tramite",
                tramiteService.buscarPorId(nroTramite)
        );

        model.addAttribute(
                "trazabilidades",
                trazabilidadService.obtenerTrazabilidad(nroTramite)
        );

        return "tramite/seguimiento";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(
            @ModelAttribute("tramite") Tramite tramite,
            Model model) {

        Long tipoId = null;
        if (tramite.getTipoTramite() != null) {
            tipoId = tramite.getTipoTramite().getIdTipoTramite();
        }

        cargarFormularioRegistro(model, tramite, tipoId);

        return "tramite/registrarTramite";
    }

    @PostMapping("/registrar")
    public String registrarTramite(
            @ModelAttribute Tramite tramite,
            RedirectAttributes ra,
            Model model) {

        if (!solicitanteService.validarSolicitante(
                tramite.getSolicitante())) {

            model.addAttribute(
                    "error",
                    "Complete todos los datos del solicitante"
            );

            Long tipoId = tramite.getTipoTramite() != null ? tramite.getTipoTramite().getIdTipoTramite() : null;
            cargarFormularioRegistro(model, tramite, tipoId);

            return "tramite/registrarTramite";
        }

        Tramite registrado =
                tramiteService.registrar(tramite);

        ra.addFlashAttribute(
                "mensaje",
                "Trámite " +
                        registrado.getNroTramite() +
                        " registrado correctamente"
        );

        return "redirect:/tramite/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(
            @PathVariable Long id,
            @ModelAttribute("tramite") Tramite form,
            RedirectAttributes ra,
            Model model) {

        Tramite tramite = tramiteService.buscarPorId(id);

        if (tramite == null) {
            ra.addFlashAttribute(
                    "mensaje",
                    "Trámite no encontrado"
            );
            return "redirect:/tramite/listar";
        }

        if (form.getSolicitante() == null) {
            form.setSolicitante(tramite.getSolicitante());
        }

        cargarFormularioEdicion(model, form, tramite);

        return "tramite/editarTramite";
    }

    @PostMapping("/editar/{id}")
    public String editarTramite(
            @PathVariable Long id,
            @ModelAttribute Tramite form,
            RedirectAttributes ra,
            Model model) {

        if (!solicitanteService.validarSolicitante(
                form.getSolicitante())) {

            model.addAttribute(
                    "error",
                    "Complete todos los datos del solicitante"
            );

            Tramite tramite = tramiteService.buscarPorId(id);
            if (tramite != null) {
                cargarFormularioEdicion(model, form, tramite);
            } else {
                ra.addFlashAttribute("mensaje", "Trámite no encontrado");
                return "redirect:/tramite/listar";
            }

            return "tramite/editarTramite";
        }

        boolean actualizado =
                tramiteService.editar(id, form);

        if (!actualizado) {

            ra.addFlashAttribute(
                    "mensaje",
                    "Trámite no encontrado"
            );

            return "redirect:/tramite/listar";
        }

        ra.addFlashAttribute(
                "mensaje",
                "Trámite actualizado correctamente"
        );

        return "redirect:/tramite/listar";
    }

    @PostMapping("/cambiar-estado/{id}")
    public String cambiarEstadoTramite(
            @PathVariable Long id,
            @RequestParam("estado")
            EstadoTramite estado,
            RedirectAttributes ra) {

        boolean actualizado =
                tramiteService.cambiarEstado(
                        id,
                        estado
                );

        if (actualizado) {

            ra.addFlashAttribute(
                    "mensaje",
                    "Estado del trámite actualizado"
            );

        } else {

            ra.addFlashAttribute(
                    "mensaje",
                    "Trámite no encontrado"
            );
        }

        return "redirect:/tramite/listar";
    }



    private void cargarFormularioRegistro(
            Model model,
            Tramite tramite,
            Long tipoId) {

        if (tramite.getSolicitante() == null) {
            tramite.setSolicitante(new Solicitante());
        }

        String idSolicitante = tramite.getSolicitante().getIdSolicitante();
        Solicitante solicitanteBuscado = solicitanteService.buscarSolicitante(idSolicitante);
        Solicitante solicitante = solicitanteBuscado != null ? solicitanteBuscado : tramite.getSolicitante();
        boolean existe = solicitanteService.existeSolicitante(idSolicitante);
        
        TipoTramite tipoSeleccionado = tipoId != null ? tipoTramiteService.buscarTipo(tipoId) : null;
        List<TipoTramite> tipoTramitesActivos = tipoTramiteService.listar().stream()
                .filter(TipoTramite::isActivo).collect(Collectors.toList());

        model.addAttribute("tramite", tramite);
        model.addAttribute("solicitante", solicitante);
        model.addAttribute("tipoSeleccionado", tipoSeleccionado);
        model.addAttribute("tipoTramites", tipoTramitesActivos);
        model.addAttribute("tipoTramiteId", tipoId);
        model.addAttribute("idSolicitanteBuscado", idSolicitante);
        model.addAttribute("existeSolicitante", existe);
        model.addAttribute("numeroTramiteGenerado", tramiteService.obtenerSiguienteId());
    }

    private void cargarFormularioEdicion(
            Model model,
            Tramite form,
            Tramite tramiteOriginal) {

        if (form.getSolicitante() == null) {
            form.setSolicitante(tramiteOriginal.getSolicitante());
        }

        String idSolicitante =
                form.getSolicitante().getIdSolicitante();

        Long tipoId = null;

        if (form.getTipoTramite() != null) {
            tipoId = form.getTipoTramite().getIdTipoTramite();
        } else if (tramiteOriginal.getTipoTramite() != null) {
            tipoId = tramiteOriginal.getTipoTramite().getIdTipoTramite();
        }

        TipoTramite tipoSeleccionado =
                tipoId != null
                        ? tipoTramiteService.buscarTipo(tipoId)
                        : null;

        List<TipoTramite> tipoTramitesActivos =
                tipoTramiteService.listar()
                        .stream()
                        .filter(TipoTramite::isActivo)
                        .collect(Collectors.toList());

        model.addAttribute("tramite", form);
        model.addAttribute("solicitante", form.getSolicitante());
        model.addAttribute("tipoSeleccionado", tipoSeleccionado);
        model.addAttribute("tipoTramites", tipoTramitesActivos);
        model.addAttribute("tipoTramiteId", tipoId);
        model.addAttribute("idSolicitanteBuscado", idSolicitante);
        model.addAttribute("existeSolicitante", true);
        model.addAttribute("numeroTramiteGenerado", tramiteOriginal.getNroTramite());
    }
}