package com.example.demo.TipoTramite;

import com.example.demo.Datos.DatosMemoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipoTramite")
public class TipoTramiteController {

    private final List<TipoTramite> tipos = DatosMemoria.TIPOS_TRAMITE;

    // LISTAR
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("tipos", tipos);
        return "tipoTramite/tipoTramite";
    }

    // IR A REGISTRAR
    @GetMapping("/registrar")
    public String irRegistrar(Model model) {
        model.addAttribute("tipo", new TipoTramite());
        return "tipoTramite/registrarTipoTramite";
    }

    // REGISTRAR
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute TipoTramite tipo,
                            Model model) {

        if (!validarTipoTramite(tipo)) {
            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("tipo", tipo);
            return "tipoTramite/registrarTipoTramite";
        }

        tipo.setIdTipoTramite("TT" + (tipos.size() + 1));
        tipo.setFechaCreacion(java.time.LocalDate.now());

        tipos.add(tipo);

        return "redirect:/tipoTramite/listar";
    }

    // EDITAR FORM
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable String id, Model model) {

        for (TipoTramite t : tipos) {
            if (t.getIdTipoTramite().equals(id)) {
                model.addAttribute("tipo", t);
                return "tipoTramite/editarTipoTramite";
            }
        }

        return "redirect:/tipoTramite/listar";
    }

    // GUARDAR EDICIÓN
    @PostMapping("/editar/{id}")
    public String editar(@PathVariable String id,
                         @ModelAttribute TipoTramite form,
                         Model model) {

        if (!validarTipoTramite(form)) {
            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("tipo", form);
            return "tipoTramite/editarTipoTramite";
        }

        for (TipoTramite t : tipos) {
            if (t.getIdTipoTramite().equals(id)) {
                t.setNombre(form.getNombre());
                t.setDocumentacionMinima(form.getDocumentacionMinima());
                break;
            }
        }

        return "redirect:/tipoTramite/listar";
    }


    @PostMapping("/toggle/{id}")
    public String toggle(@PathVariable String id) {

        for (TipoTramite t : tipos) {
            if (t.getIdTipoTramite().equals(id)) {

                if (t.getNombre().startsWith("[INACTIVO]")) {
                    t.setNombre(t.getNombre().replace("[INACTIVO] ", ""));
                } else {
                    t.setNombre("[INACTIVO] " + t.getNombre());
                }

            }
        }

        return "redirect:/tipoTramite/listar";
    }

    @PostMapping("/cambiar-estado/{id}")
    public String cambiarEstado(@PathVariable String id,
                                @RequestParam boolean activo) {

        for (TipoTramite t : DatosMemoria.TIPOS_TRAMITE) {
            if (t.getIdTipoTramite().equals(id)) {
                t.setActivo(activo);
                break;
            }
        }

        return "redirect:/tipoTramite/listar";
    }

    private boolean validarTipoTramite(TipoTramite t) {
        return !(t.getNombre() == null || t.getNombre().isBlank() ||
                t.getDocumentacionMinima() == null || t.getDocumentacionMinima().isBlank());
    }
}