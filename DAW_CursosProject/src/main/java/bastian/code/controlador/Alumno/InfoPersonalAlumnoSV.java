package bastian.code.controlador.Alumno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name ="InfoPersonalAlumnoSV", urlPatterns = {"/InfoPersonalAlumnoSV"} )
public class InfoPersonalAlumnoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Realmente lo unico que hace es hacer un trampolin
        req.getRequestDispatcher("VistaAlumno/InfoPersonalAlumno.jsp").forward(req, resp);
    }
}
