package bastian.code.controlador.Profesor;

import bastian.code.datos.AlumnoDAO;
import bastian.code.modelo.ProfesorJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="TutoradosSV", urlPatterns = {"/TutoradosSV"} )
public class TutoradosSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProfesor = ((ProfesorJB)req.getSession().getAttribute("Profesor")).getIdProfesor();
        req.setAttribute("Tutorados", AlumnoDAO.selectTutorados(idProfesor));

        req.getRequestDispatcher("VistaProfesor/Tutorados.jsp").forward(req, resp);
    }
}
