package com.example.demo.Auth;

import com.example.demo.Usuario.Usuario;

public interface AuthService {
    Usuario login(String dni, String password);
}
