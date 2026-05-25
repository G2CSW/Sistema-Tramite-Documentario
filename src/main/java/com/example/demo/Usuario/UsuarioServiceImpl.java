package com.example.demo.Usuario;

import com.example.demo.Area.Area;
import com.example.demo.Area.AreaService;
import com.example.demo.Datos.DatosMemoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final List<Usuario> usuarios = DatosMemoria.USUARIOS;
    private final AreaService areaService;

    public UsuarioServiceImpl(AreaService areaService) {
        this.areaService = areaService;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }



    @Override
    public boolean registrarUsuario(Usuario usuario, String idArea) {

        Area area = areaService.buscarArea(idArea);

        if (!validarUsuario(usuario) || area == null) {

            return false;
        }

        usuario.setArea(area.getNombreArea());
        usuario.setEstado(true);

        usuarios.add(usuario);

        return true;
    }

    @Override
    public Usuario obtenerUsuario(String idUsuario) {

        for (Usuario u : usuarios) {

            if (u.getIdUsuario().equals(idUsuario)) {

                return u;
            }
        }

        return null;
    }

    @Override
    public boolean editarUsuario(String idUsuario,
                                 Usuario form,
                                 String idArea) {

        Area area = areaService.buscarArea(idArea);

        if (!validarUsuario(form) || area == null) {

            return false;
        }

        for (Usuario u : usuarios) {

            if (u.getIdUsuario().equals(idUsuario)) {

                u.setNombre(form.getNombre());
                u.setCorreoElectronico(form.getCorreoElectronico());
                u.setPassword(form.getPassword());
                u.setArea(area.getNombreArea());

                return true;
            }
        }

        return false;
    }

    @Override
    public void toggleEstado(String idUsuario) {

        for (Usuario u : usuarios) {

            if (u.getIdUsuario().equals(idUsuario)) {

                u.setEstado(!u.getEstado());

                break;
            }
        }
    }

    private boolean validarUsuario(Usuario u) {

        return !(u.getIdUsuario() == null || u.getIdUsuario().isBlank() ||
                u.getNombre() == null || u.getNombre().isBlank() ||
                u.getCorreoElectronico() == null || u.getCorreoElectronico().isBlank() ||
                u.getPassword() == null || u.getPassword().isBlank());
    }


}