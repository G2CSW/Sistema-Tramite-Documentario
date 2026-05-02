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

        <h3>Trámites por revisar</h3>
      <table class="tbl">
        <thead>
          <tr>
            <th>NRO. TRÁMITE</th>
            <th>TIPO DE TRÁMITE</th>
            <th>ID SOLICITANTE</th>
            <th>NOMBRE SOLICITANTE</th>
            <th>FECHA INGRESO</th>
            <th>ACCIÓN</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="tramite" items="${tramites}">
            <tr>
              <td>${tramite.nroTramite}</td>
              <td>${tramite.tipoTramite.nombre}</td>
              <td>${tramite.solicitante.idSolicitante}</td>
              <td>${tramite.solicitante.nombreCompleto}</td>
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
