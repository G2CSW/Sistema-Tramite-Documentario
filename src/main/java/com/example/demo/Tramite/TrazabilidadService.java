package com.example.demo.Tramite;

import com.example.demo.Usuario.Usuario;
import java.util.List;

public interface TrazabilidadService {

    void registrarTrazabilidad(Tramite tramite, EstadoTramite estadoCambio, String comentario, Usuario usuario);

    List<Trazabilidad> obtenerTrazabilidad(String nroTramite);
}
