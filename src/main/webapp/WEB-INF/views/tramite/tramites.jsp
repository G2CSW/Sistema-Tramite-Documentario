
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Trámites</title>

    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/tramites.css" />

  </head>
  <body>

    <%@ include file="../barraLateral.jsp" %>
    <main>
      <header class="header">
        <div class="header-titulos">
          <h1>Trámites generados</h1>
          <p>
            Vea y administre los trámites que ha creado. Utilice los filtros
            para localizarlos rápidamente.
          </p>
        </div>
        <a href="registrarTramite.jsp" >
          <button class="btn btn-primary">
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
          >Nuevo Trámite
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
            placeholder="Buscar trámite"
            class="input-buscar-tramite"
          />
        </div>       
      </section>

      <section class="tramites-list">
        <table class="tbl">
          <thead>
            <th>NRO. TRÁMITE</th>
            <th>TIPO TRÁMITE</th>
            <th>ID SOLICITANTE</th>
            <th>FECHA REGISTRO</th>
            <th>ESTADO</th>
            <th>ÚLTIMA MODIFICACIÓN</th>
            <th class="acciones-crud" >Acciones</th>
          </thead>
          <tbody>
            <tr>
              <td >
                156151
              </td>
              <td>Licencia de Estudio</td>
              <td>12345678</td>
              <td>14/04/2026</td>
              <td><span class="badge-estado estado-evaluacion">EVALUACIÓN</span></td>
              <td>16/04/2026</td>
              <td class="acciones-crud">
                 <a href="seguimiento.jsp" >
                <button title="Ver Estado" class="btn-icono">
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
              </td>
            </tr>
            <tr>
              <td >
                465165
              </td>
              <td>Convalidación</td>
              <td>78945612</td>
              <td>10/04/2026</td>
              <td><span class="badge-estado estado-creado">Creado</span></td>
              <td>10/04/2026</td>
              <td class="acciones-crud">
                 <a href="seguimiento.jsp" >
                <button title="Ver Estado" class="btn-icono">
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
                <a href="editarTramite.jsp" >
                <button title="Editar" class="btn-icono">
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
                <button title="Confirmar y derivar" class="btn-icono">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-send"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M10 14l11 -11" /><path d="M21 3l-6.5 18a.55 .55 0 0 1 -1 0l-3.5 -7l-7 -3.5a.55 .55 0 0 1 0 -1l18 -6.5" /></svg>
                </button>
               
              </td>
            </tr>

            <tr>
              <td >
                165489
              </td>
              <td>Certificado de Estudio</td>
              <td>15648981</td>
              <td>08/04/2026</td>
              <td><span class="badge-estado estado-evaluacion">Evaluación</span></td>
              <td>10/04/2026</td>
              <td class="acciones-crud">
                 <a href="seguimiento.jsp" >
                <button title="Ver Estado" class="btn-icono">
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
                <a href="editarTramite.jsp" >
               
             
              </td>
            </tr>

            <tr>
              <td >
                189515
              </td>
              <td>Titulación</td>
              <td>75318645</td>
              <td>01/03/2026</td>
              <td><span class="badge-estado estado-aprobado">Aprobado</span></td>
              <td>15/03/2026</td>
              <td class="acciones-crud">
                 <a href="seguimiento.jsp" >
                <button title="Ver Estado" class="btn-icono">
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
                <button title="Archivar" class="btn-icono">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-archive"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M3 6a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2" /><path d="M5 8v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-10" /><path d="M10 12l4 0" /></svg>
                </button>
              </td>
            </tr>

            <tr>
              <td >
                189515
              </td>
              <td>Titulación</td>
              <td>45678912</td>
              <td>03/03/2026</td>
              <td><span class="badge-estado estado-rechazado">Rechazado</span></td>
              <td>16/03/2026</td>
              <td class="acciones-crud">
                 <a href="seguimiento.jsp" >
                <button title="Ver Estado" class="btn-icono">
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

                <button title="Archivar" class="btn-icono">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-archive"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M3 6a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2" /><path d="M5 8v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-10" /><path d="M10 12l4 0" /></svg>
                </button>
              </td>
            </tr>

          </tbody>
        </table>
      </section>
    </main>
  </body>
</html>

