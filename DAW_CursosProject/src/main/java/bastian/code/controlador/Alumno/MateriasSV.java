package bastian.code.controlador.Alumno;

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

@WebServlet(name ="MateriasSV", urlPatterns = {"/MateriasSV"} )
public class MateriasSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Primero Busca los cursos del periodo actual
        String matricula = ((AlumnoJB) req.getSession().getAttribute("Alumno")).getMatriculaAlumno();
        ArrayList<CursoAlumnoJB> cursos = CursoAlumnoDAO.select( matricula );

        // Y lo pasa como parametro
        req.setAttribute("Cursos", cursos);
        req.getRequestDispatcher("VistaAlumno/Materias.jsp").forward(req, resp);
    }
}
