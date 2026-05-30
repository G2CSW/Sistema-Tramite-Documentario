package com.example.demo.Solicitante;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SolicitanteServiceImpl implements SolicitanteService {

    private final SolicitanteRepository solicitanteRepository;
    private final SolicitanteAdapter solicitanteAdapter;

    public SolicitanteServiceImpl(SolicitanteRepository solicitanteRepository,
                                  SolicitanteAdapter solicitanteAdapter) {
        this.solicitanteRepository = solicitanteRepository;
        this.solicitanteAdapter = solicitanteAdapter;
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

        return null;
    }

    @Override
    public Solicitante guardarOActualizarSolicitante(Solicitante s) {
        if (s == null) {
            return null;
        }

        SolicitanteEntity entidad = solicitanteAdapter.toEntity(s);
        SolicitanteEntity guardado = solicitanteRepository.save(entidad);

        return solicitanteAdapter.toModel(guardado);
    }

    @Override
    public Solicitante buscarSolicitante(String idSolicitante) {
        if (idSolicitante == null || idSolicitante.isBlank()) {
            return null;
        }

        SolicitanteEntity entidad =
                solicitanteRepository.findById(idSolicitante).orElse(null);

        if (entidad == null) {
            return null;
        }

        return solicitanteAdapter.toModel(entidad);
    }

    @Override
    public boolean existeSolicitante(String idSolicitante) {
        if (idSolicitante == null || idSolicitante.isBlank()) {
            return false;
        }

        return solicitanteRepository.existsById(idSolicitante);
    }
}