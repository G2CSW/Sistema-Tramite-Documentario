<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Registrar Tipo Trámite</title>

    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/registrarTipoTramite.css" />
</head>

<body>
<%@ include file="../barraLateral.jsp" %>

<main>
    <header class="header-seguimiento">
        <h1>Registrar Tipo de Trámite</h1>
        <c:if test="${not empty error}">
            <p style="color:red;">${error}</p>
        </c:if>
    </header>

    <form class="formulario-tipo-tramite" action="/tipoTramite/registrar" method="post">

        <section class="section">
            <div>
                <label>Nombre</label>
                <input class="input" type="text" name="nombre"
                       value="${tipo.nombre}"
                       placeholder="Escriba aquí el nombre del tipo de trámite." required />
            </div>

            <div>
                <label>Documentación mínima requerida</label>

                <div style="display:flex; gap:8px; align-items:center;">
                    <select class="input" name="documentoId" style="flex:1;">
                        <option value="">-- Seleccione un documento --</option>
                        <c:forEach var="doc" items="${documentos}">
                            <option value="${doc.idDocumento}">${doc.nombreDocumento}</option>
                        </c:forEach>
                    </select>

                    <button type="submit"
                            class="btn btn-primary"
                            formaction="/tipoTramite/registrar/agregar">
                        Agregar
                    </button>
                </div>

                <ul class="doc-minima-lista">
                    <c:forEach var="doc" items="${tipo.documentacionMinima}">
                        <li class="doc-minima-item">
                            <span class="doc-minima-texto">${doc.nombreDocumento}</span>

                            <button type="submit"
                                    class="btn btn-secondary doc-minima-btn"
                                    formaction="/tipoTramite/registrar/quitar"
                                    name="quitarId"
                                    value="${doc.idDocumento}">
                                Eliminar
                            </button>

                            <input type="hidden" name="documentacionMinimaIds" value="${doc.idDocumento}">
                        </li>
                    </c:forEach>

                    <c:if test="${empty tipo.documentacionMinima}">
                        <li class="doc-minima-vacio">
                            Aún no agregó documentos.
                        </li>
                    </c:if>
                </ul>
            </div>
        </section>

        <section class="section-acciones">
            <a href="/tipoTramite/listar">
                <button type="button" class="btn btn-secondary">Cancelar</button>
            </a>

            <button type="submit" class="btn btn-primary">
                Registrar
            </button>
        </section>

    </form>
</main>
</body>
</html>