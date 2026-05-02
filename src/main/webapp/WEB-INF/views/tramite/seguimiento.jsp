<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.demo.Tramite.EstadoTramite" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Seguimiento de Trámite</title>
    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/seguimiento.css" />
  </head>
  <body>

<%@ include file="../barraLateral.jsp" %>
    <main>
      <header class="header-seguimiento">
        <h1>TRÁMITE ${tramite.tipoTramite.nombre}</h1>
        <p>Nro: ${tramite.nroTramite}</p>
      </header>

      <!-- INFO PRINCIPAL -->
      <section class="info-box">
        <div class="info-item">
          <strong>ESTADO ACTUAL</strong>
          <c:choose>
            <c:when test="${tramite.estadoActual == EstadoTramite.APROBADO}">
              <span class="badge-estado estado-aprobado">APROBADO</span>
            </c:when>
            <c:when test="${tramite.estadoActual == EstadoTramite.EN_EVALUACION}">
              <span class="badge-estado estado-evaluacion">EN EVALUACIÓN</span>
            </c:when>
            <c:when test="${tramite.estadoActual == EstadoTramite.REGISTRADO}">
              <span class="badge-estado estado-registrado">REGISTRADO</span>
            </c:when>
            <c:when test="${tramite.estadoActual == EstadoTramite.ARCHIVADO}">
              <span class="badge-estado estado-archivado">ARCHIVADO</span>
            </c:when>
            <c:when test="${tramite.estadoActual == EstadoTramite.CANCELADO}">
              <span class="badge-estado estado-cancelado">CANCELADO</span>
            </c:when>
            <c:when test="${tramite.estadoActual == EstadoTramite.RECHAZADO}">
              <span class="badge-estado estado-rechazado">RECHAZADO</span>
            </c:when>
            <c:otherwise>
              <span class="badge-estado estado-evaluacion">${tramite.estadoActual}</span>
            </c:otherwise>
          </c:choose>
        </div>

        <div class="info-item">
          <strong>ÚLTIMA MODIFICACIÓN</strong>
          <c:choose>
            <c:when test="${not empty trazabilidades}">
              <p>${trazabilidades[0].fechaHoraFormateada}</p>
            </c:when>
            <c:otherwise>
              <p>Sin registros</p>
            </c:otherwise>
          </c:choose>
        </div>
      </section>

      <section class="datos-tramite">
        <div>
          <h4>Datos del Trámite</h4>
          <div>
            <strong>Tipo de Trámite</strong>
            <p>${tramite.tipoTramite.nombre}</p>
          </div>

          <div class="asunto-descripcion">
            <strong>Asunto / Descripción</strong>
            <textarea class="textarea-descripcion" disabled>${tramite.tipoTramite.documentacionMinima}</textarea>
          </div>
        </div>

        <div>
          <h4>Datos del Interesado</h4>
          <div>
            <strong>Nombre Completo</strong>
            <p>${tramite.solicitante.nombreCompleto}</p>
          </div>

          <div>
            <strong>DNI / CE</strong>
            <p>${tramite.solicitante.idSolicitante}</p>
          </div>

          <div>
            <strong>Correo Electrónico</strong>
            <p>${tramite.solicitante.correoElectronico}</p>
          </div>

          <div>
            <strong>Teléfono de Contacto</strong>
            <p>${tramite.solicitante.telefonoContacto}</p>
          </div>
        </div>
      </section>

      <!-- TABLA -->
      <section class="table-section">
        <div class="table-header">
          <h2>Trazabilidad del Trámite</h2>
        </div>

        <table class="tbl">
          <thead>
            <tr>
              <th>USUARIO</th>
              <th>ESTADO</th>
              <th>COMENTARIO</th>
              <th>FECHA</th>
            </tr>
          </thead>

         <tbody>
           <c:forEach var="tr" items="${trazabilidades}">
             <tr>
               <td>
                 <div class="user">
                   <div>
                     <strong>${tr.usuario.nombre}</strong>
                     <small>${tr.usuario.area.nombreArea}</small>
                   </div>
                 </div>
               </td>

               <td>
                 <c:choose>
                   <c:when test="${tr.estadoCambio == EstadoTramite.APROBADO}">
                     <span class="badge-estado estado-aprobado">Aprobado</span>
                   </c:when>
                   <c:when test="${tr.estadoCambio == EstadoTramite.EN_EVALUACION}">
                     <span class="badge-estado estado-evaluacion">Evaluación</span>
                   </c:when>
                   <c:when test="${tr.estadoCambio == EstadoTramite.REGISTRADO}">
                     <span class="badge-estado estado-registrado">Registrado</span>
                   </c:when>
                   <c:when test="${tr.estadoCambio == EstadoTramite.ARCHIVADO}">
                     <span class="badge-estado estado-archivado">Archivado</span>
                   </c:when>
                   <c:when test="${tr.estadoCambio == EstadoTramite.CANCELADO}">
                     <span class="badge-estado estado-cancelado">Cancelado</span>
                   </c:when>
                   <c:when test="${tr.estadoCambio == EstadoTramite.RECHAZADO}">
                    <span class="badge-estado estado-rechazado">Rechazado</span>
                   </c:when>
                   <c:otherwise>
                     <span class="badge-estado estado-evaluacion">${tr.estadoCambio}</span>
                   </c:otherwise>
                 </c:choose>
               </td>

               <td>${tr.comentario}</td>

               <td>
                 <strong>${tr.fechaHoraFormateada}</strong>
               </td>
             </tr>
           </c:forEach>

           <c:if test="${empty trazabilidades}">
             <tr>
               <td colspan="4">No hay registros de trazabilidad para este trámite.</td>
             </tr>
           </c:if>
         </tbody>
        </table>
      </section>
    </main>
  </body>
</html>