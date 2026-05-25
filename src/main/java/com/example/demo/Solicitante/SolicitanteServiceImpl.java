package com.example.demo.Solicitante;

import com.example.demo.Datos.DatosMemoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitanteServiceImpl implements SolicitanteService {

    private final List<Solicitante> solicitantes = DatosMemoria.SOLICITANTES;

    @Override
    public boolean validarSolicitante(Solicitante s) {
        return !(s.getIdSolicitante() == null || s.getIdSolicitante().isBlank() ||
                s.getNombreCompleto() == null || s.getNombreCompleto().isBlank() ||
                s.getCorreoElectronico() == null || s.getCorreoElectronico().isBlank() ||
                s.getTelefonoContacto() == null || s.getTelefonoContacto().isBlank());
    }

    @Override
    public Solicitante guardarOActualizarSolicitante(Solicitante s) {
        for (Solicitante existente : solicitantes) {
            if (existente.getIdSolicitante().equals(s.getIdSolicitante())) {
                existente.setNombreCompleto(s.getNombreCompleto());
                existente.setCorreoElectronico(s.getCorreoElectronico());
                existente.setTelefonoContacto(s.getTelefonoContacto());
                return existente;
            }
        }
        solicitantes.add(s);
        return s;
    }

    @Override
    public Solicitante buscarSolicitante(String idSolicitante) {
        if (idSolicitante == null) {
            return null;
        }
        for (Solicitante s : solicitantes) {
            if (s.getIdSolicitante().equals(idSolicitante)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean existeSolicitante(String idSolicitante) {
        if (idSolicitante == null) {
            return false;
        }
        for (Solicitante s : solicitantes) {
            if (s.getIdSolicitante().equals(idSolicitante)) {
                return true;
            }
        }
        return false;
    }
}
