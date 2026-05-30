package com.example.demo.Tramite;

import com.example.demo.Solicitante.SolicitanteAdapter;
import com.example.demo.TipoTramite.TipoTramiteAdapter;
import com.example.demo.Usuario.UsuarioAdapter;
import org.springframework.stereotype.Component;

@Component
public class TramiteAdapter {

    private final TipoTramiteAdapter tipoTramiteAdapter;
    private final SolicitanteAdapter solicitanteAdapter;

    public TramiteAdapter(TipoTramiteAdapter tipoTramiteAdapter,
                          SolicitanteAdapter solicitanteAdapter) {
        this.tipoTramiteAdapter = tipoTramiteAdapter;
        this.solicitanteAdapter = solicitanteAdapter;
    }

    public TramiteEntity toEntity(Tramite tramite) {
        if (tramite == null) return null;
        TramiteEntity entity = new TramiteEntity();
        entity.setNroTramite(tramite.getNroTramite());
        entity.setTipoTramite(tipoTramiteAdapter.toEntity(tramite.getTipoTramite()));
        entity.setSolicitante(solicitanteAdapter.toEntity(tramite.getSolicitante()));
        entity.setFechaRegistro(tramite.getFechaRegistro());
        entity.setEstadoActual(tramite.getEstadoActual());
        entity.setDatosCompletos(tramite.getDatosCompletos());
        entity.setDatosConsistentes(tramite.getDatosConsistentes());
        entity.setCumpleRequisitos(tramite.getCumpleRequisitos());
        entity.setSustentoValido(tramite.getSustentoValido());
        return entity;
    }

    public Tramite toModel(TramiteEntity entity) {
        if (entity == null) return null;
        Tramite tramite = new Tramite();
        tramite.setNroTramite(entity.getNroTramite());
        tramite.setTipoTramite(tipoTramiteAdapter.toModel(entity.getTipoTramite()));
        tramite.setSolicitante(solicitanteAdapter.toModel(entity.getSolicitante()));
        tramite.setFechaRegistro(entity.getFechaRegistro());
        tramite.setEstadoActual(entity.getEstadoActual());
        tramite.setDatosCompletos(entity.getDatosCompletos());
        tramite.setDatosConsistentes(entity.getDatosConsistentes());
        tramite.setCumpleRequisitos(entity.getCumpleRequisitos());
        tramite.setSustentoValido(entity.getSustentoValido());
        return tramite;
    }
}
