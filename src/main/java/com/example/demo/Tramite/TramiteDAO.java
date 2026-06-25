package com.example.demo.Tramite;

import java.util.List;

public interface TramiteDAO {

    List<Tramite> listarTodos();

    Tramite buscarPorId(Long id);

    Tramite guardar(Tramite tramite);

    boolean actualizar(Tramite tramite);

    Long obtenerUltimoId();

    List<Tramite> buscarPorEstadoActual(EstadoTramite estadoActual);

    List<Tramite> buscarPorEstadoActualYSolicitante(EstadoTramite estadoActual, String idSolicitante);
}
