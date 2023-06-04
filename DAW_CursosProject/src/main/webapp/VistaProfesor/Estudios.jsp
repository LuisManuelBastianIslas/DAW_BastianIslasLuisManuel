<%@ page import="bastian.code.modelo.RelacionesJB.EstudioJB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Estudios</title>

        <link href="default.css" rel="stylesheet"/>

        <%
            boolean isEmpty = ((ArrayList<EstudioJB>)request.getSession().getAttribute("estudios")).isEmpty();
        %>
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

                        <form action="CRUDEstudioSV" method="post" class="crudform">
                            <button type="submit" name="action" value="agregar" class="first">Agregar nuevo</button>
                            <button type="submit" name="action" value="modificar">Modificar actual</button>
                            <button type="submit" name="action" value="eliminar">Eliminar actual</button>
                        </form>

                        <div id = "leftColumn">
                            <%
                                if (!isEmpty) {
                                    out.println("<p>Universidad:</p>");
                                    out.println("<p>Titulo:</p>");
                                    out.println("<p>Cedula:</p>");
                                    out.println("<p>Año de Graduación:</p>");
                                    out.println("<p>Estudio:</p>");
                                }
                            %>
                        </div>

                        <div id = "rightColumn">
                            <%
                                if (!isEmpty) {
                                    EstudioJB estudio = ((ArrayList<EstudioJB>) request.getSession().getAttribute("estudios")).get((Integer) request.getAttribute("indexEstudio") - 1);
                                    out.println("<p>" + estudio.getUniversidad() + "</p>");
                                    out.println("<p>" + estudio.getTitulo() + "</p>");
                                    out.println("<p>" + estudio.getCedula() + "</p>");
                                    out.println("<p>" + estudio.getAnoGraduacion() + "</p>");
                                    out.println("<p>" + estudio.getTipoEstudio().getNombre() + "</p>");
                                }
                            %>
                        </div>

                        <div id = "paginacion">
                            <form action="EstudioProfesorSV" method="post">
                                <%
                                    int cantEstudios =  ((ArrayList<EstudioJB>) request.getSession().getAttribute("estudios")).size();
                                    int selected = (Integer) request.getAttribute("indexEstudio");
                                    for (int i = 1; i <= cantEstudios; i++) {
                                        if (i == selected)
                                            out.println("<button type=\"submit\" class=\"activo\" name=\"indexEstudio\" value=\"" + i + "\">" + i + "</button>");
                                        else
                                            out.println("<button type=\"submit\" name=\"indexEstudio\" value=\"" + i + "\">" + i + "</button>");
                                    }
                                %>
                            </form>
                        </div>

                        <%--    Al final, si esta vacio, muestra el mesnaje --%>
                        <%
                            if (isEmpty)
                                out.println("<h3 class = \"center\">No tienes estudios cargados, itenta ingresar uno nuevo</h3>");
                        %>
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