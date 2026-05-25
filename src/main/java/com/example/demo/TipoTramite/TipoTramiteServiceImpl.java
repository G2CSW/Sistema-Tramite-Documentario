package com.example.demo.TipoTramite;

import com.example.demo.Documento.Documento;
import com.example.demo.Documento.DocumentoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoTramiteServiceImpl implements TipoTramiteService {

    private final TipoTramiteRepository repository;
    private final TipoTramiteAdapter adapter;
    private final DocumentoService documentoService;

    public TipoTramiteServiceImpl(TipoTramiteRepository repository,
                                  TipoTramiteAdapter adapter,
                                  DocumentoService documentoService) {
        this.repository = repository;
        this.adapter = adapter;
        this.documentoService = documentoService;
    }

    @Override
    public List<TipoTramite> listar() {
        return repository.findAll()
                .stream()
                .map(adapter::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean validarTipoTramite(String nombre, List<Long> documentacionMinimaIds) {
        return !(nombre == null || nombre.isBlank()
                || documentacionMinimaIds == null
                || documentacionMinimaIds.isEmpty());
    }

    @Override
    public TipoTramite registrar(String nombre, List<Long> documentacionMinimaIds) {
        TipoTramite tipo = new TipoTramite();
        tipo.setNombre(nombre);
        tipo.setFechaCreacion(LocalDate.now());
        tipo.setActivo(true);

        List<Documento> documentos = documentoService.obtenerDocumentosPorIds(documentacionMinimaIds);
        tipo.setDocumentacionMinima(documentos);

        TipoTramiteEntity guardado = repository.save(adapter.toEntity(tipo));
        return adapter.toModel(guardado);
    }

    @Override
    public TipoTramite buscarTipo(Long id) {
        Optional<TipoTramiteEntity> entity = repository.findById(id);
        return entity.map(adapter::toModel).orElse(null);
    }

    @Override
    public TipoTramite editar(Long id, String nombre, List<Long> documentacionMinimaIds) {
        Optional<TipoTramiteEntity> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        TipoTramiteEntity entity = optional.get();
        entity.setNombre(nombre);

        TipoTramite modelo = adapter.toModel(entity);
        modelo.setNombre(nombre);
        modelo.setDocumentacionMinima(documentoService.obtenerDocumentosPorIds(documentacionMinimaIds));

        TipoTramiteEntity actualizado = repository.save(adapter.toEntity(modelo));
        return adapter.toModel(actualizado);
    }


    @Override
    public void cambiarEstado(Long id) {
        Optional<TipoTramiteEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            TipoTramiteEntity entity = optional.get();
            entity.setActivo(!entity.isActivo());
            repository.save(entity);
        }
    }
}