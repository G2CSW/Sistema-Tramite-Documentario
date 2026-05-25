package com.example.demo.Usuario;

import com.example.demo.Area.Area;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listarUsuarios();

    List<Area> listarAreas();

    boolean registrarUsuario(Usuario usuario, String idArea);

    Usuario obtenerUsuario(String idUsuario);

    boolean editarUsuario(String idUsuario, Usuario form, String idArea);

    void toggleEstado(String idUsuario);
}