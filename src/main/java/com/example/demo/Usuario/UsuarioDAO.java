package com.example.demo.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDAO {
    List<Usuario> listarTodos();
    Usuario buscarPorId(String id);
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPrimerUsuarioActivo();
    boolean existePorId(String id);
}
