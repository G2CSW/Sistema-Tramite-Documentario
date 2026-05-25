package com.example.demo.Documento;

import com.example.demo.Datos.DatosMemoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    private final List<Documento> documentos = DatosMemoria.DOCUMENTOS;

    @Override
    public List<Documento> listar() {
        return documentos;
    }

    @Override
    public List<Documento> obtenerDocumentosActivos() {
        List<Documento> activos = new ArrayList<>();
        for (Documento d : documentos) {
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
            for (Documento d : documentos) {
                if (d.getIdDocumento().equals(id)) {
                    seleccionados.add(d);
                    break;
                }
            }
        }
        return seleccionados;
    }

    @Override
    public Documento buscarPorId(Long id) {
        for (Documento d : documentos) {
            if (d.getIdDocumento().equals(id)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public Documento registrar(Documento documento) {
        if (!validarDocumento(documento)) {
            return null;
        }

        documento.setIdDocumento((long) (documentos.size() + 1));
        documento.setActivo(true);
        documentos.add(documento);

        return documento;
    }

    @Override
    public Documento editar(Long id, Documento form) {
        Documento actual = buscarPorId(id);

        if (actual == null || !validarDocumento(form)) {
            return null;
        }

        actual.setNombreDocumento(form.getNombreDocumento());
        return actual;
    }

    @Override
    public void cambiarEstado(Long id) {
        for (Documento d : documentos) {
            if (d.getIdDocumento().equals(id)) {
                d.setActivo(!d.isActivo());
                break;
            }
        }
    }

    private boolean validarDocumento(Documento documento) {
        return documento != null
                && documento.getNombreDocumento() != null
                && !documento.getNombreDocumento().isBlank();
    }
}