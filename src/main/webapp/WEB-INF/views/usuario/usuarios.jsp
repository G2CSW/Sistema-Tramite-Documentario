<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Usuarios</title>

    <link rel="stylesheet" href="../../../css/global.css" />
    <link rel="stylesheet" href="../../../css/usuarios.css" />
  </head>
  <body>
  <%@ include file="../barraLateral.jsp" %>
    <main>
      <header class="header">
        <div>
          <h1>Usuarios</h1>
          <p>Administra los usuarios con acceso al sistema de trámite documentario</p>
        </div>
        <div class="header-acciones">
          <div class="input-contenedor">
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
              class="input-busqueda-usuario"
              type="search"
              placeholder="Buscar por nombre"
            />
          </div>
          <a href="crearUsuario.html">
            <button class="btn btn-primary btn-nuevo-usuario">
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
            >Nuevo Usuario
          </button>
          </a>
        </div>
      </header>

      <section class="table-container">
          <table class="tbl">
            <thead>
              <tr>
                <th>Documento de Identidad</th>
                <th>Nombre Completo</th>
                <th>Correo Electrónico</th>
                <th>Área</th>
                <th class="acciones-crud">Acciones</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>45612345</td>
                <td class="nombre-usuario">Adrián Mendoza</td>
                <td>amendoza@gmail.com</td>
                <td>Mesa de Partes</td>
                <td class="acciones-crud">
                <a href="editarUsuario.html">
                  <button title="Editar" class="btn-icono btn-accion-editar">
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
                <button title="Activo" class="btn-icono btn-accion-activo">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-toggle-right"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M16 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824" /><path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10" /></svg>
                </button>
                </td>
              </tr>
              <tr>
                <td>45613248</td>
                <td class="nombre-usuario">Luis Pérez</td>
                <td>lperez@gmail.com</td>
                <td>Área Académica</td>
                 <td class="acciones-crud">
                 <a href="editarUsuario.html">
                  <button title="Editar" class="btn-icono btn-accion-editar">
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
                <button title="Activo" class="btn-icono btn-accion-activo">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-toggle-right"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M16 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824" /><path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10" /></svg>
                </button>
                </td>
              </tr>     
              <tr>
                <td>15648978</td>
                <td class="nombre-usuario">Andrés Martínez</td>
                <td>amartinez@gmail.com</td>
                <td>Área Académica</td>
                 <td class="acciones-crud">
                 <a href="editarUsuario.html">
                  <button title="Editar" class="btn-icono btn-accion-editar">
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
                   <button title="Inactivo" class="btn-icono btn-accion-inactivo">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="currentColor" class="icon icon-tabler icons-tabler-filled icon-tabler-toggle-left"><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M8 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824" /><path d="M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10" /></svg>
                </button>
                </td>
              </tr>
            </tbody>
          </table>
        </section>
    </main>
  </body>
</html>
