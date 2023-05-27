<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Inicio de sesion - Bastian Universities</title>

        <link href="default.css" rel="stylesheet"/>
    </head>
    <body>

        <div id="header">
            <h1>Bastian Universities</h1>
        </div>

        <h2>Bienvenido</h2>
        <h3>Inicia sesion con tu urario y contraseña</h3>
        <br/>
        <form action="LogInSV" method="post" autocomplete="off" class="formJoin">
            <label>Usuario:</label>
            <input type="text" name="usuario">
            <label>Contraseña:</label>
            <input type="password" name="contrasena">
            <input type="submit" value="Iniciar Sesion">
        </form>
        <a href="hello-servlet">Hello Servlet</a>

    </body>
</html>