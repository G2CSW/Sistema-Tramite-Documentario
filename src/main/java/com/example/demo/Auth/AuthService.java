package com.example.demo.Auth;

import com.example.demo.Usuario.UsuarioEntity;

public interface AuthService {
    UsuarioEntity login(String username, String password);
}
