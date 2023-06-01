<%@ page import="bastian.code.modelo.ProfesorJB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Profesores - Inicio</title>

        <link href="default.css" rel="stylesheet"/>

        <%--  Aqui obtendré las variables --%>
        <%
            ProfesorJB profesor = (ProfesorJB) request.getSession().getAttribute("Profesor");
        %>
    </head>

    <body>
        <div id = "outer">
            <div id = "header">
                <h1>Bastian Universities</h1>
            </div>

            <div id = "menu">
                  <ul>
                      <li class="first"><a href="RedirectInicioSV">Inicio</a></li>
                      <li><a href="LogOutSV">Log out</a></li>
                  </ul>
            </div>

            <%
                if (profesor.getGenero().getIdGenero().equals("M"))
                    out.println("<h2 class=\"center\">Bienvenido de nuevo " + profesor.getNombre() + "</h2>");
                else
                    out.println("<h2 class=\"center\">Bienvenida de nuevo " + profesor.getNombre() + "</h2>");
            %>

            <form class="formButtons">
                <table>
                    <tr>
                        <td><button type="submit" class = "mainButton" formaction="InfoPersonalProfesorSV" formmethod="post">Informacion personal</button></td>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Horario</button></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><button type="submit" class = "mainButton" formaction="TutoradosSV" formmethod="post">Tutorados</button></td>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Calificaciones</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
