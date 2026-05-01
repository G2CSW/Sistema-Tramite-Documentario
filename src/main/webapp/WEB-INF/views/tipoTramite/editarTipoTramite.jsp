<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Editar Tipo Trámite</title>

    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/registrarTipoTramite.css" />
</head>

<body>
<%@ include file="../barraLateral.jsp" %>

<main>
    <header class="header-seguimiento">
        <h1>Editar Tipo de Trámite</h1>
        <c:if test="${not empty error}">
            <p style="color:red;">${error}</p>
        </c:if>
    </header>

    <form class="formulario-tipo-tramite" action="/tipoTramite/editar/${tipo.idTipoTramite}" method="post">

        <section class="section">
            <div>
                <label>Nombre</label>
                <input class="input" type="text" name="nombre" value="${tipo.nombre}" required/>
            </div>

            <div>
                <label>Documentación mínima requerida</label>
                <textarea class="textarea-descripcion" name="documentacionMinima" required>${tipo.documentacionMinima}</textarea>
            </div>
        </section>

        <section class="section-acciones">
            <a href="/tipoTramite/listar">
                <button type="button" class="btn btn-secondary">Cancelar</button>
            </a>

            <button type="submit" class="btn btn-primary">
                Guardar Cambios
            </button>
        </section>

    </form>
</main>
</body>
</html>