package com.example.demo.Trazabilidad;

import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.Tramite;
import com.example.demo.Usuario.Usuario;

import java.util.List;

public interface TrazabilidadService {

    void registrarTrazabilidad(
            Tramite tramite,
            EstadoTramite estadoCambio,
            String comentario,
            Usuario usuario
    );

    List<Trazabilidad> obtenerTrazabilidad(Long nroTramite);
}
