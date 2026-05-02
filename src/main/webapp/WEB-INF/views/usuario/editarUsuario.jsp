<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/registrarUsuario.css" />
  </head>
  <body>
  <%@ include file="../barraLateral.jsp" %>

    <main>
      <header class="header-seguimiento">
        <h1>Editar Usuario</h1>
        <p>Modifique los datos del usuario.</p>
      </header>

      <section class="section">
        <c:if test="${not empty error}">
          <p style="color:red;">${error}</p>
        </c:if>

        <form class="form-datos-usuario"
              action="/usuario/editar/${usuario.idUsuario}"
              method="post">

          <div>
            <label>Nombre</label>
            <input class="input" type="text" name="nombre"
                   placeholder="Nombre de Usuario"
                   value="${usuario.nombre}" required />
          </div>

          <div>
            <label>Documentación de Identidad</label>
            <input class="input" type="text" name="idUsuario"
                   placeholder="12345678"
                   value="${usuario.idUsuario}" required />
          </div>

          <div>
            <label>Correo Electrónico</label>
            <input class="input" type="email" name="correoElectronico"
                   placeholder="correo@gmail.com"
                   value="${usuario.correoElectronico}" required />
          </div>

          <div>
            <label>Contraseña</label>
            <input class="input" type="password" name="password"
                   placeholder="Ingrese contraseña"
                   value="${usuario.password}" required />
          </div>

          <div>
            <label>Área</label>
            <select class="select" name="idArea" required>
              <option value="">Seleccione un área</option>
              <c:forEach var="a" items="${areas}">
                <option value="${a.idArea}"
                  <c:if test="${usuario.area != null && usuario.area.idArea == a.idArea}">
                    selected
                  </c:if>>
                  ${a.nombreArea}
                </option>
              </c:forEach>
            </select>
          </div>

          <section class="section-acciones">
            <a href="/usuario/listar">
              <button type="button" class="btn btn-secondary">Cancelar</button>
            </a>

            <button type="submit" class="btn btn-primary">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-circle-check"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-1.293 5.953a1 1 0 0 0 -1.32 -.083l-.094 .083l-3.293 3.292l-1.293 -1.292l-.094 -.083a1 1 0 0 0 -1.403 1.403l.083 .094l2 2l.094 .083a1 1 0 0 0 1.226 0l.094 -.083l4 -4l.083 -.094a1 1 0 0 0 -.083 -1.32z" /></svg>
              Guardar Cambios
            </button>
          </section>

        </form>
      </section>
    </main>
  </body>
</html>