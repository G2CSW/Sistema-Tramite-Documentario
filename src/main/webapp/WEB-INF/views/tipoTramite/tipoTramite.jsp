<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tipos de Trámites</title>

    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/tiposTramites.css" />

  </head>
  <body>

  <%@ include file="../barraLateral.jsp" %>
    <main>
      <header class="header" id="header">
        <div class="header-titulos">
          <h1>Tipos de Trámite</h1>
          <p>
            Vea y administre los tipos de trámites
          </p>
        </div>
        <a href="registrarTipoTramite.html" >
          <button class="btn btn-primary btn-nuevo-doc">
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
          >Nuevo tipo de trámite
        </button>
        </a>
      </header>
      <section class="filtros-section">
        <div class="input-contenedor input-buscar-tramite-contenedor">
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
            class="icon icon-tabler icons-tabler-outline icon-tabler-search"
          >
            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
            <path d="M3 10a7 7 0 1 0 14 0a7 7 0 1 0 -14 0" />
            <path d="M21 21l-6 -6" />
          </svg>
          <input
            type="search"
            placeholder="Buscar tipo de trámite"
            class="input-buscar-tramite"
          />
        </div>       
      </section>

      <section class="tramites-list">
        <table class="tbl">
          <thead>
            <th>Nombre</th>
            <th>FECHA CREACIÓN</th>
            <th class="acciones-crud" >Acciones</th>
          </thead>
          <tbody>
            <tr>
              <td>Licencia de Estudio</td>
              <td>14/04/2026</td>
              <td class="acciones-crud">
                 <a href="detallesTipoTramite.html" >
                <button title="Ver Detalles" class="btn-icono">
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
                    class="icon icon-tabler icons-tabler-outline icon-tabler-eye"
                  >
                    <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                    <path d="M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                    <path
                      d="M21 12c-2.4 4 -5.4 6 -9 6c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6"
                    />
                  </svg>
                </button></a>
                <a href="editarTipoTramite.html" >
                <button title="Editar Tipo" class="btn-icono">
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
                <button title="Inactivo" class="btn-icono btn-accion-inactivo">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-toggle-left"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M8 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824" /><path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10" /></svg>
                </button>
              </td>
            </tr>
            <tr>
              <td>Convalidación</td>
              <td>10/04/2026</td>
               <td class="acciones-crud">
                 <a href="detallesTipoTramite.html" >
                <button title="Ver Detalles" class="btn-icono">
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
                    class="icon icon-tabler icons-tabler-outline icon-tabler-eye"
                  >
                    <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                    <path d="M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                    <path
                      d="M21 12c-2.4 4 -5.4 6 -9 6c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6"
                    />
                  </svg>
                </button></a>
                <a href="editarTipoTramite.html" >
                <button title="Editar Tipo" class="btn-icono">
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
                <button title="Activo" class="btn-icono btn-accion-activo">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-toggle-right"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M16 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824" /><path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10" /></svg>
                </button>
                
              </td>
            </tr>

            <tr>
              <td>Certificado de Estudio</td>
              <td>08/04/2026</td>
               <td class="acciones-crud">
                 <a href="detallesTipoTramite.html" >
                <button title="Ver Detalles" class="btn-icono">
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
                    class="icon icon-tabler icons-tabler-outline icon-tabler-eye"
                  >
                    <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                    <path d="M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                    <path
                      d="M21 12c-2.4 4 -5.4 6 -9 6c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6"
                    />
                  </svg>
                </button></a>
                <a href="editarTipoTramite.html" >
                <button title="Editar Tipo" class="btn-icono">
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
                <button title="Activo" class="btn-icono btn-accion-activo">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-toggle-right"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M16 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824" /><path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10" /></svg>
                </button>
                
              </td>
            </tr>

            <tr>
              <td>Titulación</td>
              <td>01/03/2026</td>
               <td class="acciones-crud">
                 <a href="detallesTipoTramite.html" >
                <button title="Ver Detalles" class="btn-icono">
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
                    class="icon icon-tabler icons-tabler-outline icon-tabler-eye"
                  >
                    <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                    <path d="M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                    <path
                      d="M21 12c-2.4 4 -5.4 6 -9 6c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6"
                    />
                  </svg>
                </button></a>
                <a href="editarTipoTramite.html" >
                <button title="Editar Tipo" class="btn-icono">
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
                <button title="Activo" class="btn-icono btn-accion-activo">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-toggle-right"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M16 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824" /><path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10" /></svg>
                </button>
              </td>
            </tr>

          </tbody>
        </table>
      </section>
    </main>
  </body>
</html>

