<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Trámites Archivados</title>

    <link rel="stylesheet" href="../../css/global.css" />
    <link rel="stylesheet" href="../../css/archivados.css" />

  </head>
  <body>
    <%@ include file="barraLateral.jsp" %>
    
    <main>
      <header class="header">
        <div class="header-titulos">
          <h1>Trámites Archivados</h1>
          <p>
            Vea y administre los trámites que ya han sido archivados.
          </p>
        </div>
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
            <th>TIPO TRÁMITE.</th>
            <th>ID SOLICITANTE</th>
            <th>FECHA FINALIZACIÓN</th>
            <th>ESTADO FINAL</th>
            <th class="acciones-crud" >Acciones</th>
          </thead>
          <tbody>
            <tr>
              <td >
                156151
              </td>
              <td>Licencia de Estudio</td>
              <td>56546516</td>
              <td>14/04/2026</td>
              <td><span class="badge-estado estado-archivado">Archivado</span></td>
              <td class="acciones-crud">
                 <a href="./seguimiento.html" >
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
              <td>46510203</td>

              <td>10/04/2026</td>
              <td><span class="badge-estado estado-archivado">Archivado</span></td>
              <td class="acciones-crud">
                 <a href="./seguimiento.html" >
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
                165489
              </td>
              <td>Certificado de Estudio</td>
              <td>44165156</td>
              <td>08/04/2026</td>
              <td><span class="badge-estado estado-aprobado">Aprobado</span></td>
              <td class="acciones-crud">
                 <a href="./seguimiento.html" >
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
                189515
              </td>
              <td>Titulación</td>
              <td>61519884</td>

              <td>01/03/2026</td>
              <td><span class="badge-estado estado-aprobado">Aprobado</span></td>
              <td class="acciones-crud">
                 <a href="./seguimiento.html" >
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
                189515
              </td>
              <td>Titulación</td>
              <td>19865492</td>

              <td>03/03/2026</td>
              <td><span class="badge-estado estado-rechazado">Rechazado</span></td>
              <td class="acciones-crud">
                 <a href="./seguimiento.html" >
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

          </tbody>
        </table>
      </section>
    </main>
  </body>
</html>

