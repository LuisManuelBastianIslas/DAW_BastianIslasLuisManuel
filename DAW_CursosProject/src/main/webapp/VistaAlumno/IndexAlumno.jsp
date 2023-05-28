<%-- De aqui en adelnate, seran las vistas de los alumnos --%>
<%@ page import="bastian.code.modelo.AlumnoJB" %>
<html>
    <head>
        <title>Alumnos - Inicio</title>

        <link href="default.css" rel="stylesheet"/>
    </head>

    <body>
        <div id="outer">
            <div id="header">
                <h1>Bastian Universities</h1>
            </div>

            <div id="menu">
                <ul>
                    <li class="first"><a href="RedirectInicioSV">Inicio</a></li>
                    <li><a href="LogOutSV">Log out</a></li>
                </ul>
            </div>

            <%
                String usuario = ((AlumnoJB)request.getSession().getAttribute("Alumno")).getNombre();
                String genero = ((AlumnoJB)request.getSession().getAttribute("Alumno")).getGenero().getIdGenero();
                if (genero.equals("M"))
                    out.println("<h2 class=\"center\">Bienvenido de nuevo " + usuario + "</h2>");
                else
                    out.println("<h2 class=\"center\">Bienvenida de nuevo " + usuario + "</h2>");
            %>

            <form class="formButtons">
                <table>
                    <tr>
                        <td><button type="submit" class = "mainButton" formaction="InfoPersonalAlumnoSV" formmethod="post">Informacion personal</button></td>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Mis materias</button></td>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Inscripcion</button></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Informacion personal</button></td>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Ver materias</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
