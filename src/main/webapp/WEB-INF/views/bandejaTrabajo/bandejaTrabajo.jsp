<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Bandeja de Trabajo - Área Académica</title>
    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/bandejaTrabajo.css" />
  </head>
  <body>
  <%@ include file="../barraLateral.jsp" %>
    <main>
      <header class="header-bandeja">
        <h1>Bandeja de Trabajo - Área Académica</h1>
        <p class="subtitle">
          Gestione los trámites pendientes de recepción y evaluación.
        </p>
      </header>

      <section class="filtros-section">
        <h3>Trámites por revisar</h3>
        <form action="${pageContext.request.contextPath}/bandejaTrabajo/listar" method="get" class="input-contenedor input-buscar-tramite-contenedor">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            class="icon icon-tabler icons-tabler-outline icon-tabler-search"
          >
            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
            <path d="M3 10a7 7 0 1 0 14 0a7 7 0 1 0 -14 0" />
            <path d="M21 21l-6 -6" />
          </svg>
          <input
            type="search"
            name="dni"
            placeholder="Buscar Trámite"
            class="input-buscar-tramite"
            value="${param.dni}"
          />
        </form>
      </section>

      <table class="tbl">
        <thead>
          <tr>
            <th>NRO. TRÁMITE</th>
            <th>TIPO DE TRÁMITE</th>
            <th>ID SOLICITANTE</th>
            <th>FECHA INGRESO</th>
            <th>ACCIÓN</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="tramite" items="${tramites}">
            <tr>
              <td>${tramite.nroTramite}</td>
              <td>${tramite.tipoTramite.nombre}</td>
              <td>${tramite.solicitante.dni}</td>
              <td>${tramite.fechaRegistro}</td>

              <td class="acciones">
                <a href="/bandejaTrabajo/evaluar/${tramite.nroTramite}">
                  <button class="btn btn-evaluar">Evaluar</button>
                </a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </main>
  </body>
</html>
