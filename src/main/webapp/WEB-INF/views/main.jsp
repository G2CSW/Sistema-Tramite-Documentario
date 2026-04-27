<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sistema de Trámite Documentario</title>
    <link rel="stylesheet" href="../../css/global.css" />
    <link rel="stylesheet" href="../../css/main.css" />
  </head>
  <body>

      <%@ include file="barraLateral.jsp" %>

      <main>
      <header class="header-inicio">
        <h1 class="welcome-title">Bienvenido, Luis Pérez</h1>
        <p class="subtitle">
          Gestione, supervise y archive los trámites de su organización.
        </p>
      </header>

      <section class="cards-container">
        <div class="card date-card">
          <div class="card-icon">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="currentColor"
              class="icon icon-tabler icons-tabler-filled icon-tabler-calendar-event"
            >
              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
              <path
                d="M16 2a1 1 0 0 1 .993 .883l.007 .117v1h1a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h1v-1a1 1 0 0 1 1.993 -.117l.007 .117v1h6v-1a1 1 0 0 1 1 -1m3 8h-14v8.625c0 .705 .386 1.286 .883 1.366l.117 .009h12c.513 0 .936 -.53 .993 -1.215l.007 -.16zm-9 4a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1z"
              />
            </svg>
          </div>
          <div class="card-text">
            <p class="card-label">FECHA ACTUAL</p>
            <p class="card-value">Viernes, 24 de abril 2026</p>
          </div>
        </div>

        <div class="card area-card">
          <div class="card-icon government-building">
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
              class="icon icon-tabler icons-tabler-outline icon-tabler-building-bank"
            >
              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
              <path d="M3 21l18 0" />
              <path d="M3 10l18 0" />
              <path d="M5 6l7 -3l7 3" />
              <path d="M4 10l0 11" />
              <path d="M20 10l0 11" />
              <path d="M8 14l0 3" />
              <path d="M12 14l0 3" />
              <path d="M16 14l0 3" />
            </svg>
          </div>
          <div class="card-text">
            <p class="card-label">ÁREA</p>
            <p class="card-value">ÁREA ACADÉMICA</p>
          </div>
        </div>
      </section>

      <section class="section-acciones-rapidas">
        <h3>ACCIONES RÁPIDAS</h3>
        <div class="acciones-rapidas">
          <a href="../../../../../html/gestionTramites/crearTramite.html">
          <button class="accion-btn">
            <!-- file-plus -->
            <svg
              width="20"
              height="20"
              fill="none"
              stroke="currentColor"
              stroke-width="2"
            >
              <path d="M12 5v14M5 12h14" />
            </svg>
            Nuevo trámite
          </button>
        </a>
        <a href="../../../../../html/gestionTramites/tramites.html">
          <button class="accion-btn">
            <!-- inbox -->
           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-file-search"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M14 3v4a1 1 0 0 0 1 1h4" /><path d="M12 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v4.5" /><path d="M14 17.5a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0" /><path d="M18.5 19.5l2.5 2.5" /></svg>
            Seguimiento
          </button>
        </a>

        <a href="../../../../../html/gestionTramites/bandejaTrabajo.html">
          <button class="accion-btn">
            <!-- inbox -->
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
              class="icon icon-tabler icons-tabler-outline icon-tabler-clipboard-check"
            >
              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
              <path
                d="M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2"
              />
              <path
                d="M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2"
              />
              <path d="M9 14l2 2l4 -4" />
            </svg>
            Bandeja de trabajo
          </button>
        </a>

        <a href="../../../../../html/gestionTramites/archivados.html">
          <button class="accion-btn">
            <!-- archive -->
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
              class="icon icon-tabler icons-tabler-outline icon-tabler-archive"
            >
              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
              <path
                d="M3 6a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2"
              />
              <path d="M5 8v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-10" />
              <path d="M10 12l4 0" />
            </svg>
            Archivados
          </button>
        </a>
        </div>
      </section>
    </main>
  </body>
</html>
