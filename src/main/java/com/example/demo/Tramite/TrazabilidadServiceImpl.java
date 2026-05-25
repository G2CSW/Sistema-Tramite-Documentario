package com.example.demo.Tramite;

import com.example.demo.Datos.DatosMemoria;
import com.example.demo.Usuario.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrazabilidadServiceImpl implements TrazabilidadService {

    private final List<Trazabilidad> trazabilidades = DatosMemoria.TRAZABILIDADES;

    @Override
    public void registrarTrazabilidad(Tramite tramite, EstadoTramite estadoCambio, String comentario, Usuario usuario) {
        Trazabilidad trazabilidad = new Trazabilidad();
        trazabilidad.setIdTrazabilidad("TZ" + (trazabilidades.size() + 1));
        trazabilidad.setTramite(tramite);
        trazabilidad.setUsuario(usuario);
        trazabilidad.setEstadoCambio(estadoCambio);
        trazabilidad.setComentario(comentario);
        trazabilidad.setFechaHora(LocalDateTime.now());

        trazabilidades.add(trazabilidad);
    }

    @Override
    public List<Trazabilidad> obtenerTrazabilidad(String nroTramite) {
        List<Trazabilidad> resultado = new ArrayList<>();

        for (Trazabilidad t : trazabilidades) {
            if (t.getTramite().getNroTramite().equals(nroTramite)) {
                resultado.add(t);
            }
        }

        resultado.sort((a, b) -> b.getFechaHora().compareTo(a.getFechaHora()));

        return resultado;
    }
}
