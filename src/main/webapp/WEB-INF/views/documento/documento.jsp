<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Documentos</title>

    <link rel="stylesheet" href="../../../css/global.css">
    <link rel="stylesheet" href="../../../css/documentos.css">
</head>

<body>

<%@ include file="../barraLateral.jsp" %>

<main>

<header class="header">
    <div class="header-titulos">
        <h1>Documentos</h1>
        <p>Vea y administre los documentos del sistema</p>
    </div>

    <a href="/documento/registrar">
        <button class="btn btn-primary btn-nuevo-documento">

            <svg xmlns="http://www.w3.org/2000/svg"
                 width="24"
                 height="24"
                 viewBox="0 0 24 24"
                 fill="none"
                 stroke="currentColor"
                 stroke-width="2"
                 stroke-linecap="round"
                 stroke-linejoin="round">

                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                <path d="M12 5l0 14"/>
                <path d="M5 12l14 0"/>
            </svg>

            Nuevo documento
        </button>
    </a>
</header>

<section class="documentos-list">

    <table class="tbl">

        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre Documento</th>
            <th>Estado</th>
            <th class="acciones-crud">Acciones</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="d" items="${documentos}">

            <tr>

                <td>${d.idDocumento}</td>

                <td>${d.nombreDocumento}</td>

                <td>
                    <c:choose>

                        <c:when test="${d.activo}">
                            Activo
                        </c:when>

                        <c:otherwise>
                            Inactivo
                        </c:otherwise>

                    </c:choose>
                </td>

                <td class="acciones-crud">

                    <!-- EDITAR -->
                    <a href="/documento/editar/${d.idDocumento}">
                        <button class="btn-icono" title="Editar">

                            <svg xmlns="http://www.w3.org/2000/svg"
                                 width="24"
                                 height="24"
                                 viewBox="0 0 24 24"
                                 fill="none"
                                 stroke="currentColor"
                                 stroke-width="2"
                                 stroke-linecap="round"
                                 stroke-linejoin="round">

                                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                <path d="M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4"/>
                                <path d="M13.5 6.5l4 4"/>

                            </svg>

                        </button>
                    </a>

                    <!-- TOGGLE -->
                    <form action="/documento/cambiar-estado/${d.idDocumento}"
                          method="post"
                          style="display:inline;">

                        <button type="submit"
                                class="btn-toggle ${d.activo ? 'activo' : 'inactivo'}"
                                title="Cambiar estado">

                            <svg xmlns="http://www.w3.org/2000/svg"
                                 width="24"
                                 height="24"
                                 fill="currentColor">

                                <path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10"/>

                                <circle cx="${d.activo ? '16' : '8'}"
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