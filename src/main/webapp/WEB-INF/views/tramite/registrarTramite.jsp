<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Registrar Trámite</title>
    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/registrarTramite.css" />
  </head>
  <body>

    <%@ include file="../barraLateral.jsp" %>

    <main>
      <header class="header-seguimiento">
        <h1>Registrar Nuevo Trámite</h1>
        <p>Ingrese los datos para registrar una nueva solicitud en el sistema.</p>
      </header>

      <form action="/tramite/registrar" method="post" class="form-registro-tramite">
        <section class="section-numero-tramite">
          <label>Número de trámite:</label>
          <input type="text" disabled value="${numeroTramiteGenerado}" placeholder="#autogenerado" />
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
              <label for="idSolicitante">DNI/CE</label>
              <div class="buscar-idSolicitante">
                <input
                  id="idSolicitante"
                  class="input"
                  type="text"
                  name="solicitante.idSolicitante"
                  value="${solicitante.idSolicitante}"
                  placeholder="00000000"
                />
                <button
                  type="submit"
                  formmethod="get"
                  class="btn btn-primary"
                >
                  Buscar DNI/CE
                </button>
                 <c:if test="${not empty idSolicitanteBuscado}">
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
                placeholder="Nombre y Apellidos"
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
                placeholder="correo@gmail.com"
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
                placeholder="999999999"
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
                        <option value="${tipo.idTipoTramite}" selected="selected">
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

                <button
                  type="submit"
                  formmethod="get"
                  class="btn btn-primary"
                >
                  Cargar documentación
                </button>
              </div>
            </div>

            <div>
              <label>Documentación mínima requerida</label>
              <textarea class="textarea-descripcion" readonly><c:choose>
<c:when test="${not empty tipoSeleccionado.documentacionMinima}">
${tipoSeleccionado.documentacionMinima}
</c:when>
<c:otherwise>
Seleccione un tipo de trámite y presione "Cargar documentación".
</c:otherwise></c:choose></textarea>
            </div>
          </div>
        </section>

        <section class="section-acciones">
          <a href="/tramite/listar" class="btn btn-secondary">
            Cancelar
          </a>

          <button type="submit" class="btn btn-primary">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-circle-check">
              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
              <path d="M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-1.293 5.953a1 1 0 0 0 -1.32 -.083l-.094 .083l-3.293 3.292l-1.293 -1.292l-.094 -.083a1 1 0 0 0 -1.403 1.403l.083 .094l2 2l.094 .083a1 1 0 0 0 1.226 0l.094 -.083l4 -4l.083 -.094a1 1 0 0 0 -.083 -1.32z" />
            </svg>
            Registrar Trámite
          </button>
        </section>
      </form>
    </main>
  </body>
</html>