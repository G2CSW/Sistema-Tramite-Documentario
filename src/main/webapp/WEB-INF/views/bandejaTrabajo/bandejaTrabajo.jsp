<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Bandeja de Trabajo - Área Académica</title>
    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/bandejaTrabajo.css" />
  </head>
  <body>
  <%@ include file="../barraLateral.jsp" %>
    <main>
      <header class="header-bandeja">
        <h1>Bandeja de Trabajo - Área Académica</h1>
        <p class="subtitle">
          Gestione los trámites pendientes de recepción y evaluación.
        </p>
      </header>

      <section class="filtros-section">
        <h3>Trámites por revisar</h3>
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
            placeholder="Buscar Trámite"
            class="input-buscar-tramite"
          />
        </div>
      </section>

      <table class="tbl">
        <thead>
          <tr>
            <th>NRO. TRÁMITE</th>
            <th>TIPO DE TRÁMITE</th>
            <th>ID SOLICITANTE</th>
            <th>FECHA INGRESO</th>
            <th>ACCIÓN</th>
          </tr>
        </thead>

        <tbody>
          <tr>
             <td >
                156151
              </td>
            <td>
              Licencia de Estudio
            </td>
            <td>12345678</td>
            <td>Hoy, 09:45 AM</td>
            <td class="acciones">
              
              <button class="btn btn-evaluar">Evaluar</button>
            </td>
          </tr>

          <tr>
             <td >
                165489
              </td>
            <td>
              Convalidación
            </td>
            <td>45678912</td>
            <td>Ayer, 04:20 PM</td>
            <td class="acciones">
              
              <button class="btn btn-evaluar">Evaluar</button>
            </td>
          </tr>

          <tr>
             <td >
                465481
              </td>
            <td>
              Certificado de Estudio
            </td>
            <td>78915632</td>
            <td>12 Abr 2026</td>
            <td class="acciones">
              <button class="btn btn-evaluar">Evaluar</button>
            </td>
          </tr>

          <tr>
             <td >
                465165
              </td>
            <td>
              Titulación
            </td>
            <td>89431245</td>
            <td>11 Abr 2026</td>
            <td class="acciones">
              
              <a href="evaluacion.html">
                <button class="btn btn-evaluar">Evaluar</button></a
              >
            </td>
          </tr>
        </tbody>
      </table>
    </main>
  </body>
</html>
