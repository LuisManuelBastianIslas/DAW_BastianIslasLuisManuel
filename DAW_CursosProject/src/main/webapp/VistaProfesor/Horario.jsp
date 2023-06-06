<%@ page import="java.util.ArrayList" %>
<%@ page import="bastian.code.modelo.RelacionesJB.CursoJB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Horario</title>
    </head>

    <body>
        <%
          ArrayList<CursoJB> cursos = (ArrayList<CursoJB>) request.getAttribute("Cursos");
          for (CursoJB curso : cursos)
            out.println(curso.getAsignatura().getMateria().getNombreMateria());
        %>
    </body>
</html>
