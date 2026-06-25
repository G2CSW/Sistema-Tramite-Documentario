package com.example.demo.TipoTramite;

import java.util.List;

public interface TipoTramiteDAO {
    List<TipoTramite> listarTodos();
    TipoTramite buscarPorId(Long id);
    TipoTramite guardar(TipoTramite tipoTramite);
}
