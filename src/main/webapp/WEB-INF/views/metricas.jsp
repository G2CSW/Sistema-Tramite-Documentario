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
            <h2>Cantidad de Trámites Registrados en el Sistema</h2>
            <p>Últimas 4 semanas</p>
            <canvas id="graficoEntrada"></canvas>
        </article>
        <article class="tarjeta">
            <h2>Cantidad de Trámites que pasaron a Evaluación</h2>
            <p>Últimos 5 meses</p>
            <canvas id="graficoEvaluacion"></canvas>
        </article>
        <article class="tarjeta">
            <h2>Cantidad de Trámites Aprobados</h2>
            <p>Últimos 5 meses</p>
            <canvas id="graficoAprobados"></canvas>
        </article>
        <article class="tarjeta">
            <h2>Cantidad de Trámites Rechazados</h2>
            <p>Últimos 5 meses</p>
            <canvas id="graficoRechazados"></canvas>
        </article>
        <article class="tarjeta">
            <h2>Cantidad de Trámites Cancelados</h2>
            <p>Últimos 5 meses</p>
            <canvas id="graficoCancelados"></canvas>
        </article>

      </section>
    </main>

    <script>
      Chart.register(ChartDataLabels);

      const aprobadosLabels = [
        <c:forEach items="${aprobadosRows}" var="fila" varStatus="st">
          '${fila[0]}'<c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];
      const aprobadosValues = [
        <c:forEach items="${aprobadosRows}" var="fila" varStatus="st">
          ${fila[1]}
          <c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];

      const rechazadosLabels = [
        <c:forEach items="${rechazadosRows}" var="fila" varStatus="st">
          '${fila[0]}'<c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];
      const rechazadosValues = [
        <c:forEach items="${rechazadosRows}" var="fila" varStatus="st">
          ${fila[1]}
          <c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];

      const canceladosLabels = [
        <c:forEach items="${canceladosRows}" var="fila" varStatus="st">
          '${fila[0]}'<c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];
      const canceladosValues = [
        <c:forEach items="${canceladosRows}" var="fila" varStatus="st">
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

      const evaluacionLabels = [
        <c:forEach items="${evaluacionRows}" var="fila" varStatus="st">
          '${fila[0]}'<c:if test="${!st.last}">,</c:if>
        </c:forEach>,
      ];
      const evaluacionValues = [
        <c:forEach items="${evaluacionRows}" var="fila" varStatus="st">
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
        "graficoAprobados",
        aprobadosLabels,
        aprobadosValues,
        "rgba(75,192,192,0.35)",
        ""
      );

      crearGrafico(
        "graficoRechazados",
        rechazadosLabels,
        rechazadosValues,
        "rgba(255,99,132,0.35)",
        ""
      );

      crearGrafico(
        "graficoCancelados",
        canceladosLabels,
        canceladosValues,
        "rgba(255,159,64,0.35)",
        ""
      );

      crearGrafico(
        "graficoEvaluacion",
        evaluacionLabels,
        evaluacionValues,
        "rgba(153,102,255,0.35)",
        ""
      );

      crearGrafico(
        "graficoEntrada",
        intensidadLabels,
        intensidadValues,
        "rgba(54,162,235,0.35)",
        ""
      );
    </script>
  </body>
</html>
