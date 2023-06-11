package bastian.code.controlador.Administrador.Alumno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "IndexAdminALumnoSV", urlPatterns = {"/IndexAdminALumnoSV"})
public class IndexAdminALumnoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Simplemente un trampolin
        req.getRequestDispatcher("VistaAdministrador/Alumno/IndexAdminAlumno.jsp").forward(req, resp);
    }
}
