package bastian.code.controlador.Sesion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name ="RedirectInicioSV", urlPatterns = {"/RedirectInicioSV"} )
public class RedirectInicioSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeUser = (String) req.getSession().getAttribute("TypeUser");
        System.out.println(typeUser + "\nPara eliminar este mensaje esta en RedirectInicioSV");

        if ( typeUser.equals("Alumno") ) {
            //Aqui removeré todos los atributos que vaya generando


        }

        //Al final redireccionaré por igual
        req.getRequestDispatcher("VistaAlumno/Index" + typeUser + ".jsp").forward(req, resp);
    }
}
