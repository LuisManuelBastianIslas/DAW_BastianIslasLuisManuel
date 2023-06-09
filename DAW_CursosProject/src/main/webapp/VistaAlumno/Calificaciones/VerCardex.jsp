<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoAlumnoJB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>

        <link href="default.css" rel="stylesheet"/>
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

            <div id = "content">
                <div id = "primaryContentContainer">
                    <div id = "primaryContent">
                        <h2 class = "center">Cardex</h2>

                        <%
                            ArrayList<CursoAlumnoJB> cursos = (ArrayList<CursoAlumnoJB>) request.getAttribute("Cursos");

                            if (cursos.isEmpty()) {
                                out.println("<h3 class = \"center\">Uy, parece que aun no hay informacion para mostrate</h3>");
                            } else {
                                for (CursoAlumnoJB curso : cursos) {
                                    out.println("<div id = \"leftColumn\"><p>");
                                    out.println(curso.getAsignatura().getMateria().getNombreMateria());
                                    out.println("</p></div>");

                                    out.println("<div id = \"rightColumn\"><p>");
                                    out.println(curso.getCalificacion());
                                    out.println("</p></div>");
                                }
                            }
                        %>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <form>
                        <button type="submit" class = "leftButton" formaction="InfoPersonalAlumnoSV" formmethod="post">Informacion personal</button>
                        <button type="submit" class = "leftButton" formaction="MateriasSV" formmethod="post">Mis materias</button>
                        <button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Inscripcion</button>
                        <button type="submit" class = "leftButton" formaction="ToIndexCalificacionesAlumnoSV" formmethod="post">Calificacionnes</button>
                        <button type="submit" class = "leftButton" formaction="CurriculaSV" formmethod="post">Ver Curricula</button>
                    </form>
                </div>

                <div class="clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
