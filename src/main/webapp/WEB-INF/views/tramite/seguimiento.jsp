<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h1>TRÁMITE CONVALIDACIÓN </h1>
        <p>Nro: 132165</p>
      </header>

      <!-- INFO PRINCIPAL -->
      <section class="info-box">
        <div class="info-item">
          <strong>ESTADO ACTUAL</strong>
          <span class="badge-estado estado-aprobado">APROBADO</span>
        </div>

        <div class="info-item">
          <strong>ÚLTIMA MODIFICACIÓN</strong>
          <p>12 Oct, 2026</p>
        </div>
      </section>

      <section class="datos-tramite">
        <div>
          <h4>Datos del Trámite</h4>
          <div>
            <strong>Tipo de Trámite</strong>
            <p>Convalidación</p>
          </div>

          <div class="asunto-descripcion">
            <strong>Asunto / Descripción</strong>
            <textarea class="textarea-descripcion" disabled>Se ha adjuntado al trámite los siguientes documentos:
    1. Formato único de trámite.
    2. Certificado de estudios del semestre(s) a convalidar
    3. Copia del sílabo de las asignaturas a convalidar.
    4. Recibo de pago por los semestres estudiados.
            </textarea>
              
          </div>
        </div>

        <div>
          <h4>Datos del Interesado</h4>
          <div>
            <strong>Nombre Completo / Razón Social</strong>
            <p>Luis Enrique</p>
          </div>

          <div>
            <strong>DNI / RUC / CE</strong>
            <p>12345678</p>
          </div>

          <div>
            <strong>Correo Electrónico</strong>
            <p>luis@gmail.com</p>
          </div>

          <div>
            <strong>Teléfono de Contacto</strong>
            <p>987654321</p>
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
            <tr>
              <td>
                <div class="user">
                  <div class="avatar gray">LP</div>
                  <div>
                    <strong>Luis Pérez</strong>
                    <small>Área Académica</small>
                  </div>
                </div>
              </td>
              <td><span class="badge-estado estado-aprobado">Aprobado</span></td>
              <td>Trámite aprobado por el Área académica</td>
              <td><strong>Hoy</strong><br /><small>12:00 PM</small></td>
            </tr>

            <tr>
              <td>
                <div class="user">
                  <div class="avatar gray">LP</div>
                  <div>
                    <strong>Luis Pérez</strong>
                    <small>Área Académica</small>
                  </div>
                </div>
              </td>
              <td><span class="badge-estado estado-evaluacion">Evaluación</span></td>
              <td>Trámite recibido y en proceso de evaluación por el Área Académica</td>
              <td><strong>Hoy</strong><br /><small>11:05 AM</small></td>
            </tr>
            
            <tr>
              <td>
                <div class="user">
                  <div class="avatar">AM</div>
                  <div>
                    <strong>Adrián Mendoza</strong>
                    <small>Mesa de Partes</small>
                  </div>
                </div>
              </td>
              <td><span class="badge-estado estado-creado">Creado</span></td>
              <td>Creación del trámite en el sistema</td>
              <td>
                <strong>12 Abr, 2026</strong><br /><small>10:15 AM</small>
              </td>
            </tr>
          </tbody>
        </table>
      </section>

      
    </main>
  </body>
</html>
