package com.example.demo.TipoTramite;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.Documento.Documento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tipoTramite")
public class TipoTramiteController {

    private final List<TipoTramite> tipos = DatosMemoria.TIPOS_TRAMITE;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("tipos", tipos);
        return "tipoTramite/tipoTramite";
    }

    @GetMapping("/registrar")
    public String irRegistrar(Model model) {

        TipoTramite tipo = new TipoTramite();
        tipo.setDocumentacionMinima(new ArrayList<>());

        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", obtenerDocumentosActivos());

        return "tipoTramite/registrarTipoTramite";
    }

    @PostMapping("/registrar/agregar")
    public String agregarDocumentoRegistro(@RequestParam(required = false) String nombre,
                                           @RequestParam(required = false) Long documentoId,
                                           @RequestParam(value = "documentacionMinimaIds", required = false)
                                           List<Long> documentacionMinimaIds,
                                           Model model) {

        List<Long> ids = new ArrayList<>();

        if (documentacionMinimaIds != null) {
            ids.addAll(documentacionMinimaIds);
        }

        if (documentoId != null && !ids.contains(documentoId)) {
            ids.add(documentoId);
        }

        TipoTramite tipo = new TipoTramite();
        tipo.setNombre(nombre);
        tipo.setDocumentacionMinima(obtenerDocumentosPorIds(ids));

        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", obtenerDocumentosActivos());

        return "tipoTramite/registrarTipoTramite";
    }

    @PostMapping("/registrar/quitar")
    public String quitarDocumentoRegistro(@RequestParam(required = false) String nombre,
                                          @RequestParam Long quitarId,
                                          @RequestParam(value = "documentacionMinimaIds", required = false)
                                          List<Long> documentacionMinimaIds,
                                          Model model) {

        List<Long> ids = new ArrayList<>();

        if (documentacionMinimaIds != null) {
            ids.addAll(documentacionMinimaIds);
        }

        ids.remove(quitarId);

        TipoTramite tipo = new TipoTramite();
        tipo.setNombre(nombre);
        tipo.setDocumentacionMinima(obtenerDocumentosPorIds(ids));

        model.addAttribute("tipo", tipo);
        model.addAttribute("documentos", obtenerDocumentosActivos());

        return "tipoTramite/registrarTipoTramite";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestParam String nombre,
                            @RequestParam(value = "documentacionMinimaIds", required = false)
                            List<Long> documentacionMinimaIds,
                            Model model) {

        if (!validarTipoTramite(nombre, documentacionMinimaIds)) {

            TipoTramite tipo = new TipoTramite();
            tipo.setNombre(nombre);
            tipo.setDocumentacionMinima(obtenerDocumentosPorIds(documentacionMinimaIds));

            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("tipo", tipo);
            model.addAttribute("documentos", obtenerDocumentosActivos());

            return "tipoTramite/registrarTipoTramite";
        }

        TipoTramite tipo = new TipoTramite();

        tipo.setIdTipoTramite("TT" + (tipos.size() + 1));
        tipo.setNombre(nombre);
        tipo.setDocumentacionMinima(obtenerDocumentosPorIds(documentacionMinimaIds));
        tipo.setFechaCreacion(LocalDate.now());
        tipo.setActivo(true);

        tipos.add(tipo);

        return "redirect:/tipoTramite/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable String id, Model model) {

        for (TipoTramite t : tipos) {

            if (t.getIdTipoTramite().equals(id)) {

                model.addAttribute("tipo", t);
                model.addAttribute("documentos", obtenerDocumentosActivos());

                return "tipoTramite/editarTipoTramite";
            }
        }

        return "redirect:/tipoTramite/listar";
    }

    @PostMapping("/editar/{id}/agregar")
    public String agregarDocumentoEdicion(@PathVariable String id,
                                          @RequestParam(required = false) String nombre,
                                          @RequestParam(required = false) Long documentoId,
                                          @RequestParam(value = "documentacionMinimaIds", required = false)
                                          List<Long> documentacionMinimaIds,
                                          Model model) {

        List<Long> ids = new ArrayList<>();

        if (documentacionMinimaIds != null) {
            ids.addAll(documentacionMinimaIds);
        }

        if (documentoId != null && !ids.contains(documentoId)) {
            ids.add(documentoId);
        }

        TipoTramite tipo = buscarTipo(id);

        if (tipo == null) {
            return "redirect:/tipoTramite/listar";
        }

        TipoTramite vista = new TipoTramite();

        vista.setIdTipoTramite(tipo.getIdTipoTramite());
        vista.setNombre(nombre);
        vista.setFechaCreacion(tipo.getFechaCreacion());
        vista.setActivo(tipo.isActivo());
        vista.setDocumentacionMinima(obtenerDocumentosPorIds(ids));

        model.addAttribute("tipo", vista);
        model.addAttribute("documentos", obtenerDocumentosActivos());

        return "tipoTramite/editarTipoTramite";
    }

    @PostMapping("/editar/{id}/quitar")
    public String quitarDocumentoEdicion(@PathVariable String id,
                                         @RequestParam(required = false) String nombre,
                                         @RequestParam Long quitarId,
                                         @RequestParam(value = "documentacionMinimaIds", required = false)
                                         List<Long> documentacionMinimaIds,
                                         Model model) {

        List<Long> ids = new ArrayList<>();

        if (documentacionMinimaIds != null) {
            ids.addAll(documentacionMinimaIds);
        }

        ids.remove(quitarId);

        TipoTramite tipo = buscarTipo(id);

        if (tipo == null) {
            return "redirect:/tipoTramite/listar";
        }

        TipoTramite vista = new TipoTramite();

        vista.setIdTipoTramite(tipo.getIdTipoTramite());
        vista.setNombre(nombre);
        vista.setFechaCreacion(tipo.getFechaCreacion());
        vista.setActivo(tipo.isActivo());
        vista.setDocumentacionMinima(obtenerDocumentosPorIds(ids));

        model.addAttribute("tipo", vista);
        model.addAttribute("documentos", obtenerDocumentosActivos());

        return "tipoTramite/editarTipoTramite";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable String id,
                         @RequestParam String nombre,
                         @RequestParam(value = "documentacionMinimaIds", required = false)
                         List<Long> documentacionMinimaIds,
                         Model model) {

        if (!validarTipoTramite(nombre, documentacionMinimaIds)) {

            TipoTramite tipo = buscarTipo(id);

            if (tipo == null) {
                return "redirect:/tipoTramite/listar";
            }

            TipoTramite vista = new TipoTramite();

            vista.setIdTipoTramite(tipo.getIdTipoTramite());
            vista.setNombre(nombre);
            vista.setFechaCreacion(tipo.getFechaCreacion());
            vista.setActivo(tipo.isActivo());
            vista.setDocumentacionMinima(obtenerDocumentosPorIds(documentacionMinimaIds));

            model.addAttribute("error", "Complete todos los campos");
            model.addAttribute("tipo", vista);
            model.addAttribute("documentos", obtenerDocumentosActivos());

            return "tipoTramite/editarTipoTramite";
        }

        for (TipoTramite t : tipos) {

            if (t.getIdTipoTramite().equals(id)) {

                t.setNombre(nombre);
                t.setDocumentacionMinima(obtenerDocumentosPorIds(documentacionMinimaIds));

                break;
            }
        }

        return "redirect:/tipoTramite/listar";
    }

    @PostMapping("/cambiar-estado/{id}")
    public String cambiarEstado(@PathVariable String id) {

        for (TipoTramite t : DatosMemoria.TIPOS_TRAMITE) {

            if (t.getIdTipoTramite().equals(id)) {

                t.setActivo(!t.isActivo());

                break;
            }
        }

        return "redirect:/tipoTramite/listar";
    }

    private boolean validarTipoTramite(String nombre,
                                       List<Long> documentacionMinimaIds) {

        return !(nombre == null || nombre.isBlank() ||
                documentacionMinimaIds == null ||
                documentacionMinimaIds.isEmpty());
    }

    private List<Documento> obtenerDocumentosPorIds(List<Long> ids) {

        List<Documento> seleccionados = new ArrayList<>();

        if (ids == null) {
            return seleccionados;
        }

        for (Long id : ids) {

            for (Documento d : DatosMemoria.DOCUMENTOS) {

                if (d.getIdDocumento().equals(id)) {

                    seleccionados.add(d);

                    break;
                }
            }
        }

        return seleccionados;
    }

    private List<Documento> obtenerDocumentosActivos() {

        List<Documento> activos = new ArrayList<>();

        for (Documento d : DatosMemoria.DOCUMENTOS) {

            if (d.isActivo()) {
                activos.add(d);
            }
        }

        return activos;
    }

    private TipoTramite buscarTipo(String id) {

        for (TipoTramite t : tipos) {

            if (t.getIdTipoTramite().equals(id)) {
                return t;
            }
        }

        return null;
    }
}