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
        <p>Nro. Trámite: 123456</p>
      </header>

      <div class="contenedor-principal">
        <!-- Vista Previa -->

      <section class="datos-tramite">
        <div>
          <h4>Datos del Trámite</h4>
          <div>
            <strong>Tipo de Trámite</strong>
            <p>Certificado de Estudio</p>
          </div>

          <div class="asunto-descripcion">
            <strong>Asunto / Descripción</strong>
            <textarea class="textarea-descripcion" disabled>Se ha adjuntado al trámite los siguientes documentos:
    1. Formato único de trámite.
    2. Certificado de estudios del semestre(s) a convalidar
    3. Copia del sílabo de las asignaturas a convalidar.
    4. Recibo de pago por los semestres estudiados.
            </textarea>
              
          </div>
        </div>

        <div>
          <h4>Datos del Interesado</h4>
          <div>
            <strong>Nombre Completo / Razón Social</strong>
            <p>Luis Enrique</p>
          </div>

          <div>
            <strong>DNI / RUC / CE</strong>
            <p>12345678</p>
          </div>

          <div>
            <strong>Correo Electrónico</strong>
            <p>luis@gmail.com</p>
          </div>

          <div>
            <strong>Teléfono de Contacto</strong>
            <p>987654321</p>
          </div>
        </div>
      </section>

        <!-- Panel Lateral -->
        <form class="form-veredicto">
          <h2>Veredicto</h2>

          <h4>Checklist de Evaluación</h4>
         <div class="checklist-container">
          <div class="checklist-item">
           <label for="datos-completos">Datos Completos</label>
            <input type="checkbox" id="datos-completos" name="datos-completos" />
         </div>
         <div class="checklist-item">
           <label for="datos-consistentes">Datos Consistentes</label>
            <input type="checkbox" id="datos-consistentes" name="datos-consistentes" />
         </div>
         <div class="checklist-item">
           <label for="cumple-requisitos">Cumple requisitos del trámite</label>
            <input type="checkbox" id="cumple-requisitos" name="cumple-requisitos" />
         </div>
         <div class="checklist-item">
           <label for="sustento-valido">Sustento válido</label>
            <input type="checkbox" id="sustento-valido" name="sustento-valido" />
         </div>
         </div>
         
              
          
          <label>Comentario:</label>
          <textarea
            class="textarea-comentario"
            placeholder=""
            disabled
          ></textarea>

          <button class="btn btn-aprobar">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="currentColor"
              class="icon icon-tabler icons-tabler-filled icon-tabler-circle-check"
            >
              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
              <path
                d="M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-1.293 5.953a1 1 0 0 0 -1.32 -.083l-.094 .083l-3.293 3.292l-1.293 -1.292l-.094 -.083a1 1 0 0 0 -1.403 1.403l.083 .094l2 2l.094 .083a1 1 0 0 0 1.226 0l.094 -.083l4 -4l.083 -.094a1 1 0 0 0 -.083 -1.32z"
              />
            </svg>
            Aprobar
          </button>
          <button class="btn btn-rechazar"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-xbox-x"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10s-10 -4.477 -10 -10s4.477 -10 10 -10m3.6 5.2a1 1 0 0 0 -1.4 .2l-2.2 2.933l-2.2 -2.933a1 1 0 1 0 -1.6 1.2l2.55 3.4l-2.55 3.4a1 1 0 1 0 1.6 1.2l2.2 -2.933l2.2 2.933a1 1 0 0 0 1.6 -1.2l-2.55 -3.4l2.55 -3.4a1 1 0 0 0 -.2 -1.4" /></svg> Rechazar</button>
        </form>
      </div>

    </main>

  </body>
</html>
