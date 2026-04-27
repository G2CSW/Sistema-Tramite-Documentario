package com.example.demo.TipoTramite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tipoTramite")
public class TipoTramiteController {

    @GetMapping("/listar")
    public String listarTipoTramites(Model model) {
        return "tipoTramite/tipoTramite";
    }
}
