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

    private final TipoTramiteDAO tipoTramiteDAO;
    private final DocumentoService documentoService;

    public TipoTramiteServiceImpl(TipoTramiteDAO tipoTramiteDAO,
                                  DocumentoService documentoService) {
        this.tipoTramiteDAO = tipoTramiteDAO;
        this.documentoService = documentoService;
    }

    @Override
    public List<TipoTramite> listar() {
        return tipoTramiteDAO.listarTodos();
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

        return tipoTramiteDAO.guardar(tipo);
    }

    @Override
    public TipoTramite buscarTipo(Long id) {
        return tipoTramiteDAO.buscarPorId(id);
    }

    @Override
    public TipoTramite editar(Long id, String nombre, List<Long> documentacionMinimaIds) {
        TipoTramite modelo = tipoTramiteDAO.buscarPorId(id);
        if (modelo == null) {
            return null;
        }

        modelo.setNombre(nombre);
        modelo.setDocumentacionMinima(documentoService.obtenerDocumentosPorIds(documentacionMinimaIds));

        return tipoTramiteDAO.guardar(modelo);
    }


    @Override
    public void cambiarEstado(Long id) {
        TipoTramite modelo = tipoTramiteDAO.buscarPorId(id);
        if (modelo != null) {
            modelo.setActivo(!modelo.isActivo());
            tipoTramiteDAO.guardar(modelo);
        }
    }
}