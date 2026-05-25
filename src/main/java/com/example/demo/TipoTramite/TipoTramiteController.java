package com.example.demo.TipoTramite;

import com.example.demo.Documento.Documento;
import com.example.demo.Documento.DocumentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tipoTramite")
public class TipoTramiteController {

    private final TipoTramiteService service;
    private final DocumentoService documentoService;

    public TipoTramiteController(TipoTramiteService service, DocumentoService documentoService) {
        this.service = service;
        this.documentoService = documentoService;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("tipos", service.listar());
        return "tipoTramite/tipoTramite";
    }

    @GetMapping("/registrar")
    public String irRegistrar(Model model) {
        TipoTramite tipo = new TipoTramite();
        tipo.setDocumentacionMinima(new ArrayList<>());
        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", documentoService.obtenerDocumentosActivos());
        return "tipoTramite/registrarTipoTramite";
    }

    @PostMapping("/registrar/agregar")
    public String agregarDocumentoRegistro(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Long documentoId,
            @RequestParam(value = "documentacionMinimaIds", required = false)
            List<Long> documentacionMinimaIds,
            Model model) {

        TipoTramite tipo = construirVista(nombre, documentacionMinimaIds);
        if (documentoId != null) {
            List<Long> ids = extraerIds(tipo.getDocumentacionMinima());
            if (!ids.contains(documentoId)) {
                ids.add(documentoId);
                tipo.setDocumentacionMinima(documentoService.obtenerDocumentosPorIds(ids));
            }
        }
        
        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", documentoService.obtenerDocumentosActivos());

        return "tipoTramite/registrarTipoTramite";
    }

    @PostMapping("/registrar/quitar")
    public String quitarDocumentoRegistro(
            @RequestParam(required = false) String nombre,
            @RequestParam Long quitarId,
            @RequestParam(value = "documentacionMinimaIds", required = false)
            List<Long> documentacionMinimaIds,
            Model model) {

        TipoTramite tipo = construirVista(nombre, documentacionMinimaIds);
        List<Long> ids = extraerIds(tipo.getDocumentacionMinima());
        ids.remove(quitarId);
        tipo.setDocumentacionMinima(documentoService.obtenerDocumentosPorIds(ids));

        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", documentoService.obtenerDocumentosActivos());

        return "tipoTramite/registrarTipoTramite";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestParam String nombre,
                            @RequestParam(value = "documentacionMinimaIds", required = false)
                            List<Long> documentacionMinimaIds,
                            Model model) {

        if (!service.validarTipoTramite(nombre, documentacionMinimaIds)) {
            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("tipo", construirVista(nombre, documentacionMinimaIds));
            model.addAttribute("documentos", documentoService.obtenerDocumentosActivos());
            return "tipoTramite/registrarTipoTramite";
        }

        service.registrar(nombre, documentacionMinimaIds);
        return "redirect:/tipoTramite/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        TipoTramite tipo = service.buscarTipo(id);

        if (tipo == null) {
            return "redirect:/tipoTramite/listar";
        }

        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", documentoService.obtenerDocumentosActivos());
        return "tipoTramite/editarTipoTramite";
    }

    @PostMapping("/editar/{id}/agregar")
    public String agregarDocumentoEdicion(
            @PathVariable Long id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Long documentoId,
            @RequestParam(value = "documentacionMinimaIds", required = false)
            List<Long> documentacionMinimaIds,
            Model model) {

        TipoTramite tipo = construirVistaParaEdicion(id, nombre, documentacionMinimaIds);
        if (tipo == null) return "redirect:/tipoTramite/listar";

        if (documentoId != null) {
            List<Long> ids = extraerIds(tipo.getDocumentacionMinima());
            if (!ids.contains(documentoId)) {
                ids.add(documentoId);
                tipo.setDocumentacionMinima(documentoService.obtenerDocumentosPorIds(ids));
            }
        }

        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", documentoService.obtenerDocumentosActivos());

        return "tipoTramite/editarTipoTramite";
    }

    @PostMapping("/editar/{id}/quitar")
    public String quitarDocumentoEdicion(
            @PathVariable Long id,
            @RequestParam(required = false) String nombre,
            @RequestParam Long quitarId,
            @RequestParam(value = "documentacionMinimaIds", required = false)
            List<Long> documentacionMinimaIds,
            Model model) {

        TipoTramite tipo = construirVistaParaEdicion(id, nombre, documentacionMinimaIds);
        if (tipo == null) return "redirect:/tipoTramite/listar";

        List<Long> ids = extraerIds(tipo.getDocumentacionMinima());
        ids.remove(quitarId);
        tipo.setDocumentacionMinima(documentoService.obtenerDocumentosPorIds(ids));

        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", documentoService.obtenerDocumentosActivos());

        return "tipoTramite/editarTipoTramite";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable Long id,
                         @RequestParam String nombre,
                         @RequestParam(value = "documentacionMinimaIds", required = false)
                         List<Long> documentacionMinimaIds,
                         Model model) {

        if (!service.validarTipoTramite(nombre, documentacionMinimaIds)) {
            model.addAttribute("error", "Complete todos los campos");
            TipoTramite tipo = construirVistaParaEdicion(id, nombre, documentacionMinimaIds);
            model.addAttribute("tipo", tipo);
            model.addAttribute("documentos", documentoService.obtenerDocumentosActivos());
            return "tipoTramite/editarTipoTramite";
        }

        service.editar(id, nombre, documentacionMinimaIds);
        return "redirect:/tipoTramite/listar";
    }

    private TipoTramite construirVista(String nombre, List<Long> ids) {
        TipoTramite tipo = new TipoTramite();
        tipo.setNombre(nombre);
        tipo.setDocumentacionMinima(documentoService.obtenerDocumentosPorIds(ids));
        return tipo;
    }

    private TipoTramite construirVistaParaEdicion(Long id, String nombre, List<Long> ids) {
        TipoTramite tipo = service.buscarTipo(id);
        if (tipo == null) return null;
        
        TipoTramite vista = new TipoTramite();
        vista.setIdTipoTramite(tipo.getIdTipoTramite());
        vista.setNombre(nombre);
        vista.setFechaCreacion(tipo.getFechaCreacion());
        vista.setActivo(tipo.isActivo());
        vista.setDocumentacionMinima(documentoService.obtenerDocumentosPorIds(ids));
        return vista;
    }
    
    private List<Long> extraerIds(List<Documento> docs) {
        List<Long> ids = new ArrayList<>();
        if (docs != null) {
            for (Documento d : docs) {
                ids.add(d.getIdDocumento());
            }
        }
        return ids;
    }

    @PostMapping("/cambiar-estado/{id}")
    public String cambiarEstado(@PathVariable Long id) {
        service.cambiarEstado(id);
        return "redirect:/tipoTramite/listar";
    }
}