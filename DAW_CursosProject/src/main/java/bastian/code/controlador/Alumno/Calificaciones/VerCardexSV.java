package bastian.code.controlador.Alumno.Calificaciones;

import bastian.code.datos.RelacionesDAO.CursoAlumnoDAO;
import bastian.code.modelo.AlumnoJB;
import bastian.code.modelo.RelacionesJB.CursoAlumnoJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "VerCardexSV", urlPatterns = {"/VerCardexSV"})
public class VerCardexSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lo mismo de siempre, obtengo lo que voy a usar aqui
        String matriculaAlumno = ((AlumnoJB)req.getSession().getAttribute("Alumno")).getMatriculaAlumno();
        ArrayList<CursoAlumnoJB> cursos = CursoAlumnoDAO.selectAproved( matriculaAlumno );

        // Y lo mando...
        req.setAttribute("Cursos", cursos);
        req.getRequestDispatcher("VistaAlumno/Calificaciones/VerCardex.jsp").forward(req, resp);
    }
}
