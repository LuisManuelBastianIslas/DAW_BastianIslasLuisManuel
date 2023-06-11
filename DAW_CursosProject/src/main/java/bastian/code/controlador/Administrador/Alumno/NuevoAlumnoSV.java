package bastian.code.controlador.Administrador.Alumno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "NuevoAlumnoSV", urlPatterns = "/NuevoAlumnoSV")
public class NuevoAlumnoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Otro trampolin
        req.getRequestDispatcher("VistaAdministrador/Alumno/NuevoAlumno.jsp").forward(req, resp);
    }
}
