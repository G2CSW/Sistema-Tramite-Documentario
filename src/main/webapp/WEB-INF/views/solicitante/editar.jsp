<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!doctype html>
    <html lang="es">

    <head>
      <meta charset="UTF-8" />
      <title>Editar Solicitante</title>
      <link rel="stylesheet" href="../../../css/global.css" />
      <link rel="stylesheet" href="../../../css/solicitantes.css" />
    </head>

    <body>

      <%@ include file="../barraLateral.jsp" %>

        <main>
          <header class="header-seguimiento">
            <h1>Editar Solicitante</h1>
            <p>Modifique los datos del solicitante en el sistema.</p>
          </header>

          <form action="/solicitante/editar" method="post" class="form-registro-solicitante">

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
                    value="${solicitante.idSolicitante}" placeholder="00000000" readonly
                    style="background-color: #f3f4f6; cursor: not-allowed;" />
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
                  class="icon icon-tabler icons-tabler-filled icon-tabler-device-floppy">
                  <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                  <path
                    d="M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm-3 12h-6a1 1 0 0 0 -.993 .883l-.007 .117v2h8v-2a1 1 0 0 0 -1 -1zm0 -10h-6a1 1 0 0 0 -1 1v4a1 1 0 0 0 1 1h6a1 1 0 0 0 1 -1v-4a1 1 0 0 0 -1 -1z" />
                </svg>
                Guardar Cambios
              </button>
            </section>
          </form>
        </main>
    </body>

    </html>