<%-- De aqui en adelnate, seran las vistas de los alumnos --%>
<html>
    <head>
        <title>Alumnos - Inicio</title>
    </head>
    <body>
        <%
            String usuario = "";
            String contrasena = "";
            usuario = request.getParameter("usuario");
            contrasena = request.getParameter("contrasena");
            //out.println("<p>Resultado: " + numero + "! = " + res + "</p>");
        %>
        <h2>Los datos son:</h2>
        <p>Usuario: <%=usuario%></p>
        <p>Usuario: <%=contrasena%></p>
    </body>
</html>
