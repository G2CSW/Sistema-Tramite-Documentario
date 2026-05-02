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
              <textarea class="textarea-descripcion" disabled>
${tramite.tipoTramite.documentacionMinima}
              </textarea>
            </div>
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
              <label>Datos Completos</label>
              <input type="checkbox" name="datosCompletos" />
            </div>

            <div class="checklist-item">
              <label>Datos Consistentes</label>
              <input type="checkbox" name="datosConsistentes" />
            </div>

            <div class="checklist-item">
              <label>Cumple requisitos del trámite</label>
              <input type="checkbox" name="cumpleRequisitos" />
            </div>

            <div class="checklist-item">
              <label>Sustento válido</label>
              <input type="checkbox" name="sustentoValido" />
            </div>

          </div>

          <label>Comentario:</label>
          <textarea
            class="textarea-comentario"
            name="comentario"
            placeholder="Escriba un comentario..."
          ></textarea>

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