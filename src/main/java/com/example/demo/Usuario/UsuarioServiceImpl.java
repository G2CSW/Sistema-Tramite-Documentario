package com.example.demo.Usuario;

import com.example.demo.Area.Area;
import com.example.demo.Area.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioAdapter adapter;
    private final AreaService areaService;

    public UsuarioServiceImpl(UsuarioRepository repository,
                              UsuarioAdapter adapter,
                              AreaService areaService) {
        this.repository = repository;
        this.adapter = adapter;
        this.areaService = areaService;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return repository.findAll()
                .stream()
                .map(adapter::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean registrarUsuario(Usuario usuario, String idArea) {
        Area area = areaService.buscarArea(idArea);

        if (!validarUsuario(usuario) || area == null) {
            return false;
        }

        usuario.setArea(area.getNombreArea());
        usuario.setActivo(true);

        repository.save(adapter.toEntity(usuario));
        return true;
    }

    @Override
    public Usuario obtenerUsuario(String idUsuario) {
        return repository.findById(idUsuario)
                .map(adapter::toModel)
                .orElse(null);
    }

    @Override
    public boolean editarUsuario(String idUsuario, Usuario form, String idArea) {
        Area area = areaService.buscarArea(idArea);

        if (!validarUsuario(form) || area == null) {
            return false;
        }

        return repository.findById(idUsuario)
                .map(entity -> {
                    entity.setNombre(form.getNombre());
                    entity.setCorreoElectronico(form.getCorreoElectronico());
                    entity.setPassword(form.getPassword());
                    entity.setArea(area.getNombreArea());
                    repository.save(entity);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public void toggleEstado(String idUsuario) {
        repository.findById(idUsuario).ifPresent(entity -> {
            entity.setActivo(!entity.isActivo());
            repository.save(entity);
        });
    }

    private boolean validarUsuario(Usuario u) {
        return !(u.getIdUsuario() == null || u.getIdUsuario().isBlank() ||
                u.getNombre() == null || u.getNombre().isBlank() ||
                u.getCorreoElectronico() == null || u.getCorreoElectronico().isBlank() ||
                u.getPassword() == null || u.getPassword().isBlank());
    }
}