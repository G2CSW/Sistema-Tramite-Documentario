package com.example.demo.TipoTramite;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.Documento.Documento;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TipoTramiteServiceImpl implements TipoTramiteService {

    private final List<TipoTramite> tipos = DatosMemoria.TIPOS_TRAMITE;

    @Override
    public List<TipoTramite> listar() {
        return tipos;
    }

    @Override
    public TipoTramite prepararRegistro() {
        TipoTramite tipo = new TipoTramite();
        tipo.setDocumentacionMinima(new ArrayList<>());
        return tipo;
    }

    @Override
    public TipoTramite agregarDocumento(String nombre,
                                        Long documentoId,
                                        List<Long> documentacionMinimaIds) {
        List<Long> ids = new ArrayList<>();

        if (documentacionMinimaIds != null) {
            ids.addAll(documentacionMinimaIds);
        }

        if (documentoId != null && !ids.contains(documentoId)) {
            ids.add(documentoId);
        }

        TipoTramite tipo = new TipoTramite();
        tipo.setNombre(nombre);
        tipo.setDocumentacionMinima(obtenerDocumentosPorIds(ids));

        return tipo;
    }

    @Override
    public TipoTramite quitarDocumento(String nombre,
                                       Long quitarId,
                                       List<Long> documentacionMinimaIds) {
        List<Long> ids = new ArrayList<>();

        if (documentacionMinimaIds != null) {
            ids.addAll(documentacionMinimaIds);
        }

        ids.remove(quitarId);

        TipoTramite tipo = new TipoTramite();
        tipo.setNombre(nombre);
        tipo.setDocumentacionMinima(obtenerDocumentosPorIds(ids));

        return tipo;
    }

    @Override
    public TipoTramite agregarDocumento(String id,
                                        String nombre,
                                        Long documentoId,
                                        List<Long> documentacionMinimaIds) {
        List<Long> ids = new ArrayList<>();

        if (documentacionMinimaIds != null) {
            ids.addAll(documentacionMinimaIds);
        }

        if (documentoId != null && !ids.contains(documentoId)) {
            ids.add(documentoId);
        }

        return construirVistaEdicion(id, nombre, ids);
    }

    @Override
    public TipoTramite quitarDocumento(String id,
                                       String nombre,
                                       Long quitarId,
                                       List<Long> documentacionMinimaIds) {
        List<Long> ids = new ArrayList<>();

        if (documentacionMinimaIds != null) {
            ids.addAll(documentacionMinimaIds);
        }

        ids.remove(quitarId);

        return construirVistaEdicion(id, nombre, ids);
    }

    private TipoTramite construirVistaEdicion(String id,
                                              String nombre,
                                              List<Long> ids) {
        TipoTramite tipo = buscarTipo(id);

        if (tipo == null) {
            return null;
        }

        TipoTramite vista = new TipoTramite();
        vista.setIdTipoTramite(tipo.getIdTipoTramite());
        vista.setNombre(nombre);
        vista.setFechaCreacion(tipo.getFechaCreacion());
        vista.setActivo(tipo.isActivo());
        vista.setDocumentacionMinima(obtenerDocumentosPorIds(ids));

        return vista;
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
        tipo.setDocumentacionMinima(obtenerDocumentosPorIds(documentacionMinimaIds));
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
    public TipoTramite prepararEdicion(String id,
                                       String nombre,
                                       List<Long> ids) {
        TipoTramite tipo = buscarTipo(id);

        if (tipo == null) {
            return null;
        }

        TipoTramite vista = new TipoTramite();
        vista.setIdTipoTramite(tipo.getIdTipoTramite());
        vista.setNombre(nombre);
        vista.setFechaCreacion(tipo.getFechaCreacion());
        vista.setActivo(tipo.isActivo());
        vista.setDocumentacionMinima(obtenerDocumentosPorIds(ids));

        return vista;
    }

    @Override
    public void editar(String id,
                       String nombre,
                       List<Long> documentacionMinimaIds) {
        for (TipoTramite t : tipos) {
            if (t.getIdTipoTramite().equals(id)) {
                t.setNombre(nombre);
                t.setDocumentacionMinima(
                        obtenerDocumentosPorIds(documentacionMinimaIds)
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

    @Override
    public List<Documento> obtenerDocumentosActivos() {
        List<Documento> activos = new ArrayList<>();

        for (Documento d : DatosMemoria.DOCUMENTOS) {
            if (d.isActivo()) {
                activos.add(d);
            }
        }

        return activos;
    }

    @Override
    public List<Documento> obtenerDocumentosPorIds(List<Long> ids) {
        List<Documento> seleccionados = new ArrayList<>();

        if (ids == null) {
            return seleccionados;
        }

        for (Long id : ids) {
            for (Documento d : DatosMemoria.DOCUMENTOS) {
                if (d.getIdDocumento().equals(id)) {
                    seleccionados.add(d);
                    break;
                }
            }
        }

        return seleccionados;
    }
}