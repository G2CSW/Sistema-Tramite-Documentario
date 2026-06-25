package com.example.demo.Usuario;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private final UsuarioRepository repository;
    private final UsuarioAdapter adapter;

    public UsuarioDAOImpl(UsuarioRepository repository, UsuarioAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll()
                .stream()
                .map(adapter::toModel)
                .toList();
    }

    @Override
    public Usuario buscarPorId(String id) {
        return repository.findById(id)
                .map(adapter::toModel)
                .orElse(null);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return adapter.toModel(
                repository.save(adapter.toEntity(usuario))
        );
    }

    @Override
    public Optional<Usuario> buscarPrimerUsuarioActivo() {
        return repository.findFirstByActivoTrueOrderByIdUsuarioAsc()
                .map(adapter::toModel);
    }

    @Override
    public boolean existePorId(String id) {
        return repository.existsById(id);
    }
}
