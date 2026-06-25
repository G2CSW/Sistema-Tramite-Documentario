package com.example.demo.Usuario;

import com.example.demo.Area.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AreaService areaService;

    public UsuarioController(UsuarioService usuarioService, AreaService areaService) {
        this.usuarioService = usuarioService;
        this.areaService = areaService;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "usuario/usuarios";
    }

    @GetMapping("/registrar")
    public String irRegistrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("areas", areaService.listarAreas());
        return "usuario/registrarUsuario";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuario,
                            @RequestParam(required = false) String idArea,
                            Model model) {

        String idUsuario = usuario.getIdUsuario();

        if (idUsuario == null || idUsuario.isBlank() || !idUsuario.matches("\\d{8,9}")) {
            model.addAttribute("error", "El DNI debe contener solo números y tener entre 8 y 9 dígitos");
            model.addAttribute("usuario", usuario);
            model.addAttribute("areas", areaService.listarAreas());
            return "usuario/registrarUsuario";
        }

        if (usuarioService.existeUsuario(idUsuario)) {
            model.addAttribute("error", "El DNI ya está registrado en el sistema");
            model.addAttribute("usuario", usuario);
            model.addAttribute("areas", areaService.listarAreas());
            return "usuario/registrarUsuario";
        }

        boolean registrado = usuarioService.registrarUsuario(usuario, idArea);

        if (!registrado) {
            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("usuario", usuario);
            model.addAttribute("areas", areaService.listarAreas());
            return "usuario/registrarUsuario";
        }

        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{idUsuario}")
    public String editarForm(@PathVariable String idUsuario, Model model) {
        Usuario usuario = usuarioService.obtenerUsuario(idUsuario);

        if (usuario == null) {
            return "redirect:/usuario/listar";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("areas", areaService.listarAreas());
        return "usuario/editarUsuario";
    }

    @PostMapping("/editar/{idUsuario}")
    public String editar(@PathVariable String idUsuario,
                         @ModelAttribute Usuario form,
                         @RequestParam(required = false) String idArea,
                         Model model) {

        String nuevoId = form.getIdUsuario();

        if (nuevoId == null || nuevoId.isBlank() || !nuevoId.matches("\\d{8,9}")) {
            model.addAttribute("error", "El DNI debe contener solo números y tener entre 8 y 9 dígitos");
            model.addAttribute("usuario", form);
            model.addAttribute("areas", areaService.listarAreas());
            return "usuario/editarUsuario";
        }

        boolean editado = usuarioService.editarUsuario(idUsuario, form, idArea);

        if (!editado) {
            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("usuario", form);
            model.addAttribute("areas", areaService.listarAreas());
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
