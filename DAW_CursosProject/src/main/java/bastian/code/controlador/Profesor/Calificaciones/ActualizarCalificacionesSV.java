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

@WebServlet (name = "ActualizarCalificacionesSV", urlPatterns = {"/ActualizarCalificacionesSV"})
public class ActualizarCalificacionesSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Simplemente recorre la lista de alumnos y les da su calificacion
        ArrayList<CursoAlumnoJB> alumnos = (ArrayList<CursoAlumnoJB>) req.getSession().getAttribute("Alumnos");
        alumnos.forEach(a -> {
            System.out.println(a.getMatriculaAlumno() + "\nPara eliminar esto, esta en ActualizarCalificacionesSV");
            int calificacion = Integer.parseInt( req.getParameter(a.getMatriculaAlumno()) );
            CursoAlumnoDAO.updateCalificar(a.getMatriculaAlumno(), a.getNrc(), calificacion, calificacion < 6 ? 3 : 2);
        });

        // Finalmente remuevo atributos y redirecciono
        req.getSession().removeAttribute("Alumnos");
        req.getRequestDispatcher("/MateriasxCalificarSV").forward(req, resp);
    }
}
