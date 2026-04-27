<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es ">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contacto</title>
    <link rel="stylesheet" href="../../css/global.css">
    <link rel="stylesheet" href="../../css/contacto.css">
</head>
<body>

    <%@ include file="barraLateral.jsp" %>
    <main>
        <header>
        <h1 class="titulo">CONTACTO</h1>
        <p class="subtitulo">
            Estamos aquí para asistirle en la gestión de sus activos
            documentales. Enviénos sus consultas.
        </p>
        </header>


        <!--Formulario-->
        <form class="formulario_Usuario">
            
            <div class="campo">
                <label>NOMBRE</label>
                <input class="input" type="text" placeholder="Ingrese su nombre completo">
            </div>

            <div class="campo">
                <label>EMAIL</label>
                <input class="input" type="email" placeholder="correo@ejemplo.com">
            </div>

            <div class="campo">
                <label>MENSAJE</label>
                <textarea  class="textarea" placeholder="Describa su requerimeinto detalladamente..."></textarea>
            </div>

            <button class="btn btn-primary btn-enviar">ENVIAR MENSAJE</button>

        </form>

        <!--PIE DE PAGINA INFO-->
        <footer class="info-footer">
            <div class="info-bloque">
                <span class="info-titulo">Oficina Central</span>
                <span>Av. Ferrocarril S/N</span>
                <span>Huancayo 12001</span>
            </div>
            <div class="info-bloque">
                <span class="info-titulo">SOPORTE DIRECTO</span>
                <span>(01) 6456410</span>
                <span>soporte@sistema.tramite</span>
            </div>
            <div class="info-bloque">
                <span class="info-titulo">HORARIO</span>
                <span>Lunes a Viernes</span>
                <span>09:00 - 18:00 CET</span>
            </div>
        </footer>
    </main>
</body>
</html>