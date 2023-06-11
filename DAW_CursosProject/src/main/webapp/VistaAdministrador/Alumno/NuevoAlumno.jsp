<%@ page import="bastian.code.modelo.CatalogosJB.GeneroJB" %>
<%@ page import="bastian.code.datos.CatalogosDAO.GeneroDAO" %>
<%@ page import="bastian.code.modelo.CatalogosJB.CarreraJB" %>
<%@ page import="bastian.code.datos.CatalogosDAO.CarreraDAO" %>
<%@ page import="bastian.code.datos.AlumnoDAO" %>
<%@ page import="bastian.code.datos.CatalogosDAO.PeriodoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Adminsitrador - Nuevo Alumno</title>

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
                        <div id = "box">
                            <div id = "materiaContainer">
                                <form action = "AddNuevoAlumnoSV" method = "post" autocomplete="off">
                                    <div id = "leftColumn">
                                        <p>CURP:</p>
                                        <p>Nombre(s):</p>
                                        <p>Apellido Paterno:</p>
                                        <p>Apellido Materno:</p>
                                        <p>Genero:</p>
                                        <p>Fecha de nacimiento:</p>
                                        <p>Dirección:</p>
                                        <p>Teléfono:</p>
                                        <p>Celular:</p>
                                        <p>Carrera:</p>
                                    </div>

                                    <div id = "rightColumn">
                                        <input type="text" name="CURP" required>
                                        <input type="text" name="Nombre" required>
                                        <input type="text" name="ApellidoPaterno" required>
                                        <input type="text" name="ApellidoMaterno" required>
                                        <select name="IdGenero">
                                            <%
                                                for (GeneroJB g : GeneroDAO.select())
                                                    out.println("<option value=\"" + g.getIdGenero() + "\">" + g.getNombreGenero() + "</option>");
                                            %>
                                        </select><br>
                                        <input type="date" name="FechaNacimiento" required><br>
                                        <input type="text" name="Direccion" required>
                                        <input type="text" name="Telefono" pattern="[0-9]{10}" title="Campo solo numerico de 10 digitos">
                                        <input type="text" name="Celular" pattern="[0-9]{10}" title="Campo solo numerico de 10 digitos">
                                        <select name="IdCarrera">
                                            <%
                                                for (CarreraJB c : CarreraDAO.select())
                                                    out.println("<option value=\"" + c.getIdCarrera() + "\">" + c.getNombreCarrera() + "</option>");
                                            %>
                                        </select>
                                    </div>

                                    <div class="clear"></div>

                                    <input type="submit" value="Crear nuevo alumno">
                                </form>
                            </div>
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

                    <br>

                    <h3>Cantidad de alumnos</h3>

                    <%
                        AlumnoDAO dao = new AlumnoDAO();
                        out.println("<ul>");
                        for (CarreraJB c : CarreraDAO.select()) {
                            int cantAlumnos = dao.getCantAlumnos(PeriodoDAO.getPeriodoActual().getAno(), c.getIdCarrera());

                            out.println("<li>");
                            if (cantAlumnos < 3)   // 3 es el cupo minimo por el momento
                                out.println("Faltan " + (3 - cantAlumnos) + " para el cupo minimo en la carrera de " + c.getNombreCarrera());
                            else
                                out.println("La carrera " + c.getNombreCarrera() + " tiene cupo suficiente");
                            out.println("</li>");
                        }
                        out.println("</ul>");
                    %>
                </div>

                <div class = "clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
