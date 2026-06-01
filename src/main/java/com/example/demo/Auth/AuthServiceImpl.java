package com.example.demo.Auth;

import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.UsuarioAdapter;
import com.example.demo.Usuario.UsuarioEntity;
import com.example.demo.Usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioAdapter usuarioAdapter;

    public AuthServiceImpl(UsuarioRepository usuarioRepository,
                           UsuarioAdapter usuarioAdapter) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioAdapter = usuarioAdapter;
    }

    @Override
    public Usuario login(String dni, String password) {
        UsuarioEntity entity = usuarioRepository.findById(dni).orElse(null);

        if (entity != null && entity.isActivo() && entity.getPassword().equals(password)) {
            return usuarioAdapter.toModel(entity);
        }

        return null;
    }
}
