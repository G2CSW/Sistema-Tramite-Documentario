package com.example.demo.TipoTramite;

import java.util.List;

public interface TipoTramiteService {

    List<TipoTramite> listar();

    boolean validarTipoTramite(String nombre,
                               List<Long> documentacionMinimaIds);

    TipoTramite registrar(String nombre,
                          List<Long> documentacionMinimaIds);

    TipoTramite buscarTipo(Long id);

    TipoTramite editar(Long id,
                       String nombre,
                       List<Long> documentacionMinimaIds);

    void cambiarEstado(Long id);
}