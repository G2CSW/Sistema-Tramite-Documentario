<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Detalle Tipo Trámite</title>

    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/registrarTipoTramite.css" />
</head>

<body>
<%@ include file="../barraLateral.jsp" %>

<main>
    <header class="header-seguimiento">
        <h1>${tipo.nombre}</h1>
    </header>

    <section class="section">
        <div>
            <label>Nombre</label>
            <input class="input" type="text" value="${tipo.nombre}" disabled/>
        </div>

        <div>
            <label>Documentación</label>
            <textarea disabled>${tipo.documentacionMinima}</textarea>
        </div>
    </section>

    <section class="section-acciones">
        <a href="/tipoTramite/listar">
            <button class="btn btn-secondary">Volver</button>
        </a>
    </section>
</main>
</body>
</html>