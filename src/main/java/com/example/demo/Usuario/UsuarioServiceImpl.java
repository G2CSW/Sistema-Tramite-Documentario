package com.example.demo.Usuario;

import com.example.demo.Area.Area;
import com.example.demo.Area.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDAO usuarioDAO;
    private final AreaService areaService;

    public UsuarioServiceImpl(UsuarioDAO usuarioDAO,
                              AreaService areaService) {
        this.usuarioDAO = usuarioDAO;
        this.areaService = areaService;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarTodos()
                .stream()
                .filter(e -> !"admin".equals(e.getIdUsuario()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean registrarUsuario(Usuario usuario, String idArea) {

        Area area = areaService.buscarArea(idArea);

        if (!validarUsuario(usuario) || area == null) {
            return false;
        }

        if (usuarioDAO.existePorId(usuario.getIdUsuario())) {
            return false;
        }

        usuario.setArea(area.getNombreArea());
        usuario.setActivo(true);

        usuarioDAO.guardar(usuario);

        return true;
    }

    @Override
    public Usuario obtenerUsuario(String idUsuario) {
        return usuarioDAO.buscarPorId(idUsuario);
    }

    @Override
    public boolean existeUsuario(String idUsuario) {
        return usuarioDAO.existePorId(idUsuario);
    }

    @Override
    public boolean editarUsuario(String idUsuario, Usuario form, String idArea) {
        Area area = areaService.buscarArea(idArea);

        if (!validarUsuario(form) || area == null) {
            return false;
        }

        Usuario modelo = usuarioDAO.buscarPorId(idUsuario);
        if (modelo != null) {
            modelo.setNombre(form.getNombre());
            modelo.setCorreoElectronico(form.getCorreoElectronico());
            modelo.setPassword(form.getPassword());
            modelo.setArea(area.getNombreArea());
            usuarioDAO.guardar(modelo);
            return true;
        }
        return false;
    }

    @Override
    public void toggleEstado(String idUsuario) {
        Usuario modelo = usuarioDAO.buscarPorId(idUsuario);
        if (modelo != null) {
            modelo.setActivo(!modelo.isActivo());
            usuarioDAO.guardar(modelo);
        }
    }

    private boolean validarUsuario(Usuario u) {
        if (u == null) {
            return false;
        }

        String idUsuario = u.getIdUsuario();

        boolean idValido = idUsuario != null
                && !idUsuario.isBlank()
                && idUsuario.matches("\\d{8,9}");

        boolean nombreValido = u.getNombre() != null && !u.getNombre().isBlank();
        boolean correoValido = u.getCorreoElectronico() != null && !u.getCorreoElectronico().isBlank();
        boolean passwordValida = u.getPassword() != null && !u.getPassword().isBlank();

        return idValido && nombreValido && correoValido && passwordValida;
    }
}
