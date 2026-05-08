
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.demo.Tramite.EstadoTramite" %>



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
        <a href="/tramite/registrar" >
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
      <c:if test="${not empty mensaje}">
          <div class="contenedor-mensaje mensaje mensaje-exito">
            ${mensaje}
          </div>
       </c:if>
      <form action="/tramite/listar" method="get" class="filtros-section">
       <label for="buscar-tramite" > Buscar por DNI / CE: </label>
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
              id="buscar-tramite"
              type="search"
              name="idSolicitante"
              value="${idSolicitanteBuscado}"
              placeholder="Ingrese DNI/CE"
              class="input-buscar-tramite"
            />
        </div>
        <button class="btn btn-primary">Buscar </button>
      </form>

      <section class="tramites-list">
        <table class="tbl">
          <thead>
            <th>NRO. TRÁMITE</th>
            <th>TIPO TRÁMITE</th>
            <th>DNI/CE</th>
            <th>Solicitante</th>
            <th>FECHA REGISTRO</th>
            <th>ESTADO</th>
            <th class="acciones-crud" >Acciones</th>
          </thead>
          <tbody>
         <c:forEach var="tramite" items="${tramites}">
              <tr>
                <td>${tramite.nroTramite}</td>
                <td>${tramite.tipoTramite.nombre}</td>
                <td>${tramite.solicitante.idSolicitante}</td>
                <td>${tramite.solicitante.nombreCompleto}</td>
                <td>${tramite.fechaRegistro}</td>

                <c:set var="claseEstado">
                  <c:choose>

                    <c:when test="${tramite.estadoActual == EstadoTramite.REGISTRADO}">
                      estado-registrado
                    </c:when>

                    <c:when test="${tramite.estadoActual == EstadoTramite.EN_EVALUACION}">
                      estado-evaluacion
                    </c:when>

                    <c:when test="${tramite.estadoActual == EstadoTramite.APROBADO}">
                      estado-aprobado
                    </c:when>

                    <c:when test="${tramite.estadoActual == EstadoTramite.RECHAZADO}">
                      estado-rechazado
                    </c:when>

                    <c:when test="${tramite.estadoActual == EstadoTramite.ARCHIVADO}">
                      estado-archivado
                    </c:when>

                    <c:when test="${tramite.estadoActual == EstadoTramite.CANCELADO}">
                      estado-cancelado
                    </c:when>

                  </c:choose>
                </c:set>
                <td><span class="badge-estado ${claseEstado}">
                 ${tramite.estadoActual.nombre}</span>
                 </td>
               <td class="acciones-crud">

                 <!-- BOTÓN VER (SIEMPRE) -->
                 <a href="/tramite/${tramite.nroTramite}">
                   <button class="btn-icono" title="Ver">
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
                </button>
                 </a>

                 <!-- ESTADO: REGISTRADO -->
                 <c:if test="${tramite.estadoActual == EstadoTramite.REGISTRADO}">

                   <a href="/tramite/editar/${tramite.nroTramite}">
                     <button class="btn-icono" title="Editar">
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

                   <form action="/tramite/cambiar-estado/${tramite.nroTramite}" method="post" style="display:inline;">
                     <input type="hidden" name="estado" value="EN_EVALUACION">
                     <button class="btn-icono" title="Derivar"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-send"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M10 14l11 -11" /><path d="M21 3l-6.5 18a.55 .55 0 0 1 -1 0l-3.5 -7l-7 -3.5a.55 .55 0 0 1 0 -1l18 -6.5" /></svg></button>
                   </form>

                   <form action="/tramite/cambiar-estado/${tramite.nroTramite}"
                         method="post" style="display:inline;">
                     <input type="hidden" name="estado" value="CANCELADO">
                     <button class="btn-icono" title="Cancelar"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-cancel"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0" /><path d="M18.364 5.636l-12.728 12.728" /></svg></button>
                   </form>

                 </c:if>

                 <!-- ESTADO: EN EVALUACIÓN -->
                 <c:if test="${tramite.estadoActual == EstadoTramite.EN_EVALUACION}">

                   <form action="/tramite/cambiar-estado/${tramite.nroTramite}"
                         method="post" style="display:inline;">
                     <input type="hidden" name="estado" value="CANCELADO">
                     <button class="btn-icono" title="Cancelar"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-cancel"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0" /><path d="M18.364 5.636l-12.728 12.728" /></svg></button>
                   </form>

                 </c:if>

                 <c:if test="${tramite.estadoActual == EstadoTramite.APROBADO or tramite.estadoActual == EstadoTramite.RECHAZADO}">

                   <form action="/tramite/cambiar-estado/${tramite.nroTramite}"
                         method="post" style="display:inline;">
                     <input type="hidden" name="estado" value="ARCHIVADO">
                     <button class="btn-icono" title="Archivar"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-archive"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M3 6a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2" /><path d="M5 8v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-10" /><path d="M10 12l4 0" /></svg></button>
                   </form>

                 </c:if>

               </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </section>
    </main>
  </body>
</html>

