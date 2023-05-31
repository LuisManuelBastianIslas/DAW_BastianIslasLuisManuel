package bastian.code.controlador.Profesor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name ="InfoPersonalProfesorSV", urlPatterns = {"/InfoPersonalProfesorSV"} )
public class InfoPersonalProfesorSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Solo funciona de tarmpolin
        req.getRequestDispatcher("/VistaProfesor/InfoPersonalProfesor.jsp").forward(req, resp);
    }
}
