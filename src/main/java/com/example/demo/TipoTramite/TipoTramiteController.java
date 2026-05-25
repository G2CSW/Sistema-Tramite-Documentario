package com.example.demo.TipoTramite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipoTramite")
public class TipoTramiteController {

    private final TipoTramiteService service;

    public TipoTramiteController(TipoTramiteService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("tipos", service.listar());
        return "tipoTramite/tipoTramite";
    }

    @GetMapping("/registrar")
    public String irRegistrar(Model model) {
        model.addAttribute("tipo", service.prepararRegistro());
        model.addAttribute("documentos", service.obtenerDocumentosActivos());
        return "tipoTramite/registrarTipoTramite";
    }

    @PostMapping("/registrar/agregar")
    public String agregarDocumentoRegistro(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Long documentoId,
            @RequestParam(value = "documentacionMinimaIds", required = false)
            List<Long> documentacionMinimaIds,
            Model model) {

        model.addAttribute(
                "tipo",
                service.agregarDocumento(nombre, documentoId, documentacionMinimaIds)
        );
        model.addAttribute("documentos", service.obtenerDocumentosActivos());

        return "tipoTramite/registrarTipoTramite";
    }

    @PostMapping("/registrar/quitar")
    public String quitarDocumentoRegistro(
            @RequestParam(required = false) String nombre,
            @RequestParam Long quitarId,
            @RequestParam(value = "documentacionMinimaIds", required = false)
            List<Long> documentacionMinimaIds,
            Model model) {

        model.addAttribute(
                "tipo",
                service.quitarDocumento(nombre, quitarId, documentacionMinimaIds)
        );
        model.addAttribute("documentos", service.obtenerDocumentosActivos());

        return "tipoTramite/registrarTipoTramite";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestParam String nombre,
                            @RequestParam(value = "documentacionMinimaIds", required = false)
                            List<Long> documentacionMinimaIds,
                            Model model) {

        if (!service.validarTipoTramite(nombre, documentacionMinimaIds)) {
            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("tipo", service.prepararRegistro());
            model.addAttribute("documentos", service.obtenerDocumentosActivos());
            return "tipoTramite/registrarTipoTramite";
        }

        service.registrar(nombre, documentacionMinimaIds);
        return "redirect:/tipoTramite/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable String id, Model model) {
        TipoTramite tipo = service.buscarTipo(id);

        if (tipo == null) {
            return "redirect:/tipoTramite/listar";
        }

        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", service.obtenerDocumentosActivos());
        return "tipoTramite/editarTipoTramite";
    }

    @PostMapping("/editar/{id}/agregar")
    public String agregarDocumentoEdicion(
            @PathVariable String id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Long documentoId,
            @RequestParam(value = "documentacionMinimaIds", required = false)
            List<Long> documentacionMinimaIds,
            Model model) {

        model.addAttribute(
                "tipo",
                service.agregarDocumento(id, nombre, documentoId, documentacionMinimaIds)
        );
        model.addAttribute("documentos", service.obtenerDocumentosActivos());

        return "tipoTramite/editarTipoTramite";
    }

    @PostMapping("/editar/{id}/quitar")
    public String quitarDocumentoEdicion(
            @PathVariable String id,
            @RequestParam(required = false) String nombre,
            @RequestParam Long quitarId,
            @RequestParam(value = "documentacionMinimaIds", required = false)
            List<Long> documentacionMinimaIds,
            Model model) {

        model.addAttribute(
                "tipo",
                service.quitarDocumento(id, nombre, quitarId, documentacionMinimaIds)
        );
        model.addAttribute("documentos", service.obtenerDocumentosActivos());

        return "tipoTramite/editarTipoTramite";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable String id,
                         @RequestParam String nombre,
                         @RequestParam(value = "documentacionMinimaIds", required = false)
                         List<Long> documentacionMinimaIds,
                         Model model) {

        if (!service.validarTipoTramite(nombre, documentacionMinimaIds)) {
            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("tipo", service.prepararEdicion(id, nombre, documentacionMinimaIds));
            model.addAttribute("documentos", service.obtenerDocumentosActivos());
            return "tipoTramite/editarTipoTramite";
        }

        service.editar(id, nombre, documentacionMinimaIds);
        return "redirect:/tipoTramite/listar";
    }

    @PostMapping("/cambiar-estado/{id}")
    public String cambiarEstado(@PathVariable String id) {
        service.cambiarEstado(id);
        return "redirect:/tipoTramite/listar";
    }
}