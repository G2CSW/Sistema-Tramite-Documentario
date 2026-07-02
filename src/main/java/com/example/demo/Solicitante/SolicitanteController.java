package com.example.demo.Solicitante;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/solicitante")
public class SolicitanteController {

    private final SolicitanteService solicitanteService;

    public SolicitanteController(SolicitanteService solicitanteService) {
        this.solicitanteService = solicitanteService;
    }

    @GetMapping("/listar")
    public String listarSolicitantes(
            @RequestParam(value = "dni", required = false) String dni,
            Model model) {

        List<Solicitante> solicitantes;
        if (dni != null && !dni.isBlank()) {
            Solicitante s = solicitanteService.buscarSolicitante(dni);
            if (s != null) {
                solicitantes = List.of(s);
            } else {
                solicitantes = List.of();
            }
            model.addAttribute("dniBuscado", dni);
        } else {
            solicitantes = solicitanteService.listarTodos();
        }

        model.addAttribute("solicitantes", solicitantes);
        return "solicitante/listar";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        if (!model.containsAttribute("solicitante")) {
            model.addAttribute("solicitante", new Solicitante());
        }
        return "solicitante/registrar";
    }

    @PostMapping("/registrar")
    public String registrarSolicitante(Solicitante solicitante, RedirectAttributes redirectAttributes) {
        String error = solicitanteService.validarSolicitante(solicitante);

        if (error != null) {
            redirectAttributes.addFlashAttribute("error", error);
            redirectAttributes.addFlashAttribute("solicitante", solicitante);
            return "redirect:/solicitante/registrar";
        }

        if (solicitanteService.existeSolicitante(solicitante.getIdSolicitante())) {
            redirectAttributes.addFlashAttribute("error", "El solicitante con DNI " + solicitante.getIdSolicitante() + " ya existe.");
            redirectAttributes.addFlashAttribute("solicitante", solicitante);
            return "redirect:/solicitante/registrar";
        }

        solicitanteService.guardarOActualizarSolicitante(solicitante);
        redirectAttributes.addFlashAttribute("mensaje", "Solicitante registrado exitosamente.");
        return "redirect:/solicitante/listar";
    }

    @GetMapping("/editar")
    public String mostrarFormularioEdicion(@RequestParam("id") String id, Model model, RedirectAttributes redirectAttributes) {
        Solicitante s = solicitanteService.buscarSolicitante(id);
        if (s == null) {
            redirectAttributes.addFlashAttribute("error", "Solicitante no encontrado");
            return "redirect:/solicitante/listar";
        }

        if (!model.containsAttribute("solicitante")) {
            model.addAttribute("solicitante", s);
        }
        return "solicitante/editar";
    }

    @PostMapping("/editar")
    public String editarSolicitante(Solicitante solicitante, RedirectAttributes redirectAttributes) {
        String error = solicitanteService.validarSolicitante(solicitante);

        if (error != null) {
            redirectAttributes.addFlashAttribute("error", error);
            redirectAttributes.addFlashAttribute("solicitante", solicitante);
            return "redirect:/solicitante/editar?id=" + solicitante.getIdSolicitante();
        }

        Solicitante existente = solicitanteService.buscarSolicitante(solicitante.getIdSolicitante());
        if (existente == null) {
            redirectAttributes.addFlashAttribute("error", "El solicitante no existe.");
            return "redirect:/solicitante/listar";
        }

        solicitanteService.guardarOActualizarSolicitante(solicitante);
        redirectAttributes.addFlashAttribute("mensaje", "Solicitante actualizado exitosamente.");
        return "redirect:/solicitante/listar";
    }
}
