package com.example.demo.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("usuarios",
                usuarioService.listarUsuarios());

        return "usuario/usuarios";
    }

    @GetMapping("/registrar")
    public String irRegistrar(Model model) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("areas",
                usuarioService.listarAreas());

        return "usuario/registrarUsuario";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuario,
                            @RequestParam(required = false) String idArea,
                            Model model) {

        boolean registrado =
                usuarioService.registrarUsuario(usuario, idArea);

        if (!registrado) {

            model.addAttribute("error",
                    "Complete todos los campos");

            model.addAttribute("usuario", usuario);

            model.addAttribute("areas",
                    usuarioService.listarAreas());

            return "usuario/registrarUsuario";
        }

        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{idUsuario}")
    public String editarForm(@PathVariable String idUsuario,
                             Model model) {

        Usuario usuario =
                usuarioService.obtenerUsuario(idUsuario);

        if (usuario == null) {

            return "redirect:/usuario/listar";
        }

        model.addAttribute("usuario", usuario);

        model.addAttribute("areas",
                usuarioService.listarAreas());

        return "usuario/editarUsuario";
    }

    @PostMapping("/editar/{idUsuario}")
    public String editar(@PathVariable String idUsuario,
                         @ModelAttribute Usuario form,
                         @RequestParam(required = false) String idArea,
                         Model model) {

        boolean editado =
                usuarioService.editarUsuario(idUsuario,
                        form,
                        idArea);

        if (!editado) {

            model.addAttribute("error",
                    "Complete todos los campos");

            model.addAttribute("usuario", form);

            model.addAttribute("areas",
                    usuarioService.listarAreas());

            return "usuario/editarUsuario";
        }

        return "redirect:/usuario/listar";
    }

    @PostMapping("/toggle/{idUsuario}")
    public String toggle(@PathVariable String idUsuario) {

        usuarioService.toggleEstado(idUsuario);

        return "redirect:/usuario/listar";
    }
}