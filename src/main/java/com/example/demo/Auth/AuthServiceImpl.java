package com.example.demo.Auth;

import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.UsuarioDAO;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioDAO usuarioDAO;

    public AuthServiceImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public Usuario login(String dni, String password) {
        Usuario usuario = usuarioDAO.buscarPorId(dni);

        if (usuario != null && usuario.isActivo() && usuario.getPassword().equals(password)) {
            return usuario;
        }

        return null;
    }
}
