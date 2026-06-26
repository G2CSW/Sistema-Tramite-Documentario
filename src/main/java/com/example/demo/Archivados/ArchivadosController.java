package com.example.demo.Archivados;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/archivados")
public class ArchivadosController {
    private final ArchivadosService archivadosService;

    public ArchivadosController(ArchivadosService archivadosService) {
        this.archivadosService = archivadosService;
    }

    @GetMapping("/listar")
    public String listarTramitesArchivados(@RequestParam(required = false) String idSolicitante,
                                           Model model) {
        model.addAttribute("tramites", archivadosService.listarArchivados(idSolicitante));
        model.addAttribute("idSolicitanteBuscado", idSolicitante);

        return "archivados";
    }
}
