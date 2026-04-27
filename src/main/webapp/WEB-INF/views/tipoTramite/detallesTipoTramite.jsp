<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Editar Tipo Trámite</title>
    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/registrarTipoTramite.css" />
  </head>
  <body>
  <%@ include file="../barraLateral.jsp" %>
    <main>
      <header class="header-seguimiento">
        <h1>Trámite de Convalidación</h1>
      </header>

      <section class="section">
        <form class="form-datos-tipo-tramite">
          <div>
            <label>Nombre</label>
            <input class="input" type="text" value="Convalidación" disabled/>
          </div>

          <div>
            <label>Documentación Mínima</label>
            <textarea
              class="textarea-descripcion" disabled
            >1. Formato Único de Trámite
2. Copia DNI</textarea>
          </div>
        </form>
      </section> 

      <section class="section-acciones"> 
        <a href="tipoTramite.html"><button class="btn btn-secondary">Salir</button></a>
      </section>
    </main>
  </body>
</html>
