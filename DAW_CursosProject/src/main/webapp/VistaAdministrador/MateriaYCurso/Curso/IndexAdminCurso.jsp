<%@ page import="bastian.code.modelo.CatalogosJB.PeriodoJB" %>
<%@ page import="bastian.code.datos.CatalogosDAO.PeriodoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Administrador - Cursos</title>

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
                        <h2 class = "center">Elige una opcion</h2>

                        <div id = "box">
                            <form class="formButtons">
                                <div id = "materiaContainer">
                                    <button type="submit" class = "mainButton" formaction="VerAdminCursosActualesSV" formmethod="post">Ver cursos actuales</button>
                                </div>

                                <div id = "materiaContainer">
                                    <%
                                        // Si no hay un periodo siguiente, no se pueden inscribir materias
                                        if (PeriodoDAO.IsThereNextPeriodo())
                                            out.println("<button type=\"submit\" class = \"mainButton\" formaction=\"InscribirAdminCursoSV\" formmethod=\"post\">Inscribir cursos</button>");
                                        else
                                            out.println("<button type=\"submit\" class = \"mainButton\" disabled>Inscribir cursos</button>");
                                    %>
                                </div>
                            </form>

                            <div>
                                <h3>Cambiar periodo actual</h3>

                                <form action="UpdateCursoActualSV" method="post">
                                    <select name="IdPeriodo">
                                        <option value="-1">Añadir nuevo</option>

                                        <%
                                            for (PeriodoJB p : PeriodoDAO.select())
                                                if (PeriodoDAO.getPeriodoActual().getIdPeriodo() == p.getIdPeriodo())
                                                    out.println("<option value=\"" + p.getIdPeriodo() + "\" selected>" + p.getDescripcionPeriodo() + "</option>");
                                                else
                                                    out.println("<option value=\"" + p.getIdPeriodo() + "\">" + p.getDescripcionPeriodo() + "</option>");
                                        %>
                                    </select>

                                    <input type="submit" value="Actualizar">
                                </form>
                            </div>

                            <div class="clear"></div>
                        </div>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <form>
                        <button type="submit" class = "leftButton" formaction="IndexAdminALumnoSV" formmethod="post">Alumnos</button>
                        <button type="submit" class = "leftButton" formaction="" formmethod="post">Profesores</button>
                        <button type="submit" class = "leftButton" formaction="IndexAdminMateriaYCursoSV" formmethod="post">Materias y Cursos</button>
                    </form>
                </div>

                <div class="clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
