<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Calificaciones</title>

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
                        <h2 class = "center">Selecciona la opcion</h2>

                        <div id = "box">
                            <div id = "materiaContainer">
                                <form><button type="submit" class="mainButton" formaction="" formmethod="post">Ver calificaciones de este semestre</button></form>
                            </div>

                            <div id = "materiaContainer">
                                <form><button type="submit" class="mainButton" formaction="" formmethod="post">Ver cardex</button></form>
                            </div>
                        </div>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <form>
                        <button type="submit" class = "leftButton" formaction="InfoPersonalAlumnoSV" formmethod="post">Informacion personal</button>
                        <button type="submit" class = "leftButton" formaction="MateriasSV" formmethod="post">Mis materias</button>
                        <button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Inscripcion</button>
                        <button type="submit" class = "leftButton" formaction="VistaAlumno/Calificaciones/ToIndexCalificacionesSv" formmethod="post">Calificacionnes</button>
                        <button type="submit" class = "leftButton" formaction="CurriculaSV" formmethod="post">Ver Curricula</button>
                    </form>
                </div>

                <div class="clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
