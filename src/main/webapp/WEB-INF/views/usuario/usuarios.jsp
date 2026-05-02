<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Usuarios</title>

    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/usuarios.css" />
  </head>
  <body>
  <%@ include file="../barraLateral.jsp" %>
    <main>
      <header class="header">
        <div>
          <h1>Usuarios</h1>
          <p>Administra los usuarios con acceso al sistema de trámite documentario</p>
        </div>
          <a href="/usuario/registrar">
            <button class="btn btn-primary btn-nuevo-usuario">
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
              class="icon icon-tabler icons-tabler-outline icon-tabler-plus"
            >
              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
              <path d="M12 5l0 14" />
              <path d="M5 12l14 0" /></svg
            >Nuevo Usuario
          </button>
          </a>
        </div>
      </header>

      <section class="table-container">
          <table class="tbl">
            <thead>
              <tr>
                <th>Documento de Identidad</th>
                <th>Nombre Completo</th>
                <th>Correo Electrónico</th>
                <th>Área</th>
                <th class="acciones-crud">Acciones</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${usuarios}">
              <tr>
                <td>${u.idUsuario}</td>
                <td class="nombre-usuario">${u.nombre}</td>
                <td>${u.correoElectronico}</td>
                <td>${u.area.nombreArea}</td>

                <td class="acciones-crud">

                  <!-- EDITAR -->
                  <a href="/usuario/editar/${u.idUsuario}">
                    <button title="Editar" class="btn-icono btn-accion-editar">
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
                        class="icon icon-tabler icons-tabler-outline icon-tabler-pencil"
                      >
                        <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                        <path
                          d="M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4"
                        />
                        <path d="M13.5 6.5l4 4" />
                      </svg>
                    </button>
                  </a>

                  <!-- ACTIVO / INACTIVO -->
                  <form action="/usuario/toggle/${u.idUsuario}" method="post" style="display:inline;">

                    <c:choose>

                      <c:when test="${u.estado}">
                        <button title="Activo" class="btn-icono btn-accion-activo">
                          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                               viewBox="0 0 24 24" fill="currentColor"
                               class="icon icon-tabler icons-tabler-filled icon-tabler-toggle-right">
                            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                            <path d="M16 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824" />
                            <path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10" />
                          </svg>
                        </button>
                      </c:when>
                      <c:otherwise>
                        <button title="Inactivo" class="btn-icono btn-accion-inactivo">
                          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                               viewBox="0 0 24 24" fill="currentColor"
                               class="icon icon-tabler icons-tabler-filled icon-tabler-toggle-left">
                            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                            <path d="M8 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824" />
                            <path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10" />
                          </svg>
                        </button>
                      </c:otherwise>

                    </c:choose>

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
