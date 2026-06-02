<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Gestión</title>
    <link rel="stylesheet" href="../../css/global.css" />
    <link rel="stylesheet" href="../../css/gestion.css" />
</head>
<body>
<%@ include file="barraLateral.jsp" %>

<main>
    <header>
        <h1>GESTIÓN</h1>
    </header>

    <c:choose>
        <c:when test="${not empty sessionScope.usuario}">

            <section class="seccion-gestion">
                <c:if test="${sessionScope.usuario.area == 'Mesa de Partes' || sessionScope.usuario.area == 'Área de Evaluación'}">
                    <h2>Gestión de Trámites</h2>
                </c:if>

                <div class="targetas-gestion">
                    <c:if test="${sessionScope.usuario.area == 'Mesa de Partes'}">
                        <a href="/tramite/listar">Trámites</a>
                    </c:if>

                    <c:if test="${sessionScope.usuario.area == 'Área de Evaluación'}">
                        <a href="/bandejaTrabajo/listar">Bandeja de Trabajo</a>
                    </c:if>

                    <c:if test="${sessionScope.usuario.area == 'Mesa de Partes'}">
                        <a href="/archivados/listar">Archivados</a>
                    </c:if>
                </div>
            </section>

            <c:if test="${sessionScope.usuario.area == 'Admin' || sessionScope.usuario.area == 'Administrador'}">
                <section class="seccion-gestion">
                    <h2>Configuración</h2>
                    <div class="targetas-gestion">
                        <a href="/tipoTramite/listar">Tipos de Trámites</a>
                        <a href="/documento/listar">Documentos</a>
                        <a href="/usuario/listar">Usuarios</a>
                    </div>
                </section>

                <section class="seccion-gestion">
                    <h2>Estadísticas</h2>
                    <div class="targetas-gestion">
                        <a href="/metricas">Métricas</a>
                    </div>
                </section>
            </c:if>

        </c:when>

        <c:otherwise>
            <section class="seccion-gestion mensaje-sesion">
                <h2>Acceso restringido</h2>
                <p>
                    Inicia sesión para ver las funcionalidades de gestión disponibles según tu perfil de usuario.
                </p>
            </section>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>