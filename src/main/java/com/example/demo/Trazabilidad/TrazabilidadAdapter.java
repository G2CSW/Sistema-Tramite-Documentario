package com.example.demo.Trazabilidad;

import com.example.demo.Usuario.UsuarioAdapter;
import com.example.demo.Tramite.TramiteAdapter;
import org.springframework.stereotype.Component;

@Component
public class TrazabilidadAdapter {

    private final TramiteAdapter tramiteAdapter;
    private final UsuarioAdapter usuarioAdapter;

    public TrazabilidadAdapter(TramiteAdapter tramiteAdapter,
                               UsuarioAdapter usuarioAdapter) {
        this.tramiteAdapter = tramiteAdapter;
        this.usuarioAdapter = usuarioAdapter;
    }

    public TrazabilidadEntity toEntity(Trazabilidad trazabilidad) {

        if (trazabilidad == null) {
            return null;
        }

        TrazabilidadEntity entity = new TrazabilidadEntity();

        entity.setIdTrazabilidad(
                trazabilidad.getIdTrazabilidad()
        );

        entity.setTramite(
                tramiteAdapter.toEntity(
                        trazabilidad.getTramite()
                )
        );

        entity.setUsuario(
                usuarioAdapter.toEntity(
                        trazabilidad.getUsuario()
                )
        );

        entity.setEstadoCambio(
                trazabilidad.getEstadoCambio()
        );

        entity.setComentario(
                trazabilidad.getComentario()
        );

        entity.setFechaHora(
                trazabilidad.getFechaHora()
        );

        return entity;
    }

    public Trazabilidad toModel(TrazabilidadEntity entity) {

        if (entity == null) {
            return null;
        }

        Trazabilidad trazabilidad = new Trazabilidad();

        trazabilidad.setIdTrazabilidad(
                entity.getIdTrazabilidad()
        );

        trazabilidad.setTramite(
                tramiteAdapter.toModel(
                        entity.getTramite()
                )
        );

        trazabilidad.setUsuario(
                usuarioAdapter.toModel(
                        entity.getUsuario()
                )
        );

        trazabilidad.setEstadoCambio(
                entity.getEstadoCambio()
        );

        trazabilidad.setComentario(
                entity.getComentario()
        );

        trazabilidad.setFechaHora(
                entity.getFechaHora()
        );

        return trazabilidad;
    }
}
