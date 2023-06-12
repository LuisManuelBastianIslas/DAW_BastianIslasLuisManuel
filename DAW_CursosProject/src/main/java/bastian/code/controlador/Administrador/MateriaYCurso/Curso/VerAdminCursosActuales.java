package bastian.code.controlador.Administrador.MateriaYCurso.Curso;

import bastian.code.datos.CatalogosDAO.CarreraDAO;
import bastian.code.datos.RelacionesDAO.CursoDAO;
import bastian.code.modelo.CatalogosJB.CarreraJB;
import bastian.code.modelo.RelacionesJB.CursoJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "VerAdminCursosActuales", urlPatterns = {"/VerAdminCursosActuales"})
public class VerAdminCursosActuales extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = 1;
        ArrayList<ArrayList<CursoJB>> cursosCarrera = null;

        if (req.getSession().getAttribute("Cursos") == null) {
            // Obtengo la lista de los cursos actuales
            ArrayList<CursoJB> cursos = CursoDAO.select();

            // Lo transformo, separandolo por Carreras
            cursosCarrera = new ArrayList<>();
            for (CarreraJB c : CarreraDAO.select())
                cursosCarrera.add(new ArrayList<>());

            // Lleno el ArrayList
            for (CursoJB c : cursos)
                cursosCarrera.get( c.getAsignatura().getCarrera().getIdCarrera()-1 ).add(c);

            // Lo guardo para la paginacion
            req.getSession().setAttribute("Cursos", cursosCarrera);
        }
        else
            cursosCarrera = (ArrayList<ArrayList<CursoJB>>) req.getSession().getAttribute("Cursos");

        if (req.getParameter("Index") != null)
            index = Integer.parseInt(req.getParameter("Index"));


        req.setAttribute("CursosCarrera", cursosCarrera.get(index-1));
        req.setAttribute("Index", index);
        req.getRequestDispatcher("VistaAdministrador/MateriaYCurso/Curso/VerAdminCursosActuales.jsp").forward(req, resp);
    }
}
