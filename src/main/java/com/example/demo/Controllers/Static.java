package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Static {
    @GetMapping("/")
    public String inicio(Model model) {
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
