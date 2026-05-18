// TramiteService.java

package com.example.demo.Tramite;

import java.util.List;

public interface TramiteService {

    List<Tramite> listarActivos(String idSolicitante);

    Tramite buscarPorId(String id);

    List<Trazabilidad> obtenerTrazabilidad(String nroTramite);

    FormularioTramiteDTO prepararFormularioRegistro(
            Tramite tramite,
            String tipoId
    );

    FormularioTramiteDTO prepararFormularioEdicion(
            String id,
            Tramite form
    );

    boolean validarSolicitante(Solicitante solicitante);

    Tramite registrar(Tramite tramite);

    boolean editar(String id, Tramite form);

    boolean cambiarEstado(String id, EstadoTramite estado);
}