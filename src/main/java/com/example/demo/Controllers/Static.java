package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class Static {
    @GetMapping("/")
    public String inicio(Model model) {
        LocalDate fechaActual = LocalDate.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String fechaFormateada = fechaActual.format(formatter);

        model.addAttribute("fechaActual", fechaFormateada);

        return "main";
    }

    @GetMapping("/gestion")
    public String gestion(Model model) {
        return "gestion";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        return "contacto";
    }

    @GetMapping("/publicidad")
    public String publicidad(Model model) {
        return "publicidad";
    }

}
