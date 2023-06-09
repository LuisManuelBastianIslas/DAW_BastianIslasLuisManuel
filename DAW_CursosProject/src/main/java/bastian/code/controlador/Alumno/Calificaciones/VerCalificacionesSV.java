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

@WebServlet (name = "VerCalificacionesSV", urlPatterns = {"/VerCalificacionesSV"})
public class VerCalificacionesSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // En general, mas de lo mismo, pero con algo adicional
        String matriculaAlumno = ((AlumnoJB)req.getSession().getAttribute("Alumno")).getMatriculaAlumno();
        ArrayList<CursoAlumnoJB> cursos = CursoAlumnoDAO.select( matriculaAlumno );

        // Ahora uso un stream para filtar solo las materias que curso o esta cursando el alumno
        //Mientras hacia esto me di cuenta que podia hacer lo mismo con el cardex jajajajaja

        //No funciono, me pide algo de cambiar el nivel de lenguaje, no me puse a investigarlo por falta de tiempo
        //List<CursoAlumnoJB> cursosFiltered = cursos.stream().filter(c -> c.getIdEstatusCursoAlumno() < 4).toList();

        ArrayList<CursoAlumnoJB> cursosFiltered = new ArrayList<>();
        for (CursoAlumnoJB c : cursos) {
            if (c.getIdEstatusCursoAlumno() < 4) {
                cursosFiltered.add(c);
            }
        }

        // Finalmente, lo mando
        req.setAttribute("Cursos", cursosFiltered);
        req.getRequestDispatcher("VistaAlumno/Calificaciones/VerCalificaciones.jsp").forward(req, resp);
    }
}
