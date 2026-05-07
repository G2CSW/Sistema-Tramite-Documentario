package com.example.demo.Documento;

import com.example.demo.Datos.DatosMemoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/documento")
public class DocumentoController {

    private final List<Documento> documentos = DatosMemoria.DOCUMENTOS;

    // LISTAR
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("documentos", documentos);
        return "documento/documento";
    }

    // IR A REGISTRAR
    @GetMapping("/registrar")
    public String irRegistrar(Model model) {
        model.addAttribute("documento", new Documento());
        return "documento/registrarDocumento";
    }

    // REGISTRAR
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Documento documento,
                            Model model) {

        if (!validarDocumento(documento)) {
            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("documento", documento);
            return "documento/registrarDocumento";
        }

        documento.setIdDocumento((long) (documentos.size() + 1));
        documentos.add(documento);

        return "redirect:/documento/listar";
    }

    // EDITAR FORM
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {

        for (Documento d : documentos) {
            if (d.getIdDocumento().equals(id)) {
                model.addAttribute("documento", d);
                return "documento/editarDocumento";
            }
        }

        return "redirect:/documento/listar";
    }

    // GUARDAR EDICIÓN
    @PostMapping("/editar/{id}")
    public String editar(@PathVariable Long id,
                         @ModelAttribute Documento form,
                         Model model) {

        if (!validarDocumento(form)) {

            form.setIdDocumento(id);

            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("documento", form);

            return "documento/editarDocumento";
        }

        for (Documento d : documentos) {
            if (d.getIdDocumento().equals(id)) {
                d.setNombreDocumento(form.getNombreDocumento());
                break;
            }
        }

        return "redirect:/documento/listar";
    }

    @PostMapping("/cambiar-estado/{id}")
    public String cambiarEstado(@PathVariable Long id) {

        for (Documento d : documentos) {
            if (d.getIdDocumento().equals(id)) {
                d.setActivo(!d.isActivo());
                break;
            }
        }

        return "redirect:/documento/listar";
    }

    private boolean validarDocumento(Documento d) {
        return !(d.getNombreDocumento() == null || d.getNombreDocumento().isBlank());
    }
}