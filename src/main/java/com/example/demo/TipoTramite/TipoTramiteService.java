package com.example.demo.TipoTramite;

import com.example.demo.Documento.Documento;

import java.util.List;

public interface TipoTramiteService {

    List<TipoTramite> listar();



    boolean validarTipoTramite(String nombre,
                               List<Long> documentacionMinimaIds);

    void registrar(String nombre,
                   List<Long> documentacionMinimaIds);

    TipoTramite buscarTipo(String id);



    void editar(String id,
                String nombre,
                List<Long> documentacionMinimaIds);

    void cambiarEstado(String id);


}