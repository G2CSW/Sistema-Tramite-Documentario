package com.example.demo.BandejaTrabajo;

import com.example.demo.Tramite.Tramite;

import java.util.List;

public interface BandejaTrabajoService {

    List<Tramite> listarTramitesAEvaluar(String dni);

    Tramite buscarPorId(String id);

    String procesarEvaluacion(String id,
                               boolean datosCompletos,
                               boolean datosConsistentes,
                               boolean cumpleRequisitos,
                               boolean sustentoValido,
                               String accion,
                               String comentario);

    String obtenerMensajeErrorEvaluacion(String accion,
                                         boolean datosCompletos,
                                         boolean datosConsistentes,
                                         boolean cumpleRequisitos,
                                         boolean sustentoValido);
}