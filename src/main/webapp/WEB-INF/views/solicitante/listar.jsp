<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!doctype html>
    <html lang="es">

    <head>
      <meta charset="UTF-8" />
      <title>Lista de Solicitantes</title>
      <link rel="stylesheet" href="../../../css/global.css" />
      <link rel="stylesheet" href="../../../css/solicitantes.css" />
    </head>

    <body>

      <%@ include file="../barraLateral.jsp" %>

        <main>
          <header class="header-seguimiento">
            <h1>Gestión de Solicitantes</h1>
            <p>Listado y administración de los solicitantes registrados en el sistema.</p>
          </header>

          <c:if test="${not empty mensaje}">
            <div class="mensaje mensaje-exito" style="margin-bottom: 1rem;">
              ${mensaje}
            </div>
          </c:if>
          <c:if test="${not empty error}">
            <div class="mensaje mensaje-error" style="margin-bottom: 1rem;">
              ${error}
            </div>
          </c:if>

          <div class="acciones-header">
            <form action="/solicitante/listar" method="get" class="buscador-form">
              <label for="buscar-tramite"> Buscar por DNI / CE: </label>
              <div class="input-contenedor input-buscar-tramite-contenedor">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                  class="icon icon-tabler icons-tabler-outline icon-tabler-search">
                  <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                  <path d="M3 10a7 7 0 1 0 14 0a7 7 0 1 0 -14 0" />
                  <path d="M21 21l-6 -6" />
                </svg>
                <input id="buscar-tramite" type="search" name="dni" value="${dniBuscado}" placeholder="Ingrese DNI/CE"
                  class="input-buscar-tramite" />
              </div>
              <button type="submit" class="btn btn-primary">Buscar</button>
            </form>

            <a href="/solicitante/registrar" class="btn btn-primary">
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                class="icon icon-tabler icons-tabler-outline icon-tabler-plus">
                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                <path d="M12 5l0 14" />
                <path d="M5 12l14 0" />
              </svg>
              Nuevo Solicitante
            </a>
          </div>

          <div class="table-container">
            <table class="tbl">
              <thead>
                <tr>
                  <th>DNI / CE</th>
                  <th>Nombre Completo</th>
                  <th>Correo Electrónico</th>
                  <th>Teléfono</th>
                  <th style="text-align: center;">Acciones</th>
                </tr>
              </thead>
              <tbody>
                <c:choose>
                  <c:when test="${not empty solicitantes}">
                    <c:forEach var="s" items="${solicitantes}">
                      <tr>
                        <td>${s.idSolicitante}</td>
                        <td>${s.nombreCompleto}</td>
                        <td>${s.correoElectronico}</td>
                        <td>${s.telefonoContacto}</td>
                        <td style="text-align: center;">
                          <a href="/solicitante/editar?id=${s.idSolicitante}" class="btn btn-secondary"
                            style="padding: 0.5rem; display: inline-flex;">
                            <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24"
                              fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                              stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-pencil">
                              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                              <path d="M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4" />
                              <path d="M13.5 6.5l4 4" />
                            </svg>
                            Editar
                          </a>
                        </td>
                      </tr>
                    </c:forEach>
                  </c:when>
                  <c:otherwise>
                    <tr>
                      <td colspan="5" style="text-align: center; color: #6b7280; padding: 2rem;">
                        No se encontraron solicitantes registrados.
                      </td>
                    </tr>
                  </c:otherwise>
                </c:choose>
              </tbody>
            </table>
          </div>
        </main>
    </body>

    </html>