<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Administrador - Materias y Cursos</title>

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

                        <form class="formButtons">
                            <div id = "materiaContainer">
                                <button type="submit" class = "mainButton" formaction="" formmethod="post">Administrar Materias</button>
                            </div>

                            <div id = "materiaContainer">
                                <button type="submit" class = "mainButton" formaction="IndexAdminCursoSV" formmethod="post">Administrar Cursos</button>
                            </div>
                        </form>
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
