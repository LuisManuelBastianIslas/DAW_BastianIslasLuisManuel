<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoAlumnoJB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>

    <body>
        <div id = "outer">
            <div id = "header">
                <h1>Bastian Universities</h1>

                <link href="default.css" rel="stylesheet"/>
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
                        <h2 class = "center">Califiquelos</h2>

                        <form action="ActualizarCalificacionesSV" method="post">
                            <%
                                ArrayList<CursoAlumnoJB> alumnos = (ArrayList<CursoAlumnoJB>) request.getSession().getAttribute("Alumnos");

                                // Espero que pueda resolver los casos donde no haya alumnos, que en teoria no deberia de pasar
                                for (CursoAlumnoJB ca : alumnos) {
                                    out.println("<div id = \"divisor\"><div id = \"leftColumn\">");
                                    out.println("<p>" + ca.getAlumno().getFullNameByApellidos() + "</p>");
                                    out.println("</div>");

                                    out.println("<div id = \"tightColumn\">");
                                    out.println("<p><input type = \"number\" min = \"0\" max = \"10\" maxlength = \"2\" name = \"" + ca.getAlumno().getMatriculaAlumno() + "\" value = \"" + ca.getCalificacion() + "\"></p>");
                                    out.println("</div></div>");
                                }
                            %>
                            <input type="submit" value="Enviar">
                        </form>
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
