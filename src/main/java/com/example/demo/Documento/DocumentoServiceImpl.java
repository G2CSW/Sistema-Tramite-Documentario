package com.example.demo.Documento;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class DocumentoServiceImpl implements DocumentoService {

    private final DocumentoDAO documentoDAO;

    public DocumentoServiceImpl(DocumentoDAO documentoDAO) {
        this.documentoDAO = documentoDAO;
    }

    @Override
    public List<Documento> listar() {
        return documentoDAO.listarTodos();
    }

    @Override
    public List<Documento> obtenerDocumentosActivos() {
        return documentoDAO.listarActivos();
    }

    @Override
    public List<Documento> obtenerDocumentosPorIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        return documentoDAO.buscarPorIds(ids);
    }

    @Override
    public Documento buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        return documentoDAO.buscarPorId(id);
    }

    @Override
    public Documento registrar(Documento documento) {
        if (!validarDocumento(documento)) {
            return null;
        }

        documento.setIdDocumento(null);
        documento.setActivo(true);

        return documentoDAO.guardar(documento);
    }

    @Override
    public Documento editar(Long id, Documento form) {
        Documento actual = documentoDAO.buscarPorId(id);

        if (actual == null || !validarDocumento(form)) {
            return null;
        }

        actual.setNombreDocumento(form.getNombreDocumento());

        return documentoDAO.guardar(actual);
    }

    @Override
    public void cambiarEstado(Long id) {
        Documento actual = documentoDAO.buscarPorId(id);

        if (actual == null) {
            return;
        }

        boolean nuevoEstado = !actual.isActivo();
        actual.setActivo(nuevoEstado);

        documentoDAO.guardar(actual);
    }

    private boolean validarDocumento(Documento documento) {
        return documento != null
                && documento.getNombreDocumento() != null
                && !documento.getNombreDocumento().isBlank();
    }
}
