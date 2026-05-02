<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Registrar Usuario</title>
    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/registrarUsuario.css" />
</head>
<body>
<%@ include file="../barraLateral.jsp" %>

<main>
    <header class="header-seguimiento">
        <h1>Registrar Usuario</h1>
        <p>Ingrese los datos para registrar un nuevo usuario.</p>
    </header>

    <section class="section">
        <c:if test="${not empty error}">
            <p style="color:red;">${error}</p>
        </c:if>

        <form class="form-datos-usuario" action="/usuario/registrar" method="post">

            <div>
                <label>Documentación de Identidad</label>
                <input class="input" type="text" name="idUsuario"
                       value="${usuario.idUsuario}"
                       placeholder="Ej: 12345678"
                       required />
            </div>

            <div>
                <label>Nombre Completo</label>
                <input class="input" type="text" name="nombre"
                       value="${usuario.nombre}"
                       placeholder="Ej: Luis Díaz"
                       required />
            </div>

            <div>
                <label>Correo Electrónico</label>
                <input class="input" type="email" name="correoElectronico"
                       value="${usuario.correoElectronico}"
                       placeholder="Ej: correo@gmail.com"
                       required />
            </div>

            <div>
                <label>Contraseña</label>
                <input class="input" type="password" name="password"
                       value="${usuario.password}"
                       placeholder="Ej: 123"
                       required />
            </div>

            <div>
                <label>Área</label>
                <select class="select" name="idArea" required>
                    <option value="">Seleccione un área</option>
                    <c:forEach var="a" items="${areas}">
                        <option value="${a.idArea}">
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
                    Registrar Usuario
                </button>
            </section>

        </form>
    </section>
</main>
</body>
</html>