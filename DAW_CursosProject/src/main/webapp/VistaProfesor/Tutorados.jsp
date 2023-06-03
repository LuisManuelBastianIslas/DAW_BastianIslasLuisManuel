<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.AlumnoJB" %>
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
                        <h2 class = "center">Tutorados</h2>

                        <form action="IndexTutoradoSV" method="post" class = "formButtons">
                            <%
                                ArrayList<AlumnoJB> tutorados = (ArrayList<AlumnoJB>) request.getAttribute("Tutorados");
                                for (AlumnoJB alumno : tutorados)
                                    out.println( "<button name=\"Matricula\" type=\"submit\" value=\"" + alumno.getMatriculaAlumno() + "\" class=\"tutoradoBT\"><pre>" +
                                                        alumno.getNombre() + "\n" +
                                                        alumno.getApellidoPaterno() + "\n" +
                                                        alumno.getApleiidoMaterno() + "\n" +
                                                        alumno.getCarrera().getNombreCarrera() + "\n" +
                                                        "Generación " + alumno.getMatriculaAlumno().substring(0,3) + "\n" +
                                                        "Semestre " + alumno.getSemestre() + "\n" +
                                                        alumno.getEstatusAlumno().getNombre() + "\n" +
                                                        "</pre></button>");
                            %>
                        </form>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <ul class="none">
                        <li><button type="submit" class = "leftButton" formaction="InfoPersonalProfesorSV" formmethod="post">Informacion personal</button></li>
                        <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Horario</button></li>
                        <li><button type="submit" class = "leftButton" formaction="TutoradosSV" formmethod="post">Tutorados</button></li>
                        <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Calificacionnes</button></li>
                    </ul>
                </div>

                <div class = "clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
