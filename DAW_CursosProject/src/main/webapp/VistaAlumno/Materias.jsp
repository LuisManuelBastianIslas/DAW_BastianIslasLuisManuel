<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoAlumnoJB" %>
<%@ page import="bastian.code.modelo.ProfesorJB" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoSalonJB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Mis Materias</title>

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
                        <h2 class="center">Mis Materias</h2>
                        <div id = "box">
                            <%
                                ArrayList<CursoAlumnoJB> cursos = (ArrayList<CursoAlumnoJB>) request.getAttribute("Cursos");
                                if (cursos.isEmpty()) {
                                    out.println("<h3 class=\"center\">No hay materias cargadas para este semestre aun</h3>");
                                } else {
                                    for (CursoAlumnoJB curso : cursos) {
                                        ProfesorJB profesor = curso.getAsignatura().getProfesor();
                                        ArrayList<CursoSalonJB> horarios = curso.getCursoSalon();

                                        out.println("<div id = \"materiaContainer\"><div id = \"materia\">");
                                        out.println("<p>" + curso.getNrc() + " - " + curso.getAsignatura().getMateria().getNombreMateria() + "</p>");
                                        out.println("<br>");
                                        out.println("<p>" + "Acad. " + profesor.getFullNameByApellidos() + "</p>");
                                        out.println("<p>" + "Correo: " + profesor.getEmail() + "</p>");
                                        out.println("<br>");

                                        for (CursoSalonJB h : horarios)
                                            out.println("<p>" + h.getDiaSemana() + " " + h.getHorario() + "\n" + "</p>");
                                        out.println("<br>");

                                        out.println("<p>" + "Salon(es): " + curso.getSalones() + "</p>");
                                        out.println("<p>" + "Estatus: " + curso.getCurso().getEstatusCurso().getNombre() + "</p></div></div>"); //Proximamente
                                    }
                                }
                            %>
                        </div>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras Funciones</h3>

                    <ul class="none">
                        <li><button type="submit" class = "leftButton" formaction="InfoPersonalAlumnoSV" formmethod="post">Informacion personal</button></li>
                        <li><button type="submit" class = "leftButton" formaction="MateriasSV" formmethod="post">Mis materias</button></li>
                        <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Inscripcion</button></li>
                        <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Calificacionnes</button></li>
                        <li><button type="submit" class = "leftButton" formaction="CurriculaSV" formmethod="post">Ver Curricula</button></li>
                    </ul>
                </div>

                <div class="clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>