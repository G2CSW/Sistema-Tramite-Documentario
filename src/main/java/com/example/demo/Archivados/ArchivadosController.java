package com.example.demo.Archivados;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.Tramite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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

        return "/archivados";
    }
}