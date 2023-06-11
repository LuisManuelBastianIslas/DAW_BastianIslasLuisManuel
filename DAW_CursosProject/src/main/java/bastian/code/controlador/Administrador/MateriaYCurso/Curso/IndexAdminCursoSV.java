package bastian.code.controlador.Administrador.MateriaYCurso.Curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "IndexAdminCursoSV", urlPatterns = {"/IndexAdminCursoSV"})
public class IndexAdminCursoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Creo que empezaré a dejar de poner estas anotaciones
        req.getRequestDispatcher("VistaAdministrador/MateriaYCurso/Curso/IndexAdminCurso.jsp").forward(req, resp);
    }
}
