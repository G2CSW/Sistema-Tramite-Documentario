package com.example.demo.Solicitante;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SolicitanteServiceImpl implements SolicitanteService {

    private final SolicitanteDAO solicitanteDAO;

    public SolicitanteServiceImpl(SolicitanteDAO solicitanteDAO) {
        this.solicitanteDAO = solicitanteDAO;
    }

    @Override
    public String validarSolicitante(Solicitante s) {
        if (s == null) {
            return "El solicitante no puede ser nulo";
        }

        String dni = s.getIdSolicitante();

        if (dni == null || dni.isBlank()) {
            return "El DNI es obligatorio";
        }

        if (!dni.matches("\\d+")) {
            return "El DNI solo debe contener números";
        }

        if (dni.length() < 8 || dni.length() > 9) {
            return "El DNI debe tener entre 8 y 9 dígitos";
        }

        if (s.getNombreCompleto() == null || s.getNombreCompleto().isBlank()) {
            return "El nombre completo es obligatorio";
        }

        if (s.getCorreoElectronico() == null || s.getCorreoElectronico().isBlank()) {
            return "El correo electrónico es obligatorio";
        }

        if (s.getTelefonoContacto() == null || s.getTelefonoContacto().isBlank()) {
            return "El teléfono de contacto es obligatorio";
        }

        if (!s.getTelefonoContacto().matches("\\d+")) {
            return "El teléfono solo debe contener números";
        }

        return null;
    }

    @Override
    public Solicitante guardarOActualizarSolicitante(Solicitante s) {
        if (s == null) {
            return null;
        }

        return solicitanteDAO.guardar(s);
    }

    @Override
    public Solicitante buscarSolicitante(String idSolicitante) {
        if (idSolicitante == null || idSolicitante.isBlank()) {
            return null;
        }

        return solicitanteDAO.buscarPorId(idSolicitante);
    }

    @Override
    public List<Solicitante> listarTodos() {
        return solicitanteDAO.listarTodos();
    }

    @Override
    public boolean existeSolicitante(String idSolicitante) {
        if (idSolicitante == null || idSolicitante.isBlank()) {
            return false;
        }

        return solicitanteDAO.existePorId(idSolicitante);
    }
}
