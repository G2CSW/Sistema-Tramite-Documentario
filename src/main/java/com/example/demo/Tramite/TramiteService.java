// TramiteService.java

package com.example.demo.Tramite;

import java.util.List;

public interface TramiteService {

    List<Tramite> listarActivos(String idSolicitante);

    Tramite buscarPorId(Long id);

    Tramite registrar(Tramite tramite);

    boolean editar(Long id, Tramite form);

    boolean cambiarEstado(Long id, EstadoTramite estado);

    Long obtenerSiguienteId();
}