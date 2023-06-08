package bastian.code.controlador.Profesor.Calificaciones;

import bastian.code.datos.RelacionesDAO.CursoAlumnoDAO;
import bastian.code.modelo.RelacionesJB.CursoAlumnoJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "CalificarCursoSV", urlPatterns = "/CalificarCursoSV")
public class CalificarCursoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Como en muchos otros casos, primero obtengo
        int nrc = Integer.parseInt( req.getParameter("NRC") );
        ArrayList<CursoAlumnoJB> alumnos = CursoAlumnoDAO.select(nrc);

        // Para despues mandarlo
        req.setAttribute("Alumnos", alumnos);
        req.getRequestDispatcher("VistaProfesor/Calificaciones/Calificaciones.jsp").forward(req, resp);
    }
}
