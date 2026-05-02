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

    private final List<Tramite> tramites = DatosMemoria.TRAMITES;

    @GetMapping("/listar")
    public String listarTramitesArchivados(@RequestParam(required = false) String idSolicitante,
                                           Model model) {

        List<Tramite> tramitesArchivados = new ArrayList<>();

        for (Tramite t : tramites) {
            boolean archivadoOCancelado =
                    t.getEstadoActual() == EstadoTramite.ARCHIVADO ||
                            t.getEstadoActual() == EstadoTramite.CANCELADO;

            boolean coincide = (idSolicitante == null || idSolicitante.isBlank()) ||
                    (t.getSolicitante() != null &&
                            t.getSolicitante().getIdSolicitante().equals(idSolicitante));

            if (archivadoOCancelado && coincide) {
                tramitesArchivados.add(t);
            }
        }

        model.addAttribute("tramites", tramitesArchivados);
        model.addAttribute("idSolicitanteBuscado", idSolicitante);

        return "/archivados";
    }
}