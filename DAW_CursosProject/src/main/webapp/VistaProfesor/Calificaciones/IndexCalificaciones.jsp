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
                                <form><button type="submit" class="mainButton" formaction="" formmethod="post">Historial de Calificaciones</button></form>
                            </div>

                            <div id = "materiaContainer">
                                <form><button type="submit" class="mainButton" formaction="" formmethod="post">Calificar este Semestre</button></form>
                            </div>
                        </div>
                    </div>
                </div>

                <div id = "secondaryContent">
                    <h3>Otras funciones</h3>

                    <form>
                        <button type="submit" class = "leftButton" formaction="InfoPersonalProfesorSV" formmethod="post">Informacion personal</button>
                        <button type="submit" class = "leftButton" formaction="HorarioProfesorSV" formmethod="post">Horario</button>
                        <button type="submit" class = "leftButton" formaction="TutoradosSV" formmethod="post">Tutorados</button>
                        <button type="submit" class = "leftButton" formaction="" formmethod="post">Calificacionnes</button>
                    </ul>
                    </form>
                </div>

                <div class="clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
