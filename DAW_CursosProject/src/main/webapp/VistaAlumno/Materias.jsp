<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoAlumnoJB" %>
<%@ page import="java.util.Map" %>
<%@ page import="bastian.code.modelo.ProfesorJB" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoSalonJB" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="bastian.code.datos.RelacionesDAO.CursoAlumnoDAO" %>
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
                                for (CursoAlumnoJB curso : cursos) {
                                    ProfesorJB profesor = curso.getAsignatura().getProfesor();
                                    ArrayList<CursoSalonJB> horarios = curso.getCursoSalon();

                                    out.println("<div id = \"materiaContainer\"><div id = \"materia\">");
                                    out.println("<p>" + curso.getNRC() + " - " + curso.getAsignatura().getMateria().getNombreMateria() + "</p>");
                                    out.println("<br>");
                                    out.println("<p>" + "Acad. " + profesor.getFullNameByApellidos() + "</p>");
                                    out.println("<p>" + "Correo: " + profesor.getEmail() + "</p>");
                                    out.println("<br>");

                                    for (CursoSalonJB h : horarios)
                                        out.println("<p>" + h.getDiaSemana() + " " + h.getHorario() + "\n" + "</p>");
                                    out.println("<br>");

                                    out.println("<p>" + "Salon(es): " + curso.getSalones() + "</p></div></div>");
                                }
                            %>
                        </div>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras Funciones</h3>
                </div>

                <div class="clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>

<%--<%!
    // Se que me estoy enredando con los nombres..
    // Posiblemente ni yo mismo recuerde porque lo hice asi...
    private String imprimirMaterias(ArrayList<CursoAlumnoJB> cursos) {
        List<String> materias = cursos.stream()
                .map(mt -> {                                            // Primero lo convierto al string del contenido y añadiendo html
                    ProfesorJB profesor = mt.getAsignatura().getProfesor();
                    ArrayList<CursoSalonJB> horarios = mt.getCursoSalon();

                    String horario = "";
                    for (CursoSalonJB h : horarios)
                        horario += h.getDiaSemana() + " " + h.getHorario() + "\n";

                    return  "<p>" + mt.getNRC() + " - " + mt.getAsignatura().getMateria().getNombreMateria() + "</p>" +
                            "<pre>" +
                            "Acad. " + profesor.getFullNameByApellidos() + "\n" +
                            "Correo: " + profesor.getEmail() + "\n" +
                            horario + "\n" +
                            "Salon(es): " + mt.getSalones() +
                            "</pre>";
                        })
                .map(s -> "<div id = \"materia\">" + s + "</div>")      // Luego lo encapsulo en mas html
                .collect(Collectors.toList());                          // y fonalmente lo paso a la lista

        String materiasHTML = "";
        for(String materiaHTML : materias)
            materiasHTML += materiaHTML;

        return materiasHTML;
    }
%>--%>