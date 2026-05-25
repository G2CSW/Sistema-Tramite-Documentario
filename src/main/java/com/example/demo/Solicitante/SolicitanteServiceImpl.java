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
    public boolean validarSolicitante(Solicitante s) {
        if (s == null) {
            return false;
        }

        boolean idValido = s.getIdSolicitante() != null && !s.getIdSolicitante().isBlank();
        boolean nombreValido = s.getNombreCompleto() != null && !s.getNombreCompleto().isBlank();
        boolean correoValido = s.getCorreoElectronico() != null && !s.getCorreoElectronico().isBlank();
        boolean telefonoValido = s.getTelefonoContacto() != null && !s.getTelefonoContacto().isBlank();

        return idValido && nombreValido && correoValido && telefonoValido;
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