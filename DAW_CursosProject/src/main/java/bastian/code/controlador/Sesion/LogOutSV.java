package bastian.code.controlador.Sesion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "LogOutSV", urlPatterns = "/LogOutSV")
public class LogOutSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("Alumno");
        req.getSession().removeAttribute("Profesor");
        req.getSession().removeAttribute("Administrador");

        req.getSession().removeAttribute("TypeUser");
        req.getSession().removeAttribute("estudios");

        req.getSession().removeAttribute("Alumnos");

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
