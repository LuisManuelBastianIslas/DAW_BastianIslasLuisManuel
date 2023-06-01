<%@ page import="bastian.code.modelo.RelacionesJB.EstudioJB" %>
<%@ page import="java.util.ArrayList" %>
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
                        <h2 class = "center">Informacion Profesional</h2>

                        <div id = "leftColumn">
                            <p>Universidad:</p>
                            <p>Titulo:</p>
                            <p>Cedula:</p>
                            <p>Año de Graduación:</p>
                            <p>Estudio:</p>
                        </div>

                        <div id = "rightColumn">
                            <p>Something</p>
                            <p>Something</p>
                            <p>Something</p>
                            <p>Something</p>
                            <p>Something</p>
                            <%--<%
                                EstudioJB estudio = ((ArrayList<EstudioJB>)request.getSession().getAttribute("estudios")).get((Integer) request.getAttribute("indexEstudio"));
                                out.println("<p>" + estudio.getUniversidad() + "</p>");
                                out.println("<p>" + estudio.getTitulo() + "</p>");
                                out.println("<p>" + estudio.getCedula() + "</p>");
                                out.println("<p>" + estudio.getAnoGraduacion() + "</p>");
                                out.println("<p>" + estudio.getTipoEstudio().getNombre() + "</p>");
                            %>--%>
                        </div>

                        <div id = "paginacion">
                            <%
                                int selected = (Integer) request.getAttribute("indexEstudio");
                                for (int i = 1; i <= 5; i++) {
                                    if (i == selected)
                                        out.println("<button type=\"submit\" formaction=\"EstudiosProfesorSV\" formmethod=\"post\" class=\"activo\" name=\"indexEstudio\" value=\"" + i + "\">" + i + "</button>");
                                    else
                                        out.println("<button type=\"submit\" formaction=\"EstudiosProfesorSV\" formmethod\"post\" name=\"indexEstudio\" value=\"" + i + "\">" + i + "</button>");
                                }
                            %>
                            <%--<%
                                int cantEstudios =  ((ArrayList<EstudioJB>) request.getSession().getAttribute("estudios")).size();
                                int selected = (Integer) request.getAttribute("indexEstudio");
                                for (int i = 0; i < cantEstudios; i++) {
                                    if (i+1 == selected)
                                        out.println("<a href=\"EstudiosProfesorSV\" class=\"activo\">" + i+1 + "</a>");
                                    else
                                        out.println("<a href=\"EstudiosProfesorSV\">" + i+1 + "</a>");
                                }
                            %>--%>
                        </div>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <ul class="none">
                        <li><button type="submit" class = "leftButton" formaction="InfoPersonalProfesorSV" formmethod="post">Informacion personal</button></li>
                        <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Horario</button></li>
                        <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Tutorados</button></li>
                        <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Calificacionnes</button></li>
                    </ul>
                </div>

                <div class = "clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
