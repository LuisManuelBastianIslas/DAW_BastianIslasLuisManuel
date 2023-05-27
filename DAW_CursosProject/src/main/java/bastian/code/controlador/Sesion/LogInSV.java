package bastian.code.controlador.Sesion;

import bastian.code.datos.AlumnoDAO;
import bastian.code.datos.RelacionesDAO.LoginDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name ="LogInSV", urlPatterns = {"/LogInSV"} )
public class LogInSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtengo los datos del login
        String usuario = req.getParameter("usuario");
        String contrasena = req.getParameter("contrasena");

        System.out.println("\n"+ usuario + " " + contrasena + "\nPara eliminar este mensaje, esta en LogInSV");

        //Identifico que tipo de usuatio es y redirecciono
        if ( usuario.toUpperCase().startsWith("B") && Character.isDigit( usuario.charAt(1) ) ) {
            //Busca el login en alumno
            if ( LoginDAO.existAlumno(usuario, contrasena) ) {
                req.getSession().removeAttribute("Alumno");                             //Si es que habia una sesion anterior, la elimina
                req.getSession().setAttribute("Alumno", AlumnoDAO.select(usuario));     //Mando directamente el alumno

                //Remuevo los atributos que vienen del form anterior
                req.removeAttribute("usuario");
                req.removeAttribute("contrasena");

                req.getRequestDispatcher("VistaAlumno/IndexAlumno.jsp").forward(req, resp);
            } else
                resp.sendRedirect("index.jsp");
        } else if ( usuario.toUpperCase().startsWith("P") && Character.isDigit( usuario.charAt(1) ) ) {
            
        }
    }
}
