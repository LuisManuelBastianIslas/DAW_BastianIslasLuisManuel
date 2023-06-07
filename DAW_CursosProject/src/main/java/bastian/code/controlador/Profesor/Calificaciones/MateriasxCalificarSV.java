package bastian.code.controlador.Profesor.Calificaciones;

import bastian.code.datos.RelacionesDAO.CursoDAO;
import bastian.code.modelo.ProfesorJB;
import bastian.code.modelo.RelacionesJB.CursoJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "MateriasxCalificarSV", urlPatterns = "/MateriasxCalificarSV")
public class MateriasxCalificarSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Primero obtengo el ArrayList de los cursos que está impartiendo este semestre
        String idProfesor = ((ProfesorJB)req.getSession().getAttribute("Profesor")).getIdProfesor();
        ArrayList<CursoJB> cursos = CursoDAO.select( idProfesor );

        // Luego lo paso
        req.setAttribute("Cursos", cursos);
        req.getRequestDispatcher("VistaProfesor/Calificaciones/Materias.jsp").forward(req, resp);
    }
}
