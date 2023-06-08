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
                        <td><button type="submit" class = "mainButton" formaction="MateriasSV" formmethod="post">Mis materias</button></td>
                        <%--    Si es un prfesor quien esta acceidiendo a esta vista, este boton esta bloqueado --%>
                        <%
                            if ( ((String)request.getSession().getAttribute("TypeUser")).equals("Alumno") )
                                out.println("<td><button type=\"submit\" class = \"mainButton\" formaction=\"\" formmethod=\"post\">Inscripcion</button></td>");
                            else
                                out.println("<td><button disabled type=\"submit\" class = \"mainButton\">Inscripcion</button></td>");
                        %>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><button type="submit" class = "mainButton" formaction="ToIndexCalificacionesAlumnoSv" formmethod="post">Calificaciones</button></td>
                        <td><button type="submit" class = "mainButton" formaction="CurriculaSV" formmethod="post">Ver Curricula</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
