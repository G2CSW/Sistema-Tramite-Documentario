package com.example.demo.Trazabilidad;

import java.util.List;

public interface TrazabilidadDAO {
    List<Trazabilidad> listarTodos();
    Trazabilidad buscarPorId(Long id);
    Trazabilidad guardar(Trazabilidad trazabilidad);
    List<Trazabilidad> buscarPorTramiteOrdenado(Long nroTramite);
}
