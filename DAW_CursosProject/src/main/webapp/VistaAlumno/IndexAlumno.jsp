<%-- De aqui en adelnate, seran las vistas de los alumnos --%>
<%@ page import="bastian.code.modelo.AlumnoJB" %>
<html>
    <head>
        <title>Alumnos - Inicio</title>

        <link href="default.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="outer">
            <div id="header">
                <h1>Bastian Universities</h1>
            </div>
            <div id="menu">
                <ul>
                    <li class="first"><a href="#">Inicio</a></li>
                    <li><a href="LogOutSV">Log out</a></li>
                </ul>
            </div>

                <%
                    String usuario = ((AlumnoJB)request.getSession().getAttribute("Alumno")).getNombre();
                    String genero = ((AlumnoJB)request.getSession().getAttribute("Alumno")).getGenero();
                    if (genero.equals("M"))
                        out.println("<h2 class=\"center\">Bienvenido de nuevo " + usuario + "</h2>");
                    else
                        out.println("<h2 class=\"center\">Bienvenida de nuevo " + usuario + "</h2>");
                %>
            <%--
                <%
                    AlumnoJB Alumno = (AlumnoJB) request.getSession().getAttribute("Alumno");
                    if (Alumno != null){
                        out.println("<p>CURP:\t" + Alumno.getCurp() + "</p>");
                        out.println("<p>Nombre:\t" + Alumno.toString() + "</p>");
                        out.println("<p>Fecha:\t" + Alumno.getFechaNacimiento() + "</p>");
                        out.println("<p>Genero:\t" + Alumno.getGenero() + "</p>");
                        out.println("<p>Telefono:\t" + Alumno.getTelefono() + "</p>");
                        out.println("<p>Celular:\t" + Alumno.getCelular() + "</p>");
                        out.println("<p>Matricula:\t" + Alumno.getMatriculaAlumno() + "</p>");
                        out.println("<p>Carrera:\t" + Alumno.getCarrera().getNombreCarrera() + "</p>");
                        out.println("<p>Año Inscripcion:\t" + Alumno.getAnoInscripcion() + "</p>");
                        out.println("<p>Estatus:\t" + Alumno.getEstatusAlumno().getNombre() + "</p>");
                        out.println("<p>Tutor:\t" + Alumno.getProfesor() + "</p>");
                }
            %>
            --%>
            <form class="formButtons">
                <table>
                    <tr>
                        <td><button type="submit" <%--formaction="" formmethod="post" name="otro"--%>>Informacion personal</button></td>
                        <td><button type="submit" <%--formaction="" formmethod="post" name="otro"--%>>Mis materias</button></td>
                        <td><button type="submit" <%--formaction="" formmethod="post" name="otro"--%>>Inscripcion</button></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><button type="submit" <%--formaction="" formmethod="post" name="otro"--%>>Informacion personal</button></td>
                        <td><button type="submit" <%--formaction="" formmethod="post" name="otro"--%>>Ver materias</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
