<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoJB" %>
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
                        <h2 class = "center">Seleccione la materia a calificar</h2>

                        <div id = "box">
                            <%
                                ArrayList<CursoJB> cursos = (ArrayList<CursoJB>) request.getAttribute("Cursos");

                                if (cursos.isEmpty())
                                    out.println("<h3>Uy, parece que no tienes materias este semestre</h3>");
                                else {
                                    out.println("<form action = \"\" method = \"post\">");
                                    for (CursoJB curso : cursos) {
                                        out.println("<div id = \"materiaContainer\">");
                                        out.println("<button type = \"submit\" class = \"mainButton\">" +
                                                    "<p>" + curso.getAsignatura().getNrc() + " - " + curso.getAsignatura().getMateria().getNombreMateria() + "</p>" +
                                                    curso.getAsignatura().getCarrera().getNombreCarrera() +
                                                    "</button>");
                                        out.println("</div>");
                                    }
                                    out.println("</form>");
                                }
                            %>
                        </div>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <form>
                        <button type="submit" class = "leftButton" formaction="InfoPersonalProfesorSV" formmethod="post">Informacion personal</button>
                        <button type="submit" class = "leftButton" formaction="HorarioProfesorSV" formmethod="post">Horario</button>
                        <button type="submit" class = "leftButton" formaction="TutoradosSV" formmethod="post">Tutorados</button>
                        <button type="submit" class = "leftButton" formaction="" formmethod="post">Calificacionnes</button>
                    </form>
                </div>

                <div class = "clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
