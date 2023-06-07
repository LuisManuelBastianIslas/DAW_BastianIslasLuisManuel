package bastian.code.controlador.Profesor.Calificaciones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "CalificacionesProfesorSV", urlPatterns = {"/CalificacionesProfesorSV"})
public class CalificacionesProfesorSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Este servlet es solo un trampolin
        req.getRequestDispatcher("VistaProfesor/Calificaciones/IndexCalificaciones.jsp").forward(req, resp);
    }
}
