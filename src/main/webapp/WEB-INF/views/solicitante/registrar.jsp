<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!doctype html>
    <html lang="es">

    <head>
      <meta charset="UTF-8" />
      <title>Registrar Solicitante</title>
      <link rel="stylesheet" href="../../../css/global.css" />
      <link rel="stylesheet" href="../../../css/solicitantes.css" />
    </head>

    <body>

      <%@ include file="../barraLateral.jsp" %>

        <main>
          <header class="header-seguimiento">
            <h1>Registrar Nuevo Solicitante</h1>
            <p>Ingrese los datos para registrar un nuevo solicitante en el sistema.</p>
          </header>

          <form action="/solicitante/registrar" method="post" class="form-registro-solicitante">

            <c:if test="${not empty error}">
              <div class="mensaje mensaje-error" style="margin-bottom: 1rem;">
                ERROR: ${error}
              </div>
            </c:if>

            <section class="section">
              <h2>Datos del Solicitante</h2>

              <div class="form-datos-solicitante">
                <div>
                  <label for="idSolicitante">DNI / CE</label>
                  <input id="idSolicitante" class="input" type="text" name="idSolicitante"
                    value="${solicitante.idSolicitante}" placeholder="00000000" required />
                </div>

                <div>
                  <label for="nombreCompleto">Nombre Completo</label>
                  <input id="nombreCompleto" class="input" type="text" name="nombreCompleto"
                    value="${solicitante.nombreCompleto}" placeholder="Nombre y Apellidos" required />
                </div>

                <div>
                  <label for="correoElectronico">Correo Electrónico</label>
                  <input id="correoElectronico" class="input" type="email" name="correoElectronico"
                    value="${solicitante.correoElectronico}" placeholder="correo@gmail.com" required />
                </div>

                <div>
                  <label for="telefonoContacto">Teléfono de Contacto</label>
                  <input id="telefonoContacto" class="input" type="text" name="telefonoContacto"
                    value="${solicitante.telefonoContacto}" placeholder="999999999" required />
                </div>
              </div>
            </section>

            <section class="section-acciones">
              <a href="/solicitante/listar" class="btn btn-secondary">
                Cancelar
              </a>

              <button type="submit" class="btn btn-primary">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor"
                  class="icon icon-tabler icons-tabler-filled icon-tabler-circle-check">
                  <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                  <path
                    d="M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-1.293 5.953a1 1 0 0 0 -1.32 -.083l-.094 .083l-3.293 3.292l-1.293 -1.292l-.094 -.083a1 1 0 0 0 -1.403 1.403l.083 .094l2 2l.094 .083a1 1 0 0 0 1.226 0l.094 -.083l4 -4l.083 -.094a1 1 0 0 0 -.083 -1.32z" />
                </svg>
                Registrar Solicitante
              </button>
            </section>
          </form>
        </main>
    </body>

    </html>