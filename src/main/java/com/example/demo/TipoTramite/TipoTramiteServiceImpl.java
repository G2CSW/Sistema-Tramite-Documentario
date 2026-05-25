package com.example.demo.TipoTramite;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.Documento.Documento;
import com.example.demo.Documento.DocumentoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TipoTramiteServiceImpl implements TipoTramiteService {

    private final List<TipoTramite> tipos = DatosMemoria.TIPOS_TRAMITE;
    private final DocumentoService documentoService;

    public TipoTramiteServiceImpl(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @Override
    public List<TipoTramite> listar() {
        return tipos;
    }



    @Override
    public boolean validarTipoTramite(String nombre,
                                      List<Long> documentacionMinimaIds) {
        return !(nombre == null || nombre.isBlank()
                || documentacionMinimaIds == null
                || documentacionMinimaIds.isEmpty());
    }

    @Override
    public void registrar(String nombre,
                          List<Long> documentacionMinimaIds) {
        TipoTramite tipo = new TipoTramite();

        tipo.setIdTipoTramite("TT" + (tipos.size() + 1));
        tipo.setNombre(nombre);
        tipo.setDocumentacionMinima(documentoService.obtenerDocumentosPorIds(documentacionMinimaIds));
        tipo.setFechaCreacion(LocalDate.now());
        tipo.setActivo(true);

        tipos.add(tipo);
    }

    @Override
    public TipoTramite buscarTipo(String id) {
        for (TipoTramite t : tipos) {
            if (t.getIdTipoTramite().equals(id)) {
                return t;
            }
        }
        return null;
    }



    @Override
    public void editar(String id,
                       String nombre,
                       List<Long> documentacionMinimaIds) {
        for (TipoTramite t : tipos) {
            if (t.getIdTipoTramite().equals(id)) {
                t.setNombre(nombre);
                t.setDocumentacionMinima(
                        documentoService.obtenerDocumentosPorIds(documentacionMinimaIds)
                );
                break;
            }
        }
    }

    @Override
    public void cambiarEstado(String id) {
        for (TipoTramite t : tipos) {
            if (t.getIdTipoTramite().equals(id)) {
                t.setActivo(!t.isActivo());
                break;
            }
        }
    }

}