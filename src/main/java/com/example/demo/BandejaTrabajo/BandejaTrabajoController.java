package com.example.demo.BandejaTrabajo;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.Tramite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/bandejaTrabajo")
public class BandejaTrabajoController {

    private final List<Tramite> tramites = DatosMemoria.TRAMITES;

    @GetMapping("/listar")
    public String listarTramitesAEvaluar(Model model) {
        List<Tramite> tramitesEvaluar = new ArrayList<>();

        for (Tramite t : tramites) {
            if (t.getEstadoActual() == EstadoTramite.EN_EVALUACION) {
                tramitesEvaluar.add(t);
            }
        }

        model.addAttribute("tramites", tramitesEvaluar);
        return "bandejaTrabajo/bandejaTrabajo";
    }

    @GetMapping("/evaluar/{id}")
    public String evaluarTramite(@PathVariable String id,
                                 Model model,
                                 RedirectAttributes ra) {

        Tramite t = buscarPorId(id);

        if (t == null) {
            ra.addFlashAttribute("mensaje", "Trámite no encontrado");
            return "redirect:/bandejaTrabajo/listar";
        }

        model.addAttribute("tramite", t);
        return "bandejaTrabajo/evaluacion";
    }

    @PostMapping("/evaluar/{id}")
    public String procesarEvaluacion(@PathVariable String id,
                                     @RequestParam(required = false) boolean datosCompletos,
                                     @RequestParam(required = false) boolean datosConsistentes,
                                     @RequestParam(required = false) boolean cumpleRequisitos,
                                     @RequestParam(required = false) boolean sustentoValido,
                                     @RequestParam String accion,
                                     RedirectAttributes ra) {

        Tramite t = buscarPorId(id);

        if (t == null) {
            ra.addFlashAttribute("mensaje", "Trámite no encontrado");
            return "redirect:/bandejaTrabajo/listar";
        }

        if ("aprobar".equals(accion)) {
            t.setEstadoActual(EstadoTramite.APROBADO);
        } else {
            t.setEstadoActual(EstadoTramite.RECHAZADO);
        }

        ra.addFlashAttribute("mensaje", "Evaluación registrada");
        return "redirect:/bandejaTrabajo/listar";
    }

    private Tramite buscarPorId(String id) {
        for (Tramite t : tramites) {
            if (t.getNroTramite().equals(id)) return t;
        }
        return null;
    }
}
