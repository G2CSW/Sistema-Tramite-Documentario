package com.example.demo.Usuario;

import com.example.demo.Area.Area;
import com.example.demo.Datos.DatosMemoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final List<Usuario> usuarios = DatosMemoria.USUARIOS;
    private final List<Area> areas = DatosMemoria.AREAS;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarios);
        return "usuario/usuarios";
    }

    @GetMapping("/registrar")
    public String irRegistrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("areas", areas);
        return "usuario/registrarUsuario";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuario,
                            @RequestParam(required = false) String idArea,
                            Model model) {

        if (!validarUsuario(usuario) || idArea == null || idArea.isBlank()) {
            usuario.setArea(buscarArea(idArea));

            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("usuario", usuario);
            model.addAttribute("areas", areas);
            return "usuario/registrarUsuario";
        }

        usuario.setArea(buscarArea(idArea));
        usuario.setEstado(true);

        usuarios.add(usuario);

        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{idUsuario}")
    public String editarForm(@PathVariable String idUsuario, Model model) {

        for (Usuario u : usuarios) {
            if (u.getIdUsuario().equals(idUsuario)) {
                model.addAttribute("usuario", u);
                model.addAttribute("areas", areas);
                return "usuario/editarUsuario";
            }
        }

        return "redirect:/usuario/listar";
    }

    @PostMapping("/editar/{idUsuario}")
    public String editar(@PathVariable String idUsuario,
                         @ModelAttribute Usuario form,
                         @RequestParam(required = false) String idArea,
                         Model model) {

        if (!validarUsuario(form) || idArea == null || idArea.isBlank()) {

            form.setArea(buscarArea(idArea));

            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("usuario", form);
            model.addAttribute("areas", areas);
            return "usuario/editarUsuario";
        }

        for (Usuario u : usuarios) {
            if (u.getIdUsuario().equals(idUsuario)) {
                u.setNombre(form.getNombre());
                u.setCorreoElectronico(form.getCorreoElectronico());
                u.setPassword(form.getPassword());
                u.setArea(buscarArea(idArea));
                break;
            }
        }

        return "redirect:/usuario/listar";
    }

    @PostMapping("/toggle/{idUsuario}")
    public String toggle(@PathVariable String idUsuario) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario().equals(idUsuario)) {
                u.setEstado(!u.getEstado());
                break;
            }
        }
        return "redirect:/usuario/listar";
    }

    private boolean validarUsuario(Usuario u) {
        return !(u.getIdUsuario() == null || u.getIdUsuario().isBlank() ||
                u.getNombre() == null || u.getNombre().isBlank() ||
                u.getCorreoElectronico() == null || u.getCorreoElectronico().isBlank() ||
                u.getPassword() == null || u.getPassword().isBlank());
    }

    private Area buscarArea(String idArea) {
        for (Area a : areas) {
            if (a.getIdArea().equals(idArea)) {
                return a;
            }
        }
        return null;
    }
}