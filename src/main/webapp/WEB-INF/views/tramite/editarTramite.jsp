<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Editar Trámite</title>
    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/registrarTramite.css" />
  </head>
  <body>

    <%@ include file="../barraLateral.jsp" %>

    <main>
      <header class="header-seguimiento">
        <h1>Editar Trámite</h1>
        <p>Modifique los datos antes de guardar los cambios.</p>
      </header>

      <!-- IMPORTANTE: action cambia -->
      <form action="/tramite/editar/${numeroTramiteGenerado}"
            method="post"
            class="form-registro-tramite">

        <section class="section-numero-tramite">
          <label>Número de trámite:</label>
          <input type="text" disabled value="${numeroTramiteGenerado}" />

          <c:if test="${not empty error}">
              <div class="mensaje mensaje-error">
                  ERROR: ${error}
              </div>
          </c:if>
        </section>

        <section class="section">
          <h2>Datos del Solicitante</h2>

          <div class="form-datos-solicitante">
            <div>
              <label for="dni">DNI</label>
              <div class="buscar-dni">
                <input
                  id="dni"
                  class="input"
                  type="text"
                  name="solicitante.dni"
                  value="${solicitante.dni}"
                  placeholder="00000000"
                />

                <!-- MISMO BOTÓN QUE REGISTRAR -->
                <button
                  type="submit"
                  formmethod="get"
                  formaction="/tramite/editar/${numeroTramiteGenerado}"
                  class="btn btn-primary"
                >
                  Buscar DNI
                </button>

                <c:if test="${not empty dniBuscado}">
                  <c:choose>
                      <c:when test="${existeSolicitante}">
                          <div class="mensaje mensaje-exito">
                              Solicitante ya en el sistema
                          </div>
                      </c:when>
                      <c:otherwise>
                          <div class="mensaje mensaje-info">
                              Nuevo solicitante
                          </div>
                      </c:otherwise>
                  </c:choose>
                </c:if>

              </div>
            </div>

            <div>
              <label for="nombreCompleto">Nombre Completo</label>
              <input
                id="nombreCompleto"
                class="input"
                type="text"
                name="solicitante.nombreCompleto"
                value="${solicitante.nombreCompleto}"
              />
            </div>

            <div>
              <label for="correoElectronico">Correo Electrónico</label>
              <input
                id="correoElectronico"
                class="input"
                type="text"
                name="solicitante.correoElectronico"
                value="${solicitante.correoElectronico}"
              />
            </div>

            <div>
              <label for="telefonoContacto">Teléfono de Contacto</label>
              <input
                id="telefonoContacto"
                class="input"
                type="text"
                name="solicitante.telefonoContacto"
                value="${solicitante.telefonoContacto}"
              />
            </div>
          </div>
        </section>

        <section class="section">
          <h2>Detalles del Trámite</h2>

          <div class="form-detalles">
            <div>
              <label for="tipoTramite">Tipo de Trámite</label>

              <div class="buscar-documentacion-contenedor">
                <select
                  id="tipoTramite"
                  class="select"
                  name="tipoTramite.idTipoTramite"
                >
                  <c:forEach var="tipo" items="${tipoTramites}">
                    <c:choose>
                      <c:when test="${tipo.idTipoTramite eq tipoTramiteId}">
                        <option value="${tipo.idTipoTramite}" selected>
                          ${tipo.nombre}
                        </option>
                      </c:when>
                      <c:otherwise>
                        <option value="${tipo.idTipoTramite}">
                          ${tipo.nombre}
                        </option>
                      </c:otherwise>
                    </c:choose>
                  </c:forEach>
                </select>

                <!-- MISMO BOTÓN -->
                <button
                  type="submit"
                  formmethod="get"
                  formaction="/tramite/editar/${numeroTramiteGenerado}"
                  class="btn btn-primary"
                >
                  Cargar documentación
                </button>
              </div>
            </div>

            <div>
              <label>Documentación mínima requerida</label>
              <textarea class="textarea-descripcion" readonly>
<c:choose>
<c:when test="${not empty tipoSeleccionado.documentacionMinima}">
${tipoSeleccionado.documentacionMinima}
</c:when>
<c:otherwise>
Seleccione un tipo de trámite y presione "Cargar documentación".
</c:otherwise>
</c:choose>
              </textarea>
            </div>
          </div>
        </section>

        <section class="section-acciones">
          <a href="/tramite/listar" class="btn btn-secondary">
            Cancelar
          </a>

          <!-- TEXTO CAMBIA -->
          <button type="submit" class="btn btn-primary">
            Guardar Cambios
          </button>
        </section>

      </form>
    </main>
  </body>
</html>