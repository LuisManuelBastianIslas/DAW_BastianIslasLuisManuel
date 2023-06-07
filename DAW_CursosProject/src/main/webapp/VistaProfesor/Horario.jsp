<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoJB" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoSalonJB" %>
<%@ page import="bastian.code.datos.Utilities" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Horario</title>

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
                        <h2 class = "center">Horario</h2>

                        <div id = "box">
                            <%
                                //Queria usar un stream para "parsear" el ArrayList a Map, pero no jalo :(
                                Utilities util = new Utilities();

                                ArrayList<CursoJB> cursos = (ArrayList<CursoJB>) request.getAttribute("Cursos");

                                if( cursos.isEmpty() )
                                    out.println("<h3 class = \"center\">No tienes materias cargadas este semestre</h3>");
                                else {
                                    ArrayList<ArrayList<CursoSalonJB>> Cursos = (ArrayList<ArrayList<CursoSalonJB>>) util.getGenericArrayList();

                                    for (int i = 0; i < 5; i++) // 5 arrays: 1 para cada dia de la semana
                                        Cursos.add((ArrayList<CursoSalonJB>) util.getGenericArrayList());

                                    // Aqui inicializo el array de arrays separado por dias
                                    for (CursoJB s : cursos)
                                        for (CursoSalonJB hs : s.createCursoSalon())
                                            Cursos.get(hs.getIntDiaSemana() - 1).add(hs);

                                    //Aqui esta el contenido de la tabla, usando el array de arrays ya separado
                                    for (int i = 0; i < 5; i++) {
                                        if (!Cursos.get(i).isEmpty()) {
                                            out.println("<div id = \"materiaContainer\">");
                                            out.println("<div id = \"materia\">");
                                            out.println("<h3>" + Cursos.get(i).get(0).getDiaSemana() + "</h3>");
                                            for (CursoSalonJB h : Cursos.get(i)) {
                                                out.println("<br><p>" + h.getAsignatura().getMateria().getNombreMateria() + "</p>");
                                                out.println("<p>" + h.getAsignatura().getCarrera().getNombreCarrera() + "</p>");
                                                out.println("<p>" + h.getIdSalon() + " " + h.getHorario() + "</p>");
                                            }
                                            out.println("</div></div>");
                                        }
                                    }
                                }
                            %>
                        </div>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <ul class="none">
                        <li><button type="submit" class = "leftButton" formaction="InfoPersonalProfesorSV" formmethod="post">Informacion personal</button></li>
                        <li><button type="submit" class = "leftButton" formaction="HorarioProfesorSV" formmethod="post">Horario</button></li>
                        <li><button type="submit" class = "leftButton" formaction="TutoradosSV" formmethod="post">Tutorados</button></li>
                        <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Calificacionnes</button></li>
                    </ul>
                </div>

                <div class="clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
