package bastian.code.controlador.Profesor;

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

@WebServlet(name ="HorarioProfesorSV", urlPatterns = {"/HorarioProfesorSV"} )
public class HorarioProfesorSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProfesor = ((ProfesorJB)req.getSession().getAttribute("Profesor")).getIdProfesor();
        ArrayList<CursoJB> cursos = CursoDAO.select( idProfesor );

        req.setAttribute("Cursos", cursos);
        req.getRequestDispatcher("VistaProfesor/Horario.jsp").forward(req, resp);
    }
}
