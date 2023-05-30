<%-- De aqui en adelnate, seran las vistas de los Administradores --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Direccion - Inicio</title>

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

            <h2 class = "center">Hola de nuevo <%=request.getSession().getAttribute("TypeUser")%></h2>

            <form class="formButtons">
                <table>
                    <tr>
                        <td><button type="submit" class = "mainButton" formaction="InfoPersonalAlumnoSV" formmethod="post">Estudiantes</button></td>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Profesores</button></td>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Materias y Cursos</button></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Informacion personal</button></td>
                        <td><button type="submit" class = "mainButton" <%--formaction="" formmethod="post" name="otro"--%>>Ver materias</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
