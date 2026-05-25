package com.example.demo.BandejaTrabajo;

import com.example.demo.Tramite.Tramite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/bandejaTrabajo")
public class BandejaTrabajoController {

    private final BandejaTrabajoService service;

    public BandejaTrabajoController(BandejaTrabajoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public String listarTramitesAEvaluar(
            @RequestParam(required = false) String dni,
            Model model) {

        model.addAttribute(
                "tramites",
                service.listarTramitesAEvaluar(dni)
        );

        return "bandejaTrabajo/bandejaTrabajo";
    }

    @GetMapping("/evaluar/{id}")
    public String evaluarTramite(@PathVariable String id,
                                 Model model,
                                 RedirectAttributes ra) {

        Tramite tramite = service.buscarPorId(id);

        if (tramite == null) {
            ra.addFlashAttribute(
                    "mensaje",
                    "Trámite no encontrado"
            );

            return "redirect:/bandejaTrabajo/listar";
        }

        model.addAttribute("tramite", tramite);

        return "bandejaTrabajo/evaluacion";
    }

    @PostMapping("/evaluar/{id}")
    public String procesarEvaluacion(
            @PathVariable String id,

            @RequestParam(required = false,
                    defaultValue = "false")
            boolean datosCompletos,

            @RequestParam(required = false,
                    defaultValue = "false")
            boolean datosConsistentes,

            @RequestParam(required = false,
                    defaultValue = "false")
            boolean cumpleRequisitos,

            @RequestParam(required = false,
                    defaultValue = "false")
            boolean sustentoValido,

            @RequestParam String accion,

            @RequestParam(required = false)
            String comentario,

            Model model,

            RedirectAttributes ra) {

        Tramite tramite = service.buscarPorId(id);

        if (tramite == null) {

            ra.addFlashAttribute(
                    "mensaje",
                    "Trámite no encontrado"
            );

            return "redirect:/bandejaTrabajo/listar";
        }

        String error = service.procesarEvaluacion(
                id,
                datosCompletos,
                datosConsistentes,
                cumpleRequisitos,
                sustentoValido,
                accion,
                comentario
        );

        if (error != null) {

            model.addAttribute("mensaje", error);
            model.addAttribute("tramite", tramite);

            model.addAttribute(
                    "datosCompletos",
                    datosCompletos
            );

            model.addAttribute(
                    "datosConsistentes",
                    datosConsistentes
            );

            model.addAttribute(
                    "cumpleRequisitos",
                    cumpleRequisitos
            );

            model.addAttribute(
                    "sustentoValido",
                    sustentoValido
            );

            model.addAttribute(
                    "comentario",
                    comentario
            );

            return "bandejaTrabajo/evaluacion";
        }

        ra.addFlashAttribute(
                "mensaje",
                "Evaluación registrada"
        );

        return "redirect:/bandejaTrabajo/listar";
    }
}