package bastian.code.controlador.Alumno.Calificaciones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "ToIndexCalificacionesAlumnoSV", urlPatterns = {"/ToIndexCalificacionesAlumnoSV"})
public class ToIndexCalificacionesAlumnoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Solo funciona de trampolin
        req.getRequestDispatcher("VistaAlumno/Calificaciones/IndexCalificaciones.jsp").forward(req, resp);
    }
}
