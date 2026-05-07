<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Editar Documento</title>

    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/documentos.css" />
</head>

<body>

<%@ include file="../barraLateral.jsp" %>

<main>

    <header class="header-form-documento">
        <h1>Editar Documento</h1>

        <c:if test="${not empty error}">
            <p class="mensaje-error">${error}</p>
        </c:if>
    </header>

    <form class="form-documento"
          action="/documento/editar/${documento.idDocumento}"
          method="post">

        <section class="section-documento">

            <div>
                <label>Nombre del documento</label>

                <input class="input"
                       type="text"
                       name="nombreDocumento"
                       value="${documento.nombreDocumento}"
                       required />
            </div>

        </section>

        <section class="section-acciones">

            <a href="/documento/listar" class="btn btn-secondary">
               Cancelar
            </a>

            <button type="submit" class="btn btn-primary">
                Guardar Cambios
            </button>

        </section>

    </form>

</main>

</body>
</html>