package bastian.code.controlador.Administrador.MateriaYCurso.Curso;

import bastian.code.datos.CatalogosDAO.CarreraDAO;
import bastian.code.modelo.CatalogosJB.CarreraJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "InscribirAdminCursoSV", urlPatterns = {"/InscribirAdminCursoSV"})
public class InscribirAdminCursoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Este servlet tambien maneja paginacion para seleccionar la carrera
        int index = 1;

        // Como es un ArrayList simple, no lo voy a giardar en la sesion
        ArrayList<CarreraJB> carreras = CarreraDAO.select();

        if(req.getParameter("Index") != null)
            index = Integer.parseInt(req.getParameter("Index"));

        // Mando solamente la carrera en cuestion y el Index
        req.setAttribute("Carrera", carreras.get(index-1));
        req.setAttribute("IdCarrera", carreras.get(index-1).getIdCarrera());
        req.setAttribute("Index", index);
        req.getRequestDispatcher("VistaAdministrador/MateriaYCurso/Curso/InscribirAdminCurso.jsp").forward(req, resp);
    }
}
