<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.MateriaJB" %>
<%@ page import="bastian.code.datos.CatalogosDAO.CarreraDAO" %>
<%@ page import="bastian.code.modelo.CatalogosJB.CarreraJB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%--Aqui obtendré las variables con los requests--%>
        <%
            CarreraJB carrera = (CarreraJB) request.getAttribute("Carrera");
            ArrayList<ArrayList<MateriaJB>> matrizMaterias = (ArrayList<ArrayList<MateriaJB>>) request.getAttribute("matrizMaterias");
        %>

        <title>Curricula - <%=carrera.getNombreCarrera()%></title>

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
                        <h2 class="center">Curricula de <%=carrera.getNombreCarrera()%></h2>
                        <%
                            int i = 1;
                            out.println("<table>");
                            for (ArrayList<MateriaJB> materias : matrizMaterias) {
                                out.println("<tr>");
                                out.println("<td>Semestre " + i++ + "</td>");
                                for (MateriaJB materia : materias)
                                    out.println("<td><pre>" + materia.getNombreMateria() + "\n" +
                                                materia.getCreditos() + "cr - " + materia.getHoras() + "h</pre></td>");
                                out.println("</tr>");
                            }
                            out.println("</table>");
                        %>
                    </div>
                </div>

                <div id ="secondaryContent">
                    <h3>Semestres:</h3>
                    <p><%=carrera.getCantidadSemestres()%></p>
                    <br>
                    <h3>Creditos:</h3>
                    <p><%=carrera.getCantidadCreditos()%></p>
                </div>
            </div>
        </div>
    </body>
</html>