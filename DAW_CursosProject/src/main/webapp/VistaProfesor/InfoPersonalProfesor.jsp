<%@ page import="bastian.code.modelo.ProfesorJB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>

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
                        <h2 class = "center">Iformacion Personal</h2>

                        <div id = "leftColumn">
                            <p>CURP:</p>
                            <p>Nombre:</p>
                            <p>Apellidos:</p>
                            <p>Genero:</p>
                            <p>Fecha de Nacimiento:</p>
                            <p>Edad:</p>
                            <p>Dirección:</p>
                            <p>Telefóno:</p>
                            <p>Celular:</p>
                            <p>Email:</p>
                        </div>

                        <div id = "rightColumn">
                            <%
                                ProfesorJB profesor = (ProfesorJB) request.getSession().getAttribute("Profesor");
                                out.println("<p>" + profesor.getCurp() + "</p>");
                                out.println("<p>" + profesor.getNombre() + "</p>");
                                out.println("<p>" + profesor.getApellidoPaterno() + " " + profesor.getApleiidoMaterno() + "</p>");
                                out.println("<p>" + profesor.getGenero().getNombreGenero() + "</p>");
                                out.println("<p>" + profesor.getFechaNacimiento() + "</p>");
                                out.println("<p>" + profesor.getEdad() + "</p>");
                                out.println("<p>" + profesor.getDireccion() + "</p>");
                                out.println("<p>" + profesor.getTelefono() + "</p>");
                                out.println("<p>" + profesor.getCelular() + "</p>");
                                out.println("<p>" + profesor.getEmail() + "</p>");
                            %>
                        </div>

                        <form action="EstudioProfesorSV" method="post">
                            <input type="submit" value="Ver informacion Profesional">
                        </form>
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
