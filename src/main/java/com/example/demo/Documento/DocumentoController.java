package com.example.demo.Documento;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/documento")
public class DocumentoController {

    private static final String ERROR_CAMPO = "Complete todos los campos";

    private final DocumentoService service;

    public DocumentoController(DocumentoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("documentos", service.listar());
        return "documento/documento";
    }

    @GetMapping("/registrar")
    public String irRegistrar(Model model) {
        model.addAttribute("documento", new Documento());
        return "documento/registrarDocumento";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Documento documento, Model model) {
        Documento guardado = service.registrar(documento);

        if (guardado == null) {
            model.addAttribute("error", ERROR_CAMPO);
            model.addAttribute("documento", documento);
            return "documento/registrarDocumento";
        }

        return "redirect:/documento/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Documento documento = service.buscarPorId(id);

        if (documento == null) {
            return "redirect:/documento/listar";
        }

        model.addAttribute("documento", documento);
        return "documento/editarDocumento";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable Long id,
                         @ModelAttribute Documento form,
                         Model model) {
        Documento actualizado = service.editar(id, form);

        if (actualizado == null) {
            form.setIdDocumento(id);
            model.addAttribute("error", ERROR_CAMPO);
            model.addAttribute("documento", form);
            return "documento/editarDocumento";
        }

        return "redirect:/documento/listar";
    }

    @PostMapping("/cambiar-estado/{id}")
    public String cambiarEstado(@PathVariable Long id) {
        service.cambiarEstado(id);
        return "redirect:/documento/listar";
    }
}
