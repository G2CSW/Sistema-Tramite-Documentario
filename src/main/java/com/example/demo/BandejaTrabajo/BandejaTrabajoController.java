package com.example.demo.BandejaTrabajo;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.EvaluacionTramite;
import com.example.demo.Tramite.Tramite;
import com.example.demo.Tramite.Trazabilidad;
import com.example.demo.Usuario.Usuario;
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
    private final List<EvaluacionTramite> evaluaciones = DatosMemoria.EVALUACIONES;

    @GetMapping("/listar")
    public String listarTramitesAEvaluar(
            @RequestParam(required = false) String dni,
            Model model) {

        List<Tramite> tramitesEvaluar = new ArrayList<>();

        for (Tramite t : tramites) {
            // Primero: solo en evaluación
            if (t.getEstadoActual() == EstadoTramite.EN_EVALUACION) {
                // Segundo: si se buscó DNI, filtrar
                if (dni != null && !dni.isEmpty()) {
                    // Asumiendo que t.getSolicitante() existe y tiene getDni()
                    if (t.getSolicitante() != null && dni.equals(t.getSolicitante().getIdSolicitante())) {
                        tramitesEvaluar.add(t);
                    }
                } else {
                    tramitesEvaluar.add(t);
                }
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
                                     @RequestParam(required = false, defaultValue = "false") boolean datosCompletos,
                                     @RequestParam(required = false, defaultValue = "false") boolean datosConsistentes,
                                     @RequestParam(required = false, defaultValue = "false") boolean cumpleRequisitos,
                                     @RequestParam(required = false, defaultValue = "false") boolean sustentoValido,
                                     @RequestParam String accion,
                                     @RequestParam(required = false) String comentario,
                                     Model model,
                                     RedirectAttributes ra) {

        Tramite t = buscarPorId(id);

        if (t == null) {
            ra.addFlashAttribute("mensaje", "Trámite no encontrado");
            return "redirect:/bandejaTrabajo/listar";
        }

        boolean todosCumplen =
                datosCompletos &&
                        datosConsistentes &&
                        cumpleRequisitos &&
                        sustentoValido;

        // ERROR APROBAR
        if ("aprobar".equals(accion) && !todosCumplen) {

            model.addAttribute("mensaje",
                    "No se puede aprobar un trámite que no cumple con los checks.");

            model.addAttribute("tramite", t);

            model.addAttribute("datosCompletos", datosCompletos);
            model.addAttribute("datosConsistentes", datosConsistentes);
            model.addAttribute("cumpleRequisitos", cumpleRequisitos);
            model.addAttribute("sustentoValido", sustentoValido);
            model.addAttribute("comentario", comentario);

            return "bandejaTrabajo/evaluacion";
        }

        // ERROR RECHAZAR
        if ("rechazar".equals(accion) && todosCumplen) {

            model.addAttribute("mensaje",
                    "No se puede rechazar un trámite que tiene todo check.");

            model.addAttribute("tramite", t);

            model.addAttribute("datosCompletos", datosCompletos);
            model.addAttribute("datosConsistentes", datosConsistentes);
            model.addAttribute("cumpleRequisitos", cumpleRequisitos);
            model.addAttribute("sustentoValido", sustentoValido);
            model.addAttribute("comentario", comentario);

            return "bandejaTrabajo/evaluacion";
        }

        // Guardar evaluación
        EvaluacionTramite evaluacion = new EvaluacionTramite(
                t,
                datosCompletos,
                datosConsistentes,
                cumpleRequisitos,
                sustentoValido
        );

        guardarOActualizarEvaluacion(evaluacion);

        Trazabilidad tr = new Trazabilidad();

        tr.setIdTrazabilidad("TZ" + (DatosMemoria.TRAZABILIDADES.size() + 1));
        tr.setTramite(t);
        tr.setUsuario(DatosMemoria.USUARIOS.get(1));
        tr.setFechaHora(java.time.LocalDateTime.now());

        if ("aprobar".equals(accion)) {

            t.setEstadoActual(EstadoTramite.APROBADO);

            tr.setEstadoCambio(EstadoTramite.APROBADO);

            tr.setComentario(
                    "Trámite aprobado" + agregarComentarioExtra(comentario)
            );

        } else {

            t.setEstadoActual(EstadoTramite.RECHAZADO);

            tr.setEstadoCambio(EstadoTramite.RECHAZADO);

            tr.setComentario(
                    "Trámite rechazado por no cumplir con los siguientes criterios: "
                            + listarChecksNoCumplidos(
                            datosCompletos,
                            datosConsistentes,
                            cumpleRequisitos,
                            sustentoValido
                    )
                            + agregarComentarioExtra(comentario)
            );
        }

        DatosMemoria.TRAZABILIDADES.add(tr);

        ra.addFlashAttribute("mensaje", "Evaluación registrada");

        return "redirect:/bandejaTrabajo/listar";
    }

    private Tramite buscarPorId(String id) {
        for (Tramite t : tramites) {
            if (t.getNroTramite().equals(id)) return t;
        }
        return null;
    }

    private void guardarOActualizarEvaluacion(EvaluacionTramite nueva) {
        for (EvaluacionTramite e : evaluaciones) {
            if (e.getTramite().getNroTramite().equals(nueva.getTramite().getNroTramite())) {
                e.setDatosCompletos(nueva.getDatosCompletos());
                e.setDatosConsistentes(nueva.getDatosConsistentes());
                e.setCumpleRequisitos(nueva.getCumpleRequisitos());
                e.setSustentoValido(nueva.getSustentoValido());
                return;
            }
        }
        evaluaciones.add(nueva);
    }

    private String listarChecksNoCumplidos(boolean datosCompletos,
                                           boolean datosConsistentes,
                                           boolean cumpleRequisitos,
                                           boolean sustentoValido) {
        List<String> faltantes = new ArrayList<>();

        if (!datosCompletos) faltantes.add("Datos Completos");
        if (!datosConsistentes) faltantes.add("Datos Consistentes");
        if (!cumpleRequisitos) faltantes.add("Cumple requisitos del trámite");
        if (!sustentoValido) faltantes.add("Sustento válido");

        return String.join(", ", faltantes);
    }

    private String agregarComentarioExtra(String comentario) {
        if (comentario == null || comentario.isBlank()) {
            return "";
        }
        return ". " + comentario.trim();
    }
}
