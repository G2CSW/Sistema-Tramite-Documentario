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

    private final TrazabilidadDAO trazabilidadDAO;

    public TrazabilidadServiceImpl(TrazabilidadDAO trazabilidadDAO) {
        this.trazabilidadDAO = trazabilidadDAO;
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

        trazabilidadDAO.guardar(trazabilidad);
    }

    @Override
    public List<Trazabilidad> obtenerTrazabilidad(Long nroTramite) {

        return trazabilidadDAO.buscarPorTramiteOrdenado(nroTramite);
    }
}