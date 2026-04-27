package com.example.demo.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        return "usuario/usuarios";
    }
}