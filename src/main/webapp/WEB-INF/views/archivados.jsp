<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Trámites Archivados</title>

    <link rel="stylesheet" href="../../css/global.css" />
    <link rel="stylesheet" href="../../css/archivados.css" />

  </head>
  <body>
    <%@ include file="barraLateral.jsp" %>

    <main>
      <header class="header">
        <div class="header-titulos">
          <h1>Trámites Archivados</h1>
          <p>
            Vea y administre los trámites que ya han sido archivados.
          </p>
        </div>
      </header>

        <form method="get" action="/archivados/listar" class="filtros-section">
          <div class="input-contenedor input-buscar-tramite-contenedor">
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
              name="idSolicitante"
              value="${idSolicitanteBuscado}"
              placeholder="Buscar por ID solicitante"
              class="input-buscar-tramite"
            />
          </div>

          <button class="btn btn-primary" type="submit">Buscar</button>
        </form>

      <section class="tramites-list">
        <table class="tbl">
          <thead>
            <th>NRO. TRÁMITE</th>
            <th>TIPO TRÁMITE.</th>
            <th>ID SOLICITANTE</th>
            <th>FECHA FINALIZACIÓN</th>
            <th>ESTADO FINAL</th>
            <th class="acciones-crud">Acciones</th>
          </thead>

          <tbody>
            <c:forEach var="t" items="${tramites}">
              <tr>
                <td>${t.nroTramite}</td>

                <td>${t.tipoTramite.nombre}</td>

                <td>${t.solicitante.idSolicitante}</td>

                <td>${t.fechaRegistro}</td>

                <td>
                  <c:choose>
                    <c:when test="${t.estadoActual == 'ARCHIVADO'}">
                      <span class="badge-estado estado-archivado">Archivado</span>
                    </c:when>
                    <c:otherwise>
                      <span class="badge-estado estado-cancelado">Cancelado</span>
                    </c:otherwise>
                  </c:choose>
                </td>

                <td class="acciones-crud">
                  <a href="/tramite/${t.nroTramite}">
                    <button title="Ver Estado" class="btn-icono">
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
                        class="icon icon-tabler icons-tabler-outline icon-tabler-eye"
                      >
                        <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                        <path d="M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                        <path
                          d="M21 12c-2.4 4 -5.4 6 -9 6c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6"
                        />
                      </svg>
                    </button>
                  </a>
                </td>
              </tr>
            </c:forEach>


            <c:if test="${empty tramites}">
              <tr>
                <td colspan="6" style="text-align:center;">
                  No hay trámites archivados o cancelados
                </td>
              </tr>
            </c:if>
          </tbody>
        </table>
      </section>
    </main>
  </body>
</html>