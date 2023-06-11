package bastian.code.controlador.Administrador.MateriaYCurso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "IndexAdminMateriaYCursoSV", urlPatterns = {"/IndexAdminMateriaYCursoSV"})
public class IndexAdminMateriaYCursoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Mas trampolines
        req.getRequestDispatcher("VistaAdministrador/MateriaYCurso/IndexAdminMateriaYCurso.jsp").forward(req, resp);
    }
}
