package bastian.code.controlador;

import bastian.code.datos.RelacionesDAO.LoginDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name ="JoinSV", urlPatterns = {"/JoinSV"} )
public class JoinSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtengo los datos del login
        String usuario = req.getParameter("usuario");
        String contrasena = req.getParameter("contrasena");

        System.out.println(usuario + " " + contrasena);

        //Identifico que tipo de usuatio es y redirecciono
        if ( usuario.toUpperCase().startsWith("B") && Character.isDigit( usuario.charAt(1) ) ) {
            //Busca el login en alumno
            req.setAttribute("user", usuario);
            req.setAttribute("password", contrasena);

            req.getRequestDispatcher("VistaAlumno/IndexAlumno.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtengo los datos del login
        String usuario = req.getParameter("usuario");
        String contrasena = req.getParameter("contrasena");

        System.out.println(usuario + " " + contrasena);

        req.getSession().setAttribute("user", usuario);

        //Identifico que tipo de usuatio es y redirecciono
        if ( usuario.toUpperCase().startsWith("B") && Character.isDigit( usuario.charAt(1) ) ) {
            if ( LoginDAO.existAlumno(usuario, contrasena) )
                req.getRequestDispatcher("VistaAlumno/IndexAlumno.jsp").forward(req, resp);
        } else if ( usuario.toUpperCase().startsWith("B") && Character.isDigit( usuario.charAt(1) ) ) {
            
        }else

        resp.sendRedirect("index.jsp");
    }
}
