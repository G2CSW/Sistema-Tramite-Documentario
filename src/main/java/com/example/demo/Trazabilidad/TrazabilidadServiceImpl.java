package com.example.demo.Trazabilidad;

import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.Tramite;
import com.example.demo.Usuario.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TrazabilidadServiceImpl implements TrazabilidadService {

    private final TrazabilidadRepository trazabilidadRepository;
    private final TrazabilidadAdapter trazabilidadAdapter;

    public TrazabilidadServiceImpl(
            TrazabilidadRepository trazabilidadRepository,
            TrazabilidadAdapter trazabilidadAdapter) {

        this.trazabilidadRepository = trazabilidadRepository;
        this.trazabilidadAdapter = trazabilidadAdapter;
    }

    @Override
    public void registrarTrazabilidad(
            Tramite tramite,
            EstadoTramite estadoCambio,
            String comentario,
            Usuario usuario) {

        Trazabilidad trazabilidad = new Trazabilidad();

        trazabilidad.setTramite(tramite);
        trazabilidad.setUsuario(usuario);
        trazabilidad.setEstadoCambio(estadoCambio);
        trazabilidad.setComentario(comentario);
        trazabilidad.setFechaHora(LocalDateTime.now());

        TrazabilidadEntity entity =
                trazabilidadAdapter.toEntity(trazabilidad);

        trazabilidadRepository.save(entity);
    }

    @Override
    public List<Trazabilidad> obtenerTrazabilidad(Long nroTramite) {

        List<TrazabilidadEntity> entidades =
                trazabilidadRepository
                        .findByTramite_NroTramiteOrderByFechaHoraDesc(
                                nroTramite
                        );

        return entidades.stream()
                .map(e -> trazabilidadAdapter.toModel(e))
                .collect(Collectors.toList());
    }
}