package com.example.demo.Tramite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tramite")
public class TramiteController {

    @GetMapping("/listar")
    public String listarTramites(Model model) {
        return "tramite/tramites";
    }
}
