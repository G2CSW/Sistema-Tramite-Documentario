package com.example.demo.Tramite;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.TipoTramite.TipoTramite;
import com.example.demo.Usuario.Usuario;
import com.example.demo.Datos.DatosMemoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tramite")
public class TramiteController {

    private final List<Tramite> tramites = DatosMemoria.TRAMITES;
    private final List<Solicitante> solicitantes = DatosMemoria.SOLICITANTES;
    private final List<TipoTramite> tipoTramites = DatosMemoria.TIPOS_TRAMITE;

    public TramiteController() {
    }

    @GetMapping("/listar")
    public String listarTramites(Model model) {
        List<Tramite> tramitesActivos = new ArrayList<>();

        for (Tramite t : tramites) {
            if (t.getEstadoActual() != EstadoTramite.ARCHIVADO &&
                    t.getEstadoActual() != EstadoTramite.CANCELADO) {
                tramitesActivos.add(t);
            }
        }

        model.addAttribute("tramites", tramitesActivos);
        return "tramite/tramites";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(
            @ModelAttribute("tramite") Tramite tramite,
            @RequestParam(required = false, name = "tipoTramite.idTipoTramite") String tipoTramiteId,
            Model model) {

        // Si no vino solicitante, evitar null
        if (tramite.getSolicitante() == null) {
            tramite.setSolicitante(new Solicitante());
        }

        String dni = tramite.getSolicitante().getDni();

        Solicitante solicitanteEncontrado = tramite.getSolicitante();
        boolean existeSolicitante = false;

        // Buscar en memoria
        if (dni != null && !dni.isBlank()) {
            for (Solicitante s : solicitantes) {
                if (s.getDni().equals(dni)) {
                    solicitanteEncontrado = s;
                    existeSolicitante = true;
                    break;
                }
            }
        }

        TipoTramite tipoSeleccionado = new TipoTramite();

        if (tipoTramiteId != null && !tipoTramiteId.isBlank()) {
            for (TipoTramite t : tipoTramites) {
                if (t.getIdTipoTramite().equals(tipoTramiteId)) {
                    tipoSeleccionado = t;
                    break;
                }
            }
        }

        model.addAttribute("tramite", tramite);
        model.addAttribute("solicitante", solicitanteEncontrado);
        model.addAttribute("tipoSeleccionado", tipoSeleccionado);
        model.addAttribute("tipoTramites", tipoTramites);

        model.addAttribute("dniBuscado", dni);
        model.addAttribute("tipoTramiteId", tipoTramiteId);
        model.addAttribute("existeSolicitante", existeSolicitante);

        model.addAttribute("numeroTramiteGenerado", generarNumeroTramite());

        return "tramite/registrarTramite";
    }

    @PostMapping("/registrar")
    public String registrarTramite(@ModelAttribute Tramite tramite,
                                   Model model,
                                   RedirectAttributes redirectAttributes) {

        Solicitante solicitanteForm = tramite.getSolicitante();

        // VALIDACIÓN
        if (solicitanteForm.getDni() == null || solicitanteForm.getDni().isBlank() ||
                solicitanteForm.getNombreCompleto() == null || solicitanteForm.getNombreCompleto().isBlank() ||
                solicitanteForm.getCorreoElectronico() == null || solicitanteForm.getCorreoElectronico().isBlank() ||
                solicitanteForm.getTelefonoContacto() == null || solicitanteForm.getTelefonoContacto().isBlank()) {

            // ERROR → devolver al formulario sin perder datos
            model.addAttribute("error", "Complete todos los datos del solicitante");

            // Mantener datos del formulario
            model.addAttribute("tramite", tramite);
            model.addAttribute("solicitante", solicitanteForm);
            model.addAttribute("tipoTramites", tipoTramites);

            // Mantener tipo seleccionado
            String tipoTramiteId = tramite.getTipoTramite() != null
                    ? tramite.getTipoTramite().getIdTipoTramite()
                    : null;

            model.addAttribute("tipoTramiteId", tipoTramiteId);

            // Mantener documentación cargada
            TipoTramite tipoSeleccionado = new TipoTramite();
            if (tipoTramiteId != null) {
                for (TipoTramite t : tipoTramites) {
                    if (t.getIdTipoTramite().equals(tipoTramiteId)) {
                        tipoSeleccionado = t;
                        break;
                    }
                }
            }
            model.addAttribute("tipoSeleccionado", tipoSeleccionado);

            // Mantener estado de búsqueda DNI
            boolean existeSolicitante = false;
            for (Solicitante s : solicitantes) {
                if (s.getDni().equals(solicitanteForm.getDni())) {
                    existeSolicitante = true;
                    break;
                }
            }

            model.addAttribute("dniBuscado", solicitanteForm.getDni());
            model.addAttribute("existeSolicitante", existeSolicitante);

            model.addAttribute("numeroTramiteGenerado", generarNumeroTramite());

            return "tramite/registrarTramite";
        }

        // SI PASA VALIDACIÓN → continuar normal

        tramite.setNroTramite(generarNumeroTramite());
        tramite.setFechaRegistro(LocalDate.now());
        tramite.setEstadoActual(EstadoTramite.REGISTRADO);

        // Buscar si ya existe
        Solicitante solicitanteFinal = null;

        for (Solicitante s : solicitantes) {
            if (s.getDni().equals(solicitanteForm.getDni())) {

                if (solicitanteForm.getNombreCompleto() != null && !solicitanteForm.getNombreCompleto().isBlank()) {
                    s.setNombreCompleto(solicitanteForm.getNombreCompleto());
                }

                if (solicitanteForm.getCorreoElectronico() != null && !solicitanteForm.getCorreoElectronico().isBlank()) {
                    s.setCorreoElectronico(solicitanteForm.getCorreoElectronico());
                }

                if (solicitanteForm.getTelefonoContacto() != null && !solicitanteForm.getTelefonoContacto().isBlank()) {
                    s.setTelefonoContacto(solicitanteForm.getTelefonoContacto());
                }

                solicitanteFinal = s;
                break;
            }
        }

        if (solicitanteFinal == null) {
            solicitantes.add(solicitanteForm);
            solicitanteFinal = solicitanteForm;
        }

        tramite.setSolicitante(solicitanteFinal);

        // Tipo trámite
        String idTipo = tramite.getTipoTramite().getIdTipoTramite();
        TipoTramite tipoReal = null;

        for (TipoTramite t : tipoTramites) {
            if (t.getIdTipoTramite().equals(idTipo)) {
                tipoReal = t;
                break;
            }
        }

        tramite.setTipoTramite(tipoReal);

        tramites.add(tramite);

        redirectAttributes.addFlashAttribute("mensaje", "Trámite " + tramite.getNroTramite() + " registrado correctamente");
        return "redirect:/tramite/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") String id,
                                          Model model,
                                          RedirectAttributes redirectAttributes) {
        Tramite tramite = buscarPorId(id);

        if (tramite != null) {
            model.addAttribute("tramite", tramite);
            return "tramite/editarTramite";
        }

        redirectAttributes.addFlashAttribute("mensaje", "Trámite no encontrado");
        return "redirect:/tramite/listar";
    }

