<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Publicidad</title>
  <link rel="stylesheet" href="../../css/global.css">
  <link rel="stylesheet" href="../../css/publicidad.css">
</head>
<body>
    <%@ include file="barraLateral.jsp" %>
  <main >

    <!-- ENCABEZADO -->
    <header>
      <h1 class="titulo">Publicidad</h1>
      <p class="subtitulo">
        Funcionalidades del sistema
      </p>
    </header>

    <!-- TARJETA CAMPAÑA ACTIVA -->
    
    <!-- SECCIÓN INFERIOR — 3 BLOQUES -->
    <section class="info-bloques">
      <div class="bloque">
        <div class="bloque-header">
          <span class="bloque-icono"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-file-plus"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M14 3v4a1 1 0 0 0 1 1h4" /><path d="M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2" /><path d="M12 11l0 6" /><path d="M9 14l6 0" /></svg></span>
          <strong>Registro de Trámites</strong>
        </div>
        <p>
Permite registrar nuevos trámites ingresando la información necesaria del solicitante y del tipo de trámite. Desde aquí se inicia el proceso para su posterior evaluación.
</p>
      </div>

      <div class="bloque">
        <div class="bloque-header">
          <span class="bloque-icono"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-file-search"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M14 3v4a1 1 0 0 0 1 1h4" /><path d="M12 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v4.5" /><path d="M14 17.5a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0" /><path d="M18.5 19.5l2.5 2.5" /></svg></span>
          <strong>Seguimiento de Trámites</strong>
        </div>
        <p>
Permite visualizar el estado actual de los trámites registrados, facilitando el seguimiento de su progreso desde su creación hasta su resolución final.
</p>
      </div>

       <div class="bloque">
        <div class="bloque-header">
          <span class="bloque-icono"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-clipboard-check"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2" /><path d="M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2" /><path d="M9 14l2 2l4 -4" /></svg></span>
          <strong>Evaluación de Trámites</strong>
        </div>
        <p>
Permite revisar los trámites derivados, registrando el resultado de la evaluación como aprobado o rechazado, junto con un comentario si es necesario.
</p>
      </div>

      <div class="bloque">
        <div class="bloque-header">
          <span class="bloque-icono"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-archive"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M3 6a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2" /><path d="M5 8v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-10" /><path d="M10 12l4 0" /></svg></span>
          <strong>Historial de trámites archivados</strong>
        </div>
        <p>
Permite consultar los trámites que han finalizado su proceso, ya sea aprobados, rechazados o anulados, manteniendo un historial para futuras consultas.
</p>
      </div>

      <div class="bloque">
        <div class="bloque-header">
          <span class="bloque-icono"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-list-details"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M13 5h8" /><path d="M13 9h5" /><path d="M13 15h8" /><path d="M13 19h5" /><path d="M3 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4" /><path d="M3 15a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4" /></svg></span>
          <strong>Gestionar nuevos tipos de Trámites</strong>
        </div>
        <p>
Permite administrar los tipos de trámites disponibles en el sistema, creando, editando o desactivando opciones según las necesidades institucionales.
</p>
      </div>

      <div class="bloque">
              <div class="bloque-header">
                <span class="bloque-icono"><svg
                   xmlns="http://www.w3.org/2000/svg"
                   width="24"
                   height="24"
                   viewBox="0 0 24 24"
                   fill="none"
                   stroke="currentColor"
                   stroke-width="2"
                   stroke-linecap="round"
                   stroke-linejoin="round"
                   class="icon icon-tabler icons-tabler-outline icon-tabler-file-settings"
                 >
                   <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                   <path d="M10 14a2 2 0 1 0 4 0a2 2 0 1 0 -4 0" />
                   <path d="M12 10.5v1.5" />
                   <path d="M12 16v1.5" />
                   <path d="M15.031 12.25l-1.299 .75" />
                   <path d="M10.268 15l-1.3 .75" />
                   <path d="M15 15.803l-1.285 -.773" />
                   <path d="M10.285 12.97l-1.285 -.773" />
                   <path d="M14 3v4a1 1 0 0 0 1 1h4" />
                   <path
                     d="M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2"
                   /></svg
                 ></span>
                <strong>Gestión de Documentos</strong>
              </div>
              <p>
      Permite administrar los documentos mínimos que requieren cada tipo de trámite en el sistema, creando, editando o desactivando opciones según las necesidades institucionales.
      </p>
            </div>

      <div class="bloque">
        <div class="bloque-header">
          <span class="bloque-icono"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-users"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M5 7a4 4 0 1 0 8 0a4 4 0 1 0 -8 0" /><path d="M3 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2" /><path d="M16 3.13a4 4 0 0 1 0 7.75" /><path d="M21 21v-2a4 4 0 0 0 -3 -3.85" /></svg></span>
          <strong>Gestión de usuarios</strong>
        </div>
        <p>
Permite administrar los usuarios del sistema, creando, modificando y deshabilitando a estos así como asignando su área de trabajo.
</p>
      </div>

    </section>

  </main>

</body>
</html>