<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Inicio de sesion - Bastian Universities</title>
    </head>
    <body>
        <h2>Bienvenido</h2>
        <h3>Inicia sesion con tu urario y contraseña</h3>
        <br/>
        <form action="JoinSV" method="post">
            <p>Usuario: <input type="text" name="usuario"></p>
            <p>Contraseña: <input type="password" name="contrasena"></p>
            <p><input type="submit" value="Login"></p>
        </form>
        <a href="hello-servlet">Hello Servlet</a>
    </body>
</html>