    @PostMapping("/editar/{id}")
    public String editarTramite(@PathVariable("id") String id,
                                @ModelAttribute Tramite tramiteEditado,
                                RedirectAttributes redirectAttributes) {
        Tramite tramite = buscarPorId(id);

        if (tramite != null) {
            tramite.setTipoTramite(tramiteEditado.getTipoTramite());
            tramite.setUsuario(tramiteEditado.getUsuario());
            tramite.setSolicitante(tramiteEditado.getSolicitante());
            tramite.setFechaRegistro(tramiteEditado.getFechaRegistro());
            tramite.setEstadoActual(tramiteEditado.getEstadoActual());

            redirectAttributes.addFlashAttribute("mensaje", "Trámite actualizado correctamente");
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "Trámite no encontrado");
        }

        return "redirect:/tramite/listar";
    }

    @PostMapping("/cambiar-estado/{id}")
    public String cambiarEstadoTramite(@PathVariable("id") String id,
                                       @RequestParam("estado") EstadoTramite estado,
                                       RedirectAttributes redirectAttributes) {
        Tramite tramite = buscarPorId(id);

        if (tramite != null) {
            tramite.setEstadoActual(estado);
            redirectAttributes.addFlashAttribute("mensaje", "Estado del trámite actualizado");
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "Trámite no encontrado");
        }

        return "redirect:/tramite/listar";
    }


    // FUNCIONES REUTILIZABLES
    private Tramite buscarPorId(String id) {
        for (Tramite tramite : tramites) {
            if (tramite.getNroTramite().equals(id)) {
                return tramite;
            }
        }
        return null;
    }

    private String generarNumeroTramite() {
        int max = 0;

        for (Tramite t : tramites) {
            String nro = t.getNroTramite();

            try {
                int numero = Integer.parseInt(nro.substring(2));
                if (numero > max) {
                    max = numero;
                }
            } catch (Exception e) {

            }
        }

        return "TR" + (max + 1);
    }
}