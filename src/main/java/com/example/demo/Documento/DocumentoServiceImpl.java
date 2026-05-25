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

    private final DocumentoRepository documentoRepository;
    private final DocumentoAdapter documentoAdapter;

    public DocumentoServiceImpl(DocumentoRepository documentoRepository,
                                DocumentoAdapter documentoAdapter) {
        this.documentoRepository = documentoRepository;
        this.documentoAdapter = documentoAdapter;
    }

    @Override
    public List<Documento> listar() {
        List<DocumentoEntity> entidades = documentoRepository.findAll();

        return entidades.stream()
                .map(e -> documentoAdapter.toModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<Documento> obtenerDocumentosActivos() {
        List<DocumentoEntity> entidades = documentoRepository.findByActivoTrue();

        return entidades.stream()
                .map(e -> documentoAdapter.toModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<Documento> obtenerDocumentosPorIds(List<Long> ids) {
        List<Documento> seleccionados = new ArrayList<>();

        if (ids == null || ids.isEmpty()) {
            return seleccionados;
        }

        List<DocumentoEntity> entidades = documentoRepository.findByIdDocumentoIn(ids);

        Map<Long, DocumentoEntity> mapa = entidades.stream()
                .collect(Collectors.toMap(DocumentoEntity::getIdDocumento, entity -> entity));

        for (Long id : ids) {
            DocumentoEntity entidad = mapa.get(id);

            if (entidad != null) {
                seleccionados.add(documentoAdapter.toModel(entidad));
            }
        }

        return seleccionados;
    }

    @Override
    public Documento buscarPorId(Long id) {
        if (id == null) {
            return null;
        }

        DocumentoEntity entidad = documentoRepository.findById(id).orElse(null);

        if (entidad == null) {
            return null;
        }

        return documentoAdapter.toModel(entidad);
    }

    @Override
    public Documento registrar(Documento documento) {
        if (!validarDocumento(documento)) {
            return null;
        }

        DocumentoEntity entidad = documentoAdapter.toEntity(documento);
        entidad.setIdDocumento(null);
        entidad.setActivo(true);

        DocumentoEntity guardado = documentoRepository.save(entidad);

        return documentoAdapter.toModel(guardado);
    }

    @Override
    public Documento editar(Long id, Documento form) {
        DocumentoEntity actual = documentoRepository.findById(id).orElse(null);

        if (actual == null || !validarDocumento(form)) {
            return null;
        }

        actual.setNombreDocumento(form.getNombreDocumento());

        DocumentoEntity guardado = documentoRepository.save(actual);

        return documentoAdapter.toModel(guardado);
    }

    @Override
    public void cambiarEstado(Long id) {
        DocumentoEntity actual = documentoRepository.findById(id).orElse(null);

        if (actual == null) {
            return;
        }

        boolean nuevoEstado = !actual.isActivo();
        actual.setActivo(nuevoEstado);

        documentoRepository.save(actual);
    }

    private boolean validarDocumento(Documento documento) {
        return documento != null
                && documento.getNombreDocumento() != null
                && !documento.getNombreDocumento().isBlank();
    }
}