// TramiteController.java

package com.example.demo.Tramite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tramite")
public class TramiteController {

    private final TramiteService tramiteService;

    public TramiteController(TramiteService tramiteService) {
        this.tramiteService = tramiteService;
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
            @PathVariable String nroTramite,
            Model model) {

        model.addAttribute(
                "tramite",
                tramiteService.buscarPorId(nroTramite)
        );

        model.addAttribute(
                "trazabilidades",
                tramiteService.obtenerTrazabilidad(nroTramite)
        );

        return "tramite/seguimiento";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(
            @ModelAttribute("tramite") Tramite tramite,
            @RequestParam(required = false,
                    name = "tipoTramite.idTipoTramite")
            String tipoId,
            Model model) {

        FormularioTramiteDTO dto =
                tramiteService.prepararFormularioRegistro(
                        tramite,
                        tipoId
                );

        cargarFormulario(model, dto);

        return "tramite/registrarTramite";
    }

    @PostMapping("/registrar")
    public String registrarTramite(
            @ModelAttribute Tramite tramite,
            RedirectAttributes ra,
            Model model) {

        if (!tramiteService.validarSolicitante(
                tramite.getSolicitante())) {

            FormularioTramiteDTO dto =
                    tramiteService.prepararFormularioRegistro(
                            tramite,
                            tramite.getTipoTramite() != null
                                    ? tramite.getTipoTramite()
                                    .getIdTipoTramite()
                                    : null
                    );

            model.addAttribute(
                    "error",
                    "Complete todos los datos del solicitante"
            );

            cargarFormulario(model, dto);

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
            @PathVariable String id,
            @ModelAttribute("tramite") Tramite form,
            RedirectAttributes ra,
            Model model) {

        FormularioTramiteDTO dto =
                tramiteService.prepararFormularioEdicion(
                        id,
                        form
                );

        if (dto == null) {

            ra.addFlashAttribute(
                    "mensaje",
                    "Trámite no encontrado"
            );

            return "redirect:/tramite/listar";
        }

        cargarFormulario(model, dto);

        return "tramite/editarTramite";
    }

    @PostMapping("/editar/{id}")
    public String editarTramite(
            @PathVariable String id,
            @ModelAttribute Tramite form,
            RedirectAttributes ra,
            Model model) {

        if (!tramiteService.validarSolicitante(
                form.getSolicitante())) {

            FormularioTramiteDTO dto =
                    tramiteService.prepararFormularioEdicion(
                            id,
                            form
                    );

            model.addAttribute(
                    "error",
                    "Complete todos los datos del solicitante"
            );

            cargarFormulario(model, dto);

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
            @PathVariable String id,
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



    private void cargarFormulario(
            Model model,
            FormularioTramiteDTO dto) {

        model.addAttribute("tramite", dto.getTramite());
        model.addAttribute("solicitante", dto.getSolicitante());
        model.addAttribute("tipoSeleccionado", dto.getTipoSeleccionado());
        model.addAttribute("tipoTramites", dto.getTipoTramites());
        model.addAttribute("tipoTramiteId", dto.getTipoId());
        model.addAttribute("idSolicitanteBuscado", dto.getIdSolicitante());
        model.addAttribute("existeSolicitante", dto.isExisteSolicitante());
        model.addAttribute("numeroTramiteGenerado", dto.getNumeroTramite());
    }
}