<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
  <head>
    <title>Métricas Dashboard</title>

    <link rel="stylesheet" href="../../css/global.css"/>
    <link rel="stylesheet" href="../../css/metricas.css" />
  </head>
  <body>

    <%@ include file="barraLateral.jsp" %>
    <main>
      <header class="header-metricas">
        <div class="titulos">
          <small>ANÁLISIS GENERAL</small>
          <h1>Métricas</h1>
          
        </div>
      </header>
      
    <section class="cuadricula-metricas" aria-label="Panel de métricas">

      <article class="tarjeta" aria-labelledby="aprobacion">
        <h2 id="aprobacion">Tasa de Aprobación</h2>
        <p>% de trámites aprobados respecto al total resuelto</p>

        <div class="grafico" role="img" aria-label="Porcentaje de trámites aprobados por mes">
          <div class="elemento-grafico">
            <div class="valor">82%</div>
            <div class="barra verde" style="height: 82%; width:20px;"></div>
            <div class="mes">Ene</div>
          </div>

          <div class="elemento-grafico">
            <div class="valor">88%</div>
            <div class="barra verde" style="height: 88%; width:20px;"></div>
            <div class="mes">Feb</div>
          </div>

          <div class="elemento-grafico">
            <div class="valor">85%</div>
            <div class="barra verde" style="height: 85%; width:20px;"></div>
            <div class="mes">Mar</div>
          </div>

          <div class="elemento-grafico">
            <div class="valor">90%</div>
            <div class="barra verde" style="height: 90%; width:20px;"></div>
            <div class="mes">Abr</div>
          </div>

          <div class="elemento-grafico">
            <div class="valor">92%</div>
            <div class="barra verde" style="height: 92%; width:20px;"></div>
            <div class="mes">May</div>
          </div>
        </div>
      </article>

      <article class="tarjeta" aria-labelledby="tasa-rechazo">
        <h2 id="tasa-rechazo">Tasa de Rechazo</h2>
        <p>% de trámites rechazados por mes</p>

        <div class="grafico" role="img" aria-label="Porcentaje de trámites rechazados por mes">
          <div class="elemento-grafico">
            <div class="valor">18%</div>
            <div class="barra rojo" style="height: 18%; width:20px;"></div>
            <div class="mes">Ene</div>
          </div>

          <div class="elemento-grafico">
            <div class="valor">12%</div>
            <div class="barra rojo" style="height: 12%; width:20px;"></div>
            <div class="mes">Feb</div>
          </div>

          <div class="elemento-grafico">
            <div class="valor">15%</div>
            <div class="barra rojo" style="height: 15%; width:20px;"></div>
            <div class="mes">Mar</div>
          </div>

          <div class="elemento-grafico">
            <div class="valor">10%</div>
            <div class="barra rojo" style="height: 10%; width:20px;"></div>
            <div class="mes">Abr</div>
          </div>

          <div class="elemento-grafico">
            <div class="valor">8%</div>
            <div class="barra rojo" style="height: 8%; width:20px;"></div>
            <div class="mes">May</div>
          </div>
        </div>
      </article>
      <article class="tarjeta" aria-labelledby="abandono">
        <h2 id="abandono">Tasa de Abandono</h2>
        <p>% de trámites anulados por mes</p>

        <div class="grafico" role="img" aria-label="Porcentaje de trámites abandonados por mes">
          <div class="elemento-grafico">
            <div class="valor">4%</div>
            <div class="barra naranja" style="height: 20%; width:20px;"></div>
            <div class="mes">Ene</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">5%</div>
            <div class="barra naranja" style="height: 25%; width:20px;"></div>
            <div class="mes">Feb</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">7%</div>
            <div class="barra naranja" style="height: 35%; width:20px;"></div>
            <div class="mes">Mar</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">9%</div>
            <div class="barra naranja" style="height: 45%; width:20px;"></div>
            <div class="mes">Abr</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">12%</div>
            <div class="barra naranja" style="height: 60%; width:20px;"></div>
            <div class="mes">May</div>
          </div>
        </div>
      </article>


      <article class="tarjeta" aria-labelledby="intensidad">
        <h2 id="intensidad">Intensidad de Entrada</h2>
        <p>Trámites ingresados últimas 4 semanas</p>

        <div class="grafico" role="img" aria-label="Trámites ingresados por semana">
          <div class="elemento-grafico">
            <div class="valor">45</div>
            <div class="barra azul" style="height: 45%; width:20px;"></div>
            <div class="semana">Hace 3 sem</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">70</div>
            <div class="barra azul" style="height: 70%; width:20px;"></div>
            <div class="semana">Hace 2 sem</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">95</div>
            <div class="barra azul" style="height: 95%; width:20px;"></div>
            <div class="semana">Hace 1 sem</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">60</div>
            <div class="barra azul" style="height: 60%; width:20px;"></div>
            <div class="semana">Actual</div>
          </div>
        </div>
      </article>

      <article class="tarjeta" aria-labelledby="tiempo-resolucion">
        <h2 id="tiempo-resolucion">Tiempo Promedio de Resolución</h2>
        <p>Días promedio para resolver un trámite por mes</p>

        <div class="grafico" role="img" aria-label="Tiempo promedio de resolución por mes">
          <div class="elemento-grafico">
            <div class="valor">6.2 días</div>
            <div class="barra naranja" style="height: 62%; width:20px;"></div>
            <div class="mes">Ene</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">5.4 días</div>
            <div class="barra naranja" style="height: 54%; width:20px;"></div>
            <div class="mes">Feb</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">7.1 días</div>
            <div class="barra naranja" style="height: 71%; width:20px;"></div>
            <div class="mes">Mar</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">4.8 días</div>
            <div class="barra naranja" style="height: 48%; width:20px;"></div>
            <div class="mes">Abr</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">4.1 días</div>
            <div class="barra naranja" style="height: 41%; width:20px;"></div>
            <div class="mes">May</div>
          </div>
        </div>
      </article>
      

    </section>
    </main>
  </body>
</html>
