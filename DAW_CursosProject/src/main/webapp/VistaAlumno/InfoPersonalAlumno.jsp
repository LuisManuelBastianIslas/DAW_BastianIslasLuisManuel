<%@ page import="bastian.code.modelo.AlumnoJB" %>
<%--
  Solo despliega la informacion personal y si quiere modificarla el alumno, aqui puede
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Informacion personal</title>

    <link href="default.css" rel="stylesheet"/>
    </head>

    <body>
        <div id = "outer">
            <div id = "header">
                <h1>Bastian Universities</h1>
            </div>

            <div id="menu">
                <ul>
                    <li class="first"><a href="RedirectInicioSV">Inicio</a></li>
                    <li><a href="LogOutSV">Log out</a></li>
                </ul>
            </div>

            <div id = "content">
                <%-- <div id = "tertiaryContent"></div> --%>
                <div id = "primaryContentContainer">
                    <div id = "primaryContent">
                        <h2 class = "center">Informacion personal</h2>
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
                                AlumnoJB alumno = (AlumnoJB) request.getSession().getAttribute("Alumno");
                                out.println("<p>" + alumno.getCurp() + "</p>");
                                out.println("<p>" + alumno.getNombre() + "</p>");
                                out.println("<p>" + alumno.getApellidoPaterno() + " " + alumno.getApleiidoMaterno() + "</p>");
                                out.println("<p>" + alumno.getGenero().getNombreGenero() + "</p>");
                                out.println("<p>" + alumno.getFechaNacimiento() + "</p>");
                                out.println("<p>" + alumno.getEdad() + "</p>");
                                out.println("<p>" + alumno.getDireccion() + "</p>");
                                out.println("<p>" + alumno.getTelefono() + "</p>");
                                out.println("<p>" + alumno.getCelular() + "</p>");
                                out.println("<p>" + alumno.getEmail() + "</p>");
                            %>
                        </div>

                        <form action="EstudioAlumnoSV" method="post">
                            <input type="submit" value="Ver informacion Profesional">
                        </form>
                    </div>
                </div>

                <div id = "secondaryContent">
                      <h3>Otras funciones</h3>

                      <ul class="none">
                          <li><button type="submit" class = "leftButton" formaction="InfoPersonalAlumnoSV" formmethod="post">Informacion personal</button></li>
                          <li><button type="submit" class = "leftButton" formaction="MateriasSV" formmethod="post">Mis materias</button></li>
                          <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Inscripcion</button></li>
                          <li><button type="submit" class = "leftButton" <%--formaction="" formmethod="post" name="otro"--%>>Calificacionnes</button></li>
                          <li><button type="submit" class = "leftButton" formaction="CurriculaSV" formmethod="post">Ver Curricula</button></li>
                      </ul>
                </div>

                <div class="clear"></div>
            </div>

            <div id = "footer"></div>
        </div>
    </body>
</html>
