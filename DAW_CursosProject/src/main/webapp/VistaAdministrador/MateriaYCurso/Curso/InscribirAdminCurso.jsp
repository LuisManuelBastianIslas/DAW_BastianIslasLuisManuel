<%@ page import="bastian.code.modelo.CatalogosJB.CarreraJB" %>
<%@ page import="bastian.code.datos.CatalogosDAO.CarreraDAO" %>
<%@ page import="bastian.code.modelo.AsignaturaJB" %>
<%@ page import="bastian.code.datos.AsignaturaDAO" %>
<%@ page import="bastian.code.datos.CatalogosDAO.PeriodoDAO" %>
<%@ page import="bastian.code.modelo.CatalogosJB.PeriodoJB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Administrador - Inscribir Cursos</title>

        <link href="default.css" rel="stylesheet"/>
    </head>

    <body onload="initialiceMaxDays()">
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
                        <h2 class = "center">Ingresa los datos</h2>

                        <div id = "paginacion">
                            <form action = "InscribirAdminCursoSV" method = "post">
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

                        <div id = "box">
                            <form action="" method="post" id = "AddCursoForm">
                                <div id = "leftColumn">
                                    <p>Asignatutra</p>
                                </div>

                                <div id = "rightColumn">
                                    <select name="Asignatura" id="slAsignatura" onchange="setMaxDays()">
                                        <%
                                            int idCarrera = (Integer) request.getAttribute("IdCarrera");
                                            PeriodoJB nextPeriodo = PeriodoDAO.select( PeriodoDAO.getPeriodoActual().getNextIdPeriodo() );
                                            for (AsignaturaJB a : AsignaturaDAO.selectAviable( nextPeriodo.getIdPeriodo(), idCarrera, nextPeriodo.getPeriodo() ))
                                                out.println("<option value = \"" + a.getNrc() + "\">" + a.getNrc() + " - " + a.getMateria().getNombreMateria() + "</option>");
                                        %>
                                    </select>
                                </div>

                                <div class = "clear"></div>

                                <div id = "materiaContainer">
                                    <div id = "materia">
                                        <input type="checkbox" name="Lunes" id = "lunes" class="try" onchange="validateCheckBoxes(this)">
                                        <label for="lunes">Lunes</label><br>
                                    </div>
                                </div>

                                <div id = "materiaContainer">
                                    <div id = "materia">
                                        <input type="checkbox" name="Martes" id = "martes" class="try" onchange="validateCheckBoxes(this)">
                                        <label for="martes">Martes</label><br>
                                    </div>
                                </div>

                                <div id = "materiaContainer">
                                    <div id = "materia">
                                        <input type="checkbox" name="Miercoles" id = "miercoles" class="try" onchange="validateCheckBoxes(this)">
                                        <label for="miercoles">Miercoles</label><br>
                                    </div>
                                </div>

                                <div id = "materiaContainer">
                                    <div id = "materia">
                                        <input type="checkbox" name="Jueves" id = "jueves" class="try" onchange="validateCheckBoxes(this)">
                                        <label for="jueves">Jueves</label><br>
                                    </div>
                                </div>

                                <div id = "materiaContainer">
                                    <div id = "materia">
                                        <input type="checkbox" name="Viernes" id = "viernes" class="try" onchange="validateCheckBoxes(this)">
                                        <label for="viernes">Viernes</label><br>
                                    </div>
                                </div>
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
    
        <%--    Aqui el script  --%>
        <script>
            maxDays = 0;
            const mapMaxDays = new Map();

            function initialiceMaxDays() {
                mapMaxDays.clear();
                <%
                    for (AsignaturaJB a : AsignaturaDAO.selectAviable( nextPeriodo.getIdPeriodo(), idCarrera, nextPeriodo.getPeriodo() ))
                        out.println("mapMaxDays.set(" + a.getNrc() + ", " + a.getMateria().getHoras() + ");");
                %>

                setMaxDays();
            }

            function setMaxDays() {
                select = document.getElementById('slAsignatura');
                indxSelected = select.selectedIndex;
                nrc = select.options[indxSelected].value;
                maxDays = mapMaxDays.get(nrc);

                let checkboxes = document.getElementsByClassName('try');
                for (var i = 0; i < checkboxes.length; i++)
                    checkboxes[i].checked = false;
            }

            function validateCheckBoxes(chckBx) {
                // Creo que obtengo la colección de todos los objetos del form
                let checkboxes = document.getElementsByClassName('try');
                cantSelected = 0;

                if (chckBx.checked) {
                    for (i = 0; i < checkboxes.length; i++)
                        if (checkboxes[i].checked == true)
                            cantSelected++;

                    if (cantSelected >= maxDays)
                        chckBx.checked = false;
                }
            }
        </script>
    </body>
</html>
