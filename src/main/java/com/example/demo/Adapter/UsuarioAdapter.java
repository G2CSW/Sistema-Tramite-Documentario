package com.example.demo.Adapter;

import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAdapter {

    public UsuarioEntity toEntity(Usuario usuario) {
        if (usuario == null) return null;
        UsuarioEntity entity = new UsuarioEntity();
        entity.setIdUsuario(usuario.getIdUsuario());
        entity.setNombre(usuario.getNombre());
        entity.setCorreoElectronico(usuario.getCorreoElectronico());
        entity.setPassword(usuario.getPassword());
        entity.setArea(usuario.getArea());
        entity.setActivo(usuario.getEstado());
        return entity;
    }

    public Usuario toModel(UsuarioEntity entity) {
        if (entity == null) return null;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(entity.getIdUsuario());
        usuario.setNombre(entity.getNombre());
        usuario.setCorreoElectronico(entity.getCorreoElectronico());
        usuario.setPassword(entity.getPassword());
        usuario.setArea(entity.getArea());
        usuario.setEstado(entity.isActivo());
        return usuario;
    }
}
