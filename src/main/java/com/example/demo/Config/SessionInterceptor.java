package com.example.demo.Config;

import com.example.demo.Usuario.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String path = request.getRequestURI();

        // Rutas públicas (incluye login, estáticos, index, gestion, contacto)
        if (path.equals("/") || 
            path.startsWith("/gestion") || 
            path.startsWith("/contacto") || 
            path.startsWith("/publicidad") || 
            path.startsWith("/login") || 
            path.startsWith("/logout") || 
            path.startsWith("/css") || 
            path.startsWith("/js") || 
            path.startsWith("/images") || 
            path.startsWith("/h2-console")) {
            return true;
        }

        HttpSession session = request.getSession(false);
        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuario") : null;

        if (usuario == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        String area = usuario.getArea();

        // Control de Acceso basado en el Área
        if ((path.startsWith("/tramite") || path.startsWith("/archivados")) && !"Mesa de Partes".equals(area)) {
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }

        if (path.startsWith("/bandejaTrabajo") && !"Área de Evaluación".equals(area)) {
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }

        if ((path.startsWith("/tipoTramite") || path.startsWith("/documento") || path.startsWith("/usuario") || path.startsWith("/metricas")) 
             && !("Admin".equals(area) || "Administrador".equals(area))) {
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }

        return true;
    }
}
