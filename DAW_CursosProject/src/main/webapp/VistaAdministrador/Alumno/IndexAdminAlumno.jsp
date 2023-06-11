<%@ page import="bastian.code.datos.AlumnoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Administrador - Alumnos</title>

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
                        <h2 class = "center">Selecciona la funcion</h2>

                        <form class = "formButtons">
                            <%
                                AlumnoDAO dao = new AlumnoDAO();
                                if ( dao.AddingIsPosible() )
                                    out.println("<div id = \"materiaContainer\"><button type = \"submit\" class = \"mainButton\" formaction = \"NuevoAlumnoSV\" formmethod = \"post\">Nuevo alumno</button></div>");
                                else
                                    out.println("<div id = \"materiaContainer\"><button type = \"submit\" class = \"mainButton\" disabled tittle = \"No es periodo de altas, prueba con otro semestre.\">Nuevo alumno</button></div>");
                            %>
                        </form>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <form>
                        <button type="submit" class = "leftButton" formaction="IndexAdminALumnoSV" formmethod="post">Alumnos</button>
                        <button type="submit" class = "leftButton" formaction="" formmethod="post">Profesores</button>
                        <button type="submit" class = "leftButton" formaction="" formmethod="post">Materias y Cursos</button>
                    </form>
                </div>

                <div class = "clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
