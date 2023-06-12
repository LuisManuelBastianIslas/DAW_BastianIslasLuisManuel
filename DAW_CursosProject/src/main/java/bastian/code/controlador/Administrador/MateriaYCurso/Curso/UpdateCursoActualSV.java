package bastian.code.controlador.Administrador.MateriaYCurso.Curso;

import bastian.code.datos.CatalogosDAO.PeriodoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "UpdateCursoActualSV", urlPatterns = {"/UpdateCursoActualSV"})
public class UpdateCursoActualSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Primero obtengo el parametro del form
        int idPeriodo = Integer.parseInt(req.getParameter("IdPeriodo"));

        // Si es menor a 0 (-1) es porque se quiere añadir un nuevo periodo
        if (idPeriodo > 0)
            PeriodoDAO.setPeriodoActual(idPeriodo);
        else
            PeriodoDAO.insert();

        // Al final redirecciona a la misma pagina para simula una simple actualzacion :)
        req.getRequestDispatcher("VistaAdministrador/MateriaYCurso/Curso/IndexAdminCurso.jsp").forward(req, resp);
    }
}
