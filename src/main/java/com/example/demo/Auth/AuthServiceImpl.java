package com.example.demo.Auth;

import com.example.demo.Usuario.UsuarioEntity;
import com.example.demo.Usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioEntity login(String username, String password) {
        UsuarioEntity usuario = usuarioRepository.findById(username).orElse(null);

        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }

        return null;
    }
}
