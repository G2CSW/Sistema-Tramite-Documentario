package com.example.demo.BandejaTrabajo;

import com.example.demo.Tramite.Tramite;

import java.util.List;

public interface BandejaTrabajoService {

    List<Tramite> listarTramitesAEvaluar(String dni);

    Tramite buscarPorId(Long id);

    String procesarEvaluacion(Long id,
                              boolean datosCompletos,
                              boolean datosConsistentes,
                              boolean cumpleRequisitos,
                              boolean sustentoValido,
                              String accion,
                              String comentario,
                              String idUsuarioLogueado);

    String obtenerMensajeErrorEvaluacion(String accion,
                                         boolean datosCompletos,
                                         boolean datosConsistentes,
                                         boolean cumpleRequisitos,
                                         boolean sustentoValido);
}
