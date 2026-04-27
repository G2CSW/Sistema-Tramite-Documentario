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

      <article class="tarjeta" aria-labelledby="eficiencia">
        <h2 id="eficiencia">Curva de Eficiencia</h2>
        <p>% de trámites resueltos por mes</p>

        <div class="grafico" role="img" aria-label="Curva de eficiencia por mes">
          <div class="elemento-grafico">
            <div class="valor">82%</div>
            <div class="barra azul" style="height: 82%; width:20px;"></div>
            <div class="mes">Ene</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">90%</div>
            <div class="barra azul" style="height: 90%; width:20px;"></div>
            <div class="mes">Feb</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">76%</div>
            <div class="barra azul" style="height: 76%; width:20px;"></div>
            <div class="mes">Mar</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">98%</div>
            <div class="barra azul" style="height: 98%; width:20px;"></div>
            <div class="mes">Abr</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">87%</div>
            <div class="barra azul" style="height: 87%; width:20px;"></div>
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

      <article class="tarjeta" aria-labelledby="carga-capacidad">
        <h2 id="carga-capacidad">Carga vs. Capacidad</h2>
        <p>Recibidos (azul) vs despachados (rojo)</p>

        <div class="grafico" role="img" aria-label="Comparación entre trámites recibidos y despachados por mes">
          <div class="elemento-grafico">
            <div class="barras-mes">
              <div class="envoltorio-barra">
                <div class="valor">120</div>
                <div class="barra azul" style="height: 75%;"></div>
              </div>
              <div class="envoltorio-barra">
                <div class="valor">95</div>
                <div class="barra rojo" style="height: 60%;"></div>
              </div>
            </div>
            <div class="mes">Ene</div>
          </div>

          <div class="elemento-grafico">
            <div class="barras-mes">
              <div class="envoltorio-barra">
                <div class="valor">140</div>
                <div class="barra azul" style="height: 90%;"></div>
              </div>
              <div class="envoltorio-barra">
                <div class="valor">130</div>
                <div class="barra rojo" style="height: 85%;"></div>
              </div>
            </div>
            <div class="mes">Feb</div>
          </div>

          <div class="elemento-grafico">
            <div class="barras-mes">
              <div class="envoltorio-barra">
                <div class="valor">160</div>
                <div class="barra azul" style="height: 100%;"></div>
              </div>
              <div class="envoltorio-barra">
                <div class="valor">120</div>
                <div class="barra rojo" style="height: 75%;"></div>
              </div>
            </div>
            <div class="mes">Mar</div>
          </div>

          <div class="elemento-grafico">
            <div class="barras-mes">
              <div class="envoltorio-barra">
                <div class="valor">150</div>
                <div class="barra azul" style="height: 95%;"></div>
              </div>
              <div class="envoltorio-barra">
                <div class="valor">142</div>
                <div class="barra rojo" style="height: 90%;"></div>
              </div>
            </div>
            <div class="mes">Abr</div>
          </div>

          <div class="elemento-grafico">
            <div class="barras-mes">
              <div class="envoltorio-barra">
                <div class="valor">170</div>
                <div class="barra azul" style="height: 100%;"></div>
              </div>
              <div class="envoltorio-barra">
                <div class="valor">155</div>
                <div class="barra rojo" style="height: 92%;"></div>
              </div>
            </div>
            <div class="mes">May</div>
          </div>
        </div>

        <div class="leyenda">
          <span><span class="punto azul"></span>Recibidos</span>
          <span><span class="punto rojo"></span>Despachados</span>
        </div>
      </article>

      <article class="tarjeta" aria-labelledby="intensidad">
        <h2 id="intensidad">Intensidad de Entrada</h2>
        <p>Trámites ingresados últimas 4 semanas</p>

        <div class="grafico" role="img" aria-label="Trámites ingresados por semana">
          <div class="elemento-grafico">
            <div class="valor">45</div>
            <div class="barra verde" style="height: 45%; width:20px;"></div>
            <div class="semana">Hace 3 sem</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">70</div>
            <div class="barra verde" style="height: 70%; width:20px;"></div>
            <div class="semana">Hace 2 sem</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">95</div>
            <div class="barra verde" style="height: 95%; width:20px;"></div>
            <div class="semana">Hace 1 sem</div>
          </div>
          <div class="elemento-grafico">
            <div class="valor">60</div>
            <div class="barra verde" style="height: 60%; width:20px;"></div>
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
