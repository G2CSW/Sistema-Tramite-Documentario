<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Tipos de Trámite</title>

<link rel="stylesheet" href="../../../css/global.css">
<link rel="stylesheet" href="../../../css/tiposTramites.css">

</head>

<body>

<%@ include file="../barraLateral.jsp" %>

<main>

<header class="header">
    <div class="header-titulos">
        <h1>Tipos de Trámite</h1>
        <p>Vea y administre los tipos de trámites</p>
    </div>

    <a href="/tipoTramite/registrar">
        <button class="btn btn-primary btn-nuevo-doc">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                 viewBox="0 0 24 24" fill="none" stroke="currentColor"
                 stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                <path d="M12 5l0 14"/>
                <path d="M5 12l14 0"/>
            </svg>
            Nuevo tipo de trámite
        </button>
    </a>
</header>

<section class="tramites-list">
    <table class="tbl">

        <thead>
            <tr>
                <th>Nombre</th>
                <th>FECHA CREACIÓN</th>
                <th class="acciones-crud">Acciones</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="t" items="${tipos}">
                <tr>

                    <td>${t.nombre}</td>

                    <td>${t.fechaCreacion}</td>

                    <td class="acciones-crud">

                        <!-- VER -->
                        <a href="/tipoTramite/detalle/${t.idTipoTramite}">
                            <button class="btn-icono" title="Ver">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                     viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                     stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                    <path d="M10 12a2 2 0 1 0 4 0"/>
                                    <path d="M21 12c-2.4 4 -5.4 6 -9 6c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6"/>
                                </svg>
                            </button>
                        </a>

                        <!-- EDITAR -->
                        <a href="/tipoTramite/editar/${t.idTipoTramite}">
                            <button class="btn-icono" title="Editar">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                     viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                     stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                    <path d="M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4"/>
                                    <path d="M13.5 6.5l4 4"/>
                                </svg>
                            </button>
                        </a>

                        <!-- TOGGLE -->
                        <form action="${pageContext.request.contextPath}/tipoTramite/cambiar-estado/${t.idTipoTramite}"
                              method="post"
                              style="display:inline;">

                            <input type="hidden" name="activo" value="${!t.activo}" />

                            <button type="submit"
                                    class="btn-toggle ${t.activo ? 'activo' : 'inactivo'}"
                                    title="Cambiar estado">

                                <svg xmlns="http://www.w3.org/2000/svg"
                                     width="24"
                                     height="24"
                                     fill="currentColor">

                                    <path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10"/>

                                    <circle cx="${t.activo ? '16' : '8'}"
                                            cy="12"
                                            r="3"/>
                                </svg>

                            </button>
                        </form>

                    </td>

                </tr>
            </c:forEach>
        </tbody>

    </table>
</section>

</main>

</body>
</html>