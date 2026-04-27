package com.example.demo.BandejaTrabajo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/bandejaTrabajo")
public class BandejaTrabajoController {
    @GetMapping("/listar")
    public String listarTramitesAEvaluar(Model model) {
        return "bandejaTrabajo/bandejaTrabajo";
    }
}
