<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
  <head>
    <title>Evaluación de Trámite</title>
    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/evaluacion.css" />
  </head>
  <body>

  <%@ include file="../barraLateral.jsp" %>

    <main>
      <header class="header-evaluacion">
        <h1>Evaluación del trámite</h1>
        <p>Nro. Trámite: ${tramite.nroTramite}</p>
      </header>

      <div class="contenedor-principal">

        <!-- DATOS -->
        <section class="datos-tramite">
          <div>
            <h4>Datos del Trámite</h4>

            <div>
              <strong>Tipo de Trámite</strong>
              <p>${tramite.tipoTramite.nombre}</p>
            </div>

            <div class="asunto-descripcion">
                <strong>Documentación mínima adjuntada</strong>

                <c:choose>

                    <c:when test="${not empty tramite.tipoTramite.documentacionMinima}">
                        <ul class="doc-minima-lista">

                            <c:forEach var="doc" items="${tramite.tipoTramite.documentacionMinima}">
                                <li class="doc-minima-item">
                                    <span>${doc.nombreDocumento}</span>
                                </li>
                            </c:forEach>

                        </ul>
                    </c:when>

                    <c:otherwise>
                        <p>No hay documentación mínima registrada.</p>
                    </c:otherwise>

                </c:choose>
            </div>

            <c:if test="${not empty mensaje}">
              <p style="color:red;">${mensaje}</p>
            </c:if>
          </div>

          <div>
            <h4>Datos del Interesado</h4>

            <div>
              <strong>Nombre Completo</strong>
              <p>${tramite.solicitante.nombreCompleto}</p>
            </div>

            <div>
              <strong>DNI/CE</strong>
              <p>${tramite.solicitante.idSolicitante}</p>
            </div>

            <div>
              <strong>Correo Electrónico</strong>
              <p>${tramite.solicitante.correoElectronico}</p>
            </div>

            <div>
              <strong>Teléfono de Contacto</strong>
              <p>${tramite.solicitante.telefonoContacto}</p>
            </div>
          </div>
        </section>

        <!-- FORM -->
        <form class="form-veredicto"
              action="/bandejaTrabajo/evaluar/${tramite.nroTramite}"
              method="post">

          <h2>Veredicto</h2>

          <h4>Checklist de Evaluación</h4>

          <div class="checklist-container">

            <div class="checklist-item">
              <label for="chk-dcompletos">Datos Completos</label>
              <input id="chk-dcompletos" type="checkbox" name="datosCompletos" ${datosCompletos ? 'checked' : ''} />
            </div>

            <div class="checklist-item">
              <label for="chk-dconsistentes">Datos Consistentes</label>
              <input id="chk-dconsistentes" type="checkbox" name="datosConsistentes" ${datosConsistentes ? 'checked' : ''} />
            </div>

            <div class="checklist-item">
              <label for="chk-crequisitos">Cumple requisitos del trámite</label>
              <input type="checkbox" name="cumpleRequisitos" ${cumpleRequisitos ? 'checked' : ''} />
            </div>

            <div class="checklist-item">
              <label for="chk-svalido">Sustento válido</label>
              <input id="chk-svalido" type="checkbox" name="sustentoValido" ${sustentoValido ? 'checked' : ''} />
            </div>

          </div>

          <label for="tarea-comentario">Comentario:</label>
          <textarea
            id="tarea-comentario"
            class="textarea-comentario"
            name="comentario"
            placeholder="Escriba un comentario..."
          >${comentario}</textarea>

          <button type="submit" name="accion" value="aprobar" class="btn btn-aprobar">
            Aprobar
          </button>

          <button type="submit" name="accion" value="rechazar" class="btn btn-rechazar">
            Rechazar
          </button>

        </form>

      </div>

    </main>
  </body>
</html>