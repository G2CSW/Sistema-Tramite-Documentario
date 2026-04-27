<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <p>
          Modifique los datos de ser necesario antes de la confirmar y derivar el trámite.
        </p>
      </header>

      <!-- INFO PRINCIPAL -->
       <section class="section-numero-tramite">
        <label>Número de trámite:</label>
        <input type="text" disabled value="123456" /> 
      </section>
      <section class="section">
        <h2>Datos del Solicitante</h2>
        <form class="form-datos-solicitante">
          <div>
            <label>Nombre Completo</label>
            <input class="input" type="text" placeholder="Nombre y Apellidos"  value="Juan Pérez"/>

          </div>

          <div>
            <label>DNI / RUC / CE</label>
            <input class="input" type="text" placeholder="0000000" value="12345678"/>
          </div>

          <div>
            <label>Correo Electrónico</label>
            <input class="input" type="text" placeholder="correo@gmail.com" value="juan@gmail.com" />
          </div>

          <div>
            <label>Teléfono de Contacto</label>
            <input class="input" type="text" placeholder="999999999" value="987654321" />
          </div>
        </form>
      </section>

      <section class="section">
        <h2>Detalles del Trámite</h2>
        <form class="form-detalles">
          <div>
            <label>Tipo de Trámite</label>
            <select class="select" name="tipo-tramite">
              <option value="certificado-de-estudio">Certificado de Estudio</option>
              <option value="convalidacion" selected>Convalidación</option>
              <option value="titulacion">Titulación</option>
            </select>
          </div>

          <div>
            <label>Documentación mínima requerida</label>
            <textarea
              class="textarea-descripcion"
              disabled
            >1. Formato Único Trámite
2. Copia de DNI</textarea>
          </div>
        </form>
      </section>

  

      <section class="section-acciones"> 
        <a href="tramites.html"><button class="btn btn-secondary">Cancelar</button></a>
        <button class="btn btn-primary"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-circle-check"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-1.293 5.953a1 1 0 0 0 -1.32 -.083l-.094 .083l-3.293 3.292l-1.293 -1.292l-.094 -.083a1 1 0 0 0 -1.403 1.403l.083 .094l2 2l.094 .083a1 1 0 0 0 1.226 0l.094 -.083l4 -4l.083 -.094a1 1 0 0 0 -.083 -1.32z" /></svg>Guardar Cambios</button>
      </section>
    </main>
  </body>
</html>
