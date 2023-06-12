<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoJB" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoSalonJB" %>
<%@ page import="bastian.code.datos.CatalogosDAO.CarreraDAO" %>
<%@ page import="bastian.code.modelo.CatalogosJB.CarreraJB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Adminstrador - Ver Cursos Actuales</title>

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
                        <h2 class = "center">Cursos</h2>

                        <div id = "box">
                            <%
                                ArrayList<CursoJB> cursos = (ArrayList<CursoJB>) request.getAttribute("CursosCarrera");

                                if (cursos.isEmpty())
                                    out.println("<h3 class=\"center\">No hay cursos cargadas para este semestre aun</h3>");
                                else
                                    for (CursoJB c : cursos) {
                                        out.println("<div id = \"materiaContainer\">");
                                        out.println("<div id = \"materia\">");
                                        out.println("<p>" + c.getNrc() + " - " + c.getAsignatura().getMateria().getNombreMateria() + "</p>");
                                        out.println("<br>");
                                        out.println("<p>" + "Acad. " + c.getAsignatura().getProfesor().getFullNameByApellidos() + "</p>");

                                        for (CursoSalonJB h : c.createCursoSalon())
                                            out.println("<p>" + h.getDiaSemana() + " " + h.getHorario() + "</p>");
                                        out.println("<br>");

                                        out.println("<p>" + "Estatus: " + c.getCurso().getEstatusCurso().getNombre() + "</p>");

                                        out.println("</div>");
                                        out.println("</div>");
                                    }
                            %>
                        </div>

                        <div id = "paginacion">
                            <form action="VerAdminCursosActuales" method="post">
                                <%
                                    int selected = (Integer) request.getAttribute("Index");

                                    for (CarreraJB c : CarreraDAO.select())
                                        if (c.getIdCarrera() == selected)
                                            out.println("<button type=\"submit\" class=\"activo\" name=\"Index\" value=\"" + c.getIdCarrera() + "\">" + c.getNombreCarrera() + "</button>");
                                        else
                                            out.println("<button type=\"submit\" name=\"Index\" value=\"" + c.getIdCarrera() + "\">" + c.getNombreCarrera() + "</button>");
                                %>
                            </form>
                        </div>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <form>
                        <button type="submit" class = "leftButton" formaction="IndexAdminALumnoSV" formmethod="post">Alumnos</button>
                        <button type="submit" class = "leftButton" formaction="" formmethod="post">Profesores</button>
                        <button type="submit" class = "leftButton" formaction="IndexAdminMateriaYCursoSV" formmethod="post">Materias y Cursos</button>
                        <button type="submit" class = "leftButton" formaction="IndexAdminCursoSV" formmethod="post">Administrar Cursos</button>
                    </form>
                </div>

                <div class="clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
        </body>
    </body>
</html>
