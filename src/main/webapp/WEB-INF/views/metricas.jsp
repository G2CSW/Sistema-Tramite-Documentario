<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
  <head>
    <title>Métricas Dashboard</title>

    <link rel="stylesheet" href="../../css/global.css" />
    <link rel="stylesheet" href="../../css/metricas.css" />

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@2.2.0"></script>
  </head>
  <body>
    <%@ include file="barraLateral.jsp" %>

    <main class="contenido-metricas">
      <header class="header-metricas">
        <div class="titulos">
          <small>ANÁLISIS GENERAL</small>
          <h1>Métricas</h1>
        </div>
      </header>

      <section class="cuadricula-metricas">
        <article class="tarjeta">
          <h2>Porcentaje de Trámites Aprobados</h2>
          <p>Últimos 5 meses</p>
          <canvas id="graficoAprobacion"></canvas>
        </article>

        <article class="tarjeta">
          <h2>Tasa de Rechazo de Trámites</h2>
          <p>Últimos 5 meses</p>
          <canvas id="graficoRechazo"></canvas>
        </article>

        <article class="tarjeta">
          <h2>Tasa de Abandono o Desistimiento</h2>
          <p>Últimos 5 meses</p>
          <canvas id="graficoAbandono"></canvas>
        </article>

        <article class="tarjeta">
          <h2>Intensidad de Entrada</h2>
          <p>Últimas 4 semanas</p>
          <canvas id="graficoEntrada"></canvas>
        </article>

        <article class="tarjeta">
          <h2>Tiempo Promedio de Resolución</h2>
          <p>Últimos 5 meses</p>
          <canvas id="graficoTiempo"></canvas>
        </article>
      </section>
    </main>

    <script>
      Chart.register(ChartDataLabels);

      const aprobacionLabels = [
        <c:forEach items="${aprobacionRows}" var="fila" varStatus="st">
          '${fila[0]}'<c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];
      const aprobacionValues = [
        <c:forEach items="${aprobacionRows}" var="fila" varStatus="st">
          ${fila[1]}
          <c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];

      const rechazoLabels = [
        <c:forEach items="${rechazoRows}" var="fila" varStatus="st">
          '${fila[0]}'<c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];
      const rechazoValues = [
        <c:forEach items="${rechazoRows}" var="fila" varStatus="st">
          ${fila[1]}
          <c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];

      const abandonoLabels = [
        <c:forEach items="${abandonoRows}" var="fila" varStatus="st">
          '${fila[0]}'<c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];
      const abandonoValues = [
        <c:forEach items="${abandonoRows}" var="fila" varStatus="st">
          ${fila[1]}
          <c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];

      const intensidadLabels = [
        <c:forEach items="${intensidadRows}" var="fila" varStatus="st">
          '${fila[0]}'<c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];
      const intensidadValues = [
        <c:forEach items="${intensidadRows}" var="fila" varStatus="st">
          ${fila[1]}
          <c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];

      const tiempoLabels = [
        <c:forEach items="${tiempoRows}" var="fila" varStatus="st">
          '${fila[0]}'<c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];
      const tiempoValues = [
        <c:forEach items="${tiempoRows}" var="fila" varStatus="st">
          ${fila[1]}
          <c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];

      function crearGrafico(id, labels, values, color, sufijo) {
        const ctx = document.getElementById(id);
        if (!ctx) return;

        new Chart(ctx, {
          type: "bar",
          data: {
            labels: labels,
            datasets: [
              {
                data: values,
                backgroundColor: color,
                borderWidth: 1,
                borderRadius: 6,
                barThickness: 22,
              },
            ],
          },
          options: {
            responsive: true,
            maintainAspectRatio: false,
            layout: {
              padding: 0,
            },
            plugins: {
              legend: {
                display: false,
              },
              datalabels: {
                anchor: "end",
                align: "top",
                color: "#555",
                font: { weight: "bold", size: 12 },
                formatter: function (value) {
                  return value + sufijo;
                },
              },
            },
            scales: {
              x: {
                grid: { display: false },
                ticks: { maxRotation: 45, minRotation: 0 },
              },
              y: {
                beginAtZero: true,
                max: Math.max(...values) * 1.15,
                ticks: { maxTicksLimit: 5 },
                grid: { color: "#eef0f2" },
              },
            },
          },
        });
      }

      crearGrafico(
        "graficoAprobacion",
        aprobacionLabels,
        aprobacionValues,
        "rgba(75, 192, 192, 0.35)",
        "%",
      );
      crearGrafico(
        "graficoRechazo",
        rechazoLabels,
        rechazoValues,
        "rgba(255, 99, 132, 0.35)",
        "%",
      );
      crearGrafico(
        "graficoAbandono",
        abandonoLabels,
        abandonoValues,
        "rgba(255, 159, 64, 0.35)",
        "%",
      );
      crearGrafico(
        "graficoEntrada",
        intensidadLabels,
        intensidadValues,
        "rgba(54, 162, 235, 0.35)",
        "",
      );
      crearGrafico(
        "graficoTiempo",
        tiempoLabels,
        tiempoValues,
        "rgba(153, 102, 255, 0.35)",
        " días",
      );
    </script>
  </body>
</html>
