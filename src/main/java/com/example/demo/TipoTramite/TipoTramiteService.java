package com.example.demo.TipoTramite;

import com.example.demo.Documento.Documento;

import java.util.List;

public interface TipoTramiteService {

    List<TipoTramite> listar();

    TipoTramite prepararRegistro();

    TipoTramite agregarDocumento(String nombre,
                                 Long documentoId,
                                 List<Long> documentacionMinimaIds);

    TipoTramite quitarDocumento(String nombre,
                                Long quitarId,
                                List<Long> documentacionMinimaIds);

    TipoTramite agregarDocumento(String id,
                                 String nombre,
                                 Long documentoId,
                                 List<Long> documentacionMinimaIds);

    TipoTramite quitarDocumento(String id,
                                String nombre,
                                Long quitarId,
                                List<Long> documentacionMinimaIds);

    boolean validarTipoTramite(String nombre,
                               List<Long> documentacionMinimaIds);

    void registrar(String nombre,
                   List<Long> documentacionMinimaIds);

    TipoTramite buscarTipo(String id);

    TipoTramite prepararEdicion(String id,
                                String nombre,
                                List<Long> ids);

    void editar(String id,
                String nombre,
                List<Long> documentacionMinimaIds);

    void cambiarEstado(String id);

    List<Documento> obtenerDocumentosActivos();

    List<Documento> obtenerDocumentosPorIds(List<Long> ids);
